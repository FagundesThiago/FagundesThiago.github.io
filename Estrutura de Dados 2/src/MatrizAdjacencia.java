public class MatrizAdjacencia {
	private Integer matriz[][] = null;
	private int vertices;
	Integer[] visitados;
	Integer contador;

	public MatrizAdjacencia(int vertice[], int aresta[]) {
		this.matriz = new Integer[vertice[0]][vertice[0]];
		this.vertices = vertice[0];
		int controle;
		for (controle = 1; controle < aresta[0] + 1; controle++) {
			this.matriz[vertice[controle]][aresta[controle]] = 1;
		}
		for (controle = 0; controle < vertice[0]; controle++) {
			for (int controle2 = 0; controle2 < vertice[0]; controle2++) {
				if (this.matriz[controle][controle2] == null) {
					this.matriz[controle][controle2] = 0;
				}
			}
		}
	}

	public String buscaProfundidade() {
		this.visitados = null;
		this.visitados = new Integer[this.vertices];
		this.contador = 2;
		String resultado = new String();
		this.visitados[0] = 1;
		buscaProfundidadeRecursivo(0);
		resultado = resultado + "Visitados:\n";
		for (int controle = 0; controle < this.vertices; controle++) {
			resultado = resultado + controle + ": " + this.visitados[controle] + "\n";
		}
		return resultado;
	}

	public void buscaProfundidadeRecursivo(int indice) {
		int controle = 0;
		while (controle < vertices) {
			if (this.matriz[indice][controle] == 1) {
				if (this.visitados[controle] == null) {
					this.visitados[controle] = this.contador;
					this.contador++;
					buscaProfundidadeRecursivo(controle);
				}
			}
			controle++;
		}
	}

	public boolean verificarLaco() {
		int controle;
		for (controle = 1; controle < this.matriz[0][0]; controle++) {
			if (this.matriz[controle][controle] == 1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String print = "  | ";
		int controle, controle2;
		for (controle = 0; controle < this.vertices; controle++) {
			print = print + controle + " ";
		}
		print = print + "\n--+-";
		for (controle = 0; controle < ((this.vertices) * 2) + 1; controle++) {
			print = print + "-";
		}
		for (controle = 0; controle < this.vertices; controle++) {
			print = print + "\n" + controle + " | ";
			for (controle2 = 0; controle2 < this.vertices; controle2++) {
				print = print + this.matriz[controle][controle2] + " ";
			}
		}
		return print + "\n";
	}
}
