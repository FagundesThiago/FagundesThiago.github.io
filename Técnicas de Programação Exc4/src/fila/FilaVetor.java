package fila;

public class FilaVetor implements Fila {

	private int[] fila = new int[20];
	private int frente = 0;
	private int finalFila = -1;

	@Override
	public boolean enfileirar(int dado) {
		try {
			this.fila[this.finalFila + 1] = dado;
			this.finalFila++;
			return true;
		} catch(ArrayIndexOutOfBoundsException e)	{
			andarFila();
			if (this.finalFila < 19) {
				this.finalFila++;
				this.fila[this.finalFila] = dado;
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public String desenfileirar() {
		if (this.finalFila != -1) {
			int noAtual = this.fila[this.frente];
			if(this.frente == this.finalFila) {
				this.frente = 0;
				this.finalFila = -1;
				return String.valueOf(noAtual);
			} else {
				this.frente++;
				return String.valueOf(noAtual);
			}
		}
		return "Fila vazia.";
	}

	@Override
	public String obterFrente() {
		if (this.finalFila != -1) {
			return String.valueOf(this.fila[this.frente]);
		}
		return "Fila vazia.";
	}

	@Override
	public boolean verificarConteudo() {
		if (this.finalFila != -1) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String elementos = new String();
		int controle = this.frente;
		while (controle <= this.finalFila) {
			elementos = elementos + this.fila[controle] + " ";
			controle++;
		}
		return "Fila [ " + elementos + "]";
	}
	
	public void andarFila() {
		int controle = 0;
		while(this.frente + controle < this.finalFila) {
			this.fila[controle] = this.fila[this.frente + controle];
			controle++;
		}
		this.frente = 0;
		this.finalFila = controle;
	}
}