public class ListaAdjacencia {
	private No[] lista = null;
	Integer[] visitados;
	Integer contador;

	public ListaAdjacencia(int vertice[], int aresta[]) {
		this.lista = new No[vertice[0]];
		int controle = 1;
		while (controle < vertice.length) {
			inserirAlgo(vertice[controle], aresta[controle]);
			controle++;
		}
	}

	public void inserirAlgo(int indice, int dado) {
		if (this.lista[indice] != null) {
			No noAtual = this.lista[indice];
			while (noAtual.getProximo() != null) {
				noAtual = noAtual.getProximo();
			}
			noAtual.setProximo(new No(dado));
		} else {
			this.lista[indice] = new No(dado);
		}
	}

	public String buscaProfundidade() {
		this.visitados = null;
		this.visitados = new Integer[this.lista.length];
		this.contador = 2;
		String resultado = new String();
		this.visitados[0] = 1;
		buscaProfundidadeRecursivo(0);
		resultado = resultado + "Visitados:\n";
		for (int controle = 0; controle < this.lista.length; controle++) {
			resultado = resultado + controle + ": " + this.visitados[controle] + "\n";
		}
		return resultado;
	}

	public void buscaProfundidadeRecursivo(int indice) {
		No noAtual = this.lista[indice];
		while (noAtual != null) {
			if (this.visitados[noAtual.getDado()] == null) {
				this.visitados[noAtual.getDado()] = this.contador;
				this.contador++;
				buscaProfundidadeRecursivo(noAtual.getDado());
			}
			noAtual = noAtual.getProximo();
		}
	}

	public String buscaLargura() {
		String resultado = "Fila: ";
		FilaSimples fila = new FilaSimples();
		fila.enfileirar(0);
		boolean fim = false;
		No noAtual = null;
		this.contador = 2;
		this.visitados = null;
		this.visitados = new Integer[this.lista.length];
		this.visitados[0] = 1;
		while (fim == false) {
			if (this.lista[fila.obterFrente().getDado()] != null) {
				noAtual = this.lista[fila.obterFrente().getDado()];
				while (noAtual != null) {
					if (visitados[noAtual.getDado()] == null) {
						fila.enfileirar(noAtual.getDado());
						visitados[noAtual.getDado()] = contador;
					}
					noAtual = noAtual.getProximo();
				}
			}
			if (fila.obterFrente() != null & fila.obterFrente().getProximo() != null) {
				if (visitados[fila.obterFrente().getDado()] != visitados[fila.obterFrente().getProximo().getDado()]) {
					contador++;
				}
			}
			resultado = resultado + fila.desenfileirar() + " ";
			if (fila.obterFrente() == null) {
				fim = true;
			}
		}
		resultado = resultado + "\n\nVisitados:\n";
		for (int controle = 0; controle < this.lista.length; controle++) {
			resultado = resultado + controle + ": " + this.visitados[controle] + "\n";
		}
		return resultado;
	}

	@Override
	public String toString() {
		String elementos = new String(), listas = new String();
		No noAtual = null;
		int controle = 0;
		while (controle < this.lista.length) {
			if (this.lista[controle] != null) {
				noAtual = this.lista[controle];
				elementos = noAtual.getDado() + " ";
				;
				while (noAtual.getProximo() != null) {
					elementos = elementos + noAtual.getProximo().getDado() + " ";
					noAtual = noAtual.getProximo();
				}
			} else {
				elementos = "Sem Arestas. ";
			}
			listas = listas + "Vértice " + controle + " [ " + elementos + "]\n";
			controle++;
		}
		return listas;
	}
}
