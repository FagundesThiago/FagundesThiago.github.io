public class Heap {
	private int n;
	private int m;
	private int[] l;

	public Heap(int nn, int ll[]) {
		this.n = nn;
		int ctrl = this.n, aux = 0;
		while (ctrl > 0) {
			aux++;
			ctrl = ctrl / 2;
		}
		this.m = (int) (Math.pow(2, aux) - 1);
		this.l = new int[this.m + 1];
		for (ctrl = 1; ctrl <= this.n; ctrl++) {
			this.l[ctrl] = ll[ctrl];
		}
	}

	public String showHeap() {
		if (this.n >= 1) {
			String lista = "L = {" + this.l[1];
			for (int ctrl = 2; ctrl <= this.n; ctrl++) {
				lista = lista + ", " + this.l[ctrl];
			}
			return lista + "}";
		}
		return "L = {}";
	}

	public void arranjar() {
		for (int i = (n / 2); i >= 1; i--) {
			descer(i);
		}
	}

	public void inserir(int novo) {
		if (this.n < this.m) {
			this.l[n + 1] = novo;
			n = n + 1;
			subir(n);
		} else {
			System.out.println("Overflow");
		}
	}

	public void subir(int i) {
		int j = i / 2;
		if (j >= 1) {
			if (this.l[i] > this.l[j]) {
				int aux = this.l[j];
				this.l[j] = this.l[i];
				this.l[i] = aux;
				subir(j);
			}
		}
	}

	public void descer(int i) {
		int j = 2 * i;
		if (j <= n) {
			if (j < n) {
				if (this.l[j + 1] > this.l[j]) {
					j = j + 1;
				}
			}
			if (this.l[j] > this.l[i]) {
				int aux = this.l[j];
				this.l[j] = this.l[i];
				this.l[i] = aux;
				descer(j);
			}
		}
	}

	public void remover() {
		if (this.n != 0) {
			this.l[1] = this.l[n];
			this.n = this.n - 1;
			descer(1);
		} else {
			System.out.println("Underflow");
		}
	}
}
