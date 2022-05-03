public class FilaSimples {

	No frente = null;
	int quantidade = 0;

	public boolean enfileirar(int dado) {
		No novoNo = new No(dado);
		No noAtual = this.frente;
		if (this.frente != null && quantidade < 20) {
			while (noAtual.getProximo() != null) {
				noAtual = noAtual.getProximo();
			}
			noAtual.setProximo(novoNo);
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

	public String desenfileirar() {
		No noAtual = this.frente;
		if (this.frente != null) {
			if (this.frente.getProximo() != null) {
				this.frente = this.frente.getProximo();
			} else {
				this.frente = null;
			}
			quantidade--;
			return String.valueOf(noAtual.getDado());
		}
		return "Fila vazia.";
	}

	public No obterFrente() {
		if (this.frente != null) {
			return this.frente;
		}
		return null;
	}

	public int verificarConteudo() {
		return quantidade;
	}

	@Override
	public String toString() {
		String elementos = new String();
		No noAtual = this.frente;
		while (noAtual != null) {
			elementos = elementos + noAtual.getDado() + " ";
			noAtual = noAtual.getProximo();
		}
		return "Fila [ " + elementos + "]";
	}
}