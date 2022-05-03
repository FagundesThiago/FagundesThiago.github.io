public class MatrizIncidencia {
	private Integer matriz[][] = null;
	private int arestas = 0;

	public MatrizIncidencia(int vertice[], int aresta[]) {
		this.matriz = new Integer[vertice[0] + 1][aresta[0] + 1];
		this.matriz[0][0] = vertice[0];
		this.arestas = aresta[0];
		int controle;
		for (controle = 1; controle < aresta[0] + 1; controle++) {
			this.matriz[vertice[controle]][controle] = 1;
			this.matriz[aresta[controle]][controle] = 1;
		}
		for (controle = 1; controle < vertice[0] + 1; controle++) {
			for (int controle2 = 1; controle2 < this.arestas + 1; controle2++) {
				if (this.matriz[controle][controle2] == null) {
					this.matriz[controle][controle2] = 0;
				}
			}
		}
	}
	
	public String contarGraus() {
		String print = "";
		int controle, controle2, contagem;
		for (controle = 1; controle < this.matriz[0][0] + 1; controle++) {
			contagem = 0;
			for (controle2 = 1; controle2 < this.arestas + 1; controle2++) {
				if (this.matriz[controle][controle2] == 1) {
					contagem++;
				}
			}
			print = print + "Vértice " + controle + " tem grau: " + contagem + "\n";
		}
		return print;
	}

	@Override
	public String toString() {
		String print = "  | ";
		int controle, controle2, controle3;
		for (controle = 1; controle < this.matriz[0][0] + 1; controle++) {
			for (controle2 = controle; controle2 < this.arestas + 1; controle2++) {
				if (this.matriz[controle][controle2] != 0) {
					for (controle3 = controle + 1; controle3 < this.matriz[0][0] + 1; controle3++) {
						if (this.matriz[controle3][controle2] != 0) {
							print = print + "{" + controle + "," + controle3 + "} ";
						}
					}
				}
			}
		}
		print = print + "\n--+-";
		for (controle = 1; controle < ((this.arestas) * 5) + this.arestas; controle++) {
			print = print + "-";
		}
		for (controle = 1; controle < this.matriz[0][0] + 1; controle++) {
			print = print + "\n" + controle + " |   ";
			for (controle2 = 1; controle2 < this.arestas + 1; controle2++) {
				print = print + this.matriz[controle][controle2] + "     ";
			}
		}
		return print + "\n";
	}
}
