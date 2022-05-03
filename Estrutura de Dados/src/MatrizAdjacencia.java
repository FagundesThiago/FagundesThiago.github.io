public class MatrizAdjacencia {
	private Integer matriz[][] = null;

	public MatrizAdjacencia(int vertice[], int aresta[]) {
		this.matriz = new Integer[vertice[0] + 1][vertice[0] + 1];
		this.matriz[0][0] = vertice[0];
		int controle;
		for (controle = 1; controle < aresta[0] + 1; controle++) {
			this.matriz[vertice[controle]][aresta[controle]] = 1;
			this.matriz[aresta[controle]][vertice[controle]] = 1;
		}
		for (controle = 1; controle < vertice[0] + 1; controle++) {
			for (int controle2 = 1; controle2 < vertice[0] + 1; controle2++) {
				if (this.matriz[controle][controle2] == null) {
					this.matriz[controle][controle2] = 0;
				}
			}
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
		for (controle = 1; controle < this.matriz[0][0] + 1; controle++) {
			print = print + controle + " ";
		}
		print = print + "\n--+-";
		for (controle = 1; controle < ((this.matriz[0][0]) * 2) + 1; controle++) {
			print = print + "-";
		}
		for (controle = 1; controle < this.matriz[0][0] + 1; controle++) {
			print = print + "\n" + controle + " | ";
			for (controle2 = 1; controle2 < this.matriz[0][0] + 1; controle2++) {
				print = print + this.matriz[controle][controle2] + " ";
			}
		}
		return print + "\n";
	}
}
