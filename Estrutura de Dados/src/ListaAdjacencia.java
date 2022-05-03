public class ListaAdjacencia {
	private No[] lista = null;

	public ListaAdjacencia(int vertice[], int aresta[]) {
		this.lista = new No[vertice[0] + 1];
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

	@Override
	public String toString() {
		String elementos = new String(), listas = new String();
		No noAtual = null;
		int controle = 1;
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
		return listas + "**Obs.: Modelo sem duplicação de arestas!**\n";
	}
}
