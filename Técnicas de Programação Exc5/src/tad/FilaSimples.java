package tad;

public class FilaSimples<tipo> implements Fila<tipo> {

	No frente = null;
	int quantidade = 0;

	@Override
	public boolean enfileirar(tipo dado) {
		No novoNo = new No(dado);
		No noAtual = this.frente;
		if (this.frente != null && quantidade < 20) {
			while (noAtual.anterior != null) {
				noAtual = noAtual.anterior;
			}
			noAtual.anterior = novoNo;
			quantidade++;
			return true;
		} else {
			if (this.frente == null) {
				this.frente = novoNo;
				quantidade++;
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public String desenfileirar() {
		No noAtual = this.frente;
		if (this.frente != null) {
			if (this.frente.anterior != null) {
				this.frente = this.frente.anterior;
			} else {
				this.frente = null;
			}
			quantidade--;
			return String.valueOf(noAtual.dado);
		}
		return "Fila vazia.";
	}

	@Override
	public String obterFrente() {
		if (this.frente != null) {
			return String.valueOf(this.frente.dado);
		}
		return "Fila vazia.";
	}

	@Override
	public int verificarConteudo() {
		return quantidade;
	}

	@Override
	public String toString() {
		String elementos = new String();
		No noAtual = this.frente;
		while (noAtual != null) {
			elementos = elementos + noAtual.dado + " ";
			noAtual = noAtual.anterior;
		}
		return "Fila [ " + elementos + "]";
	}
}