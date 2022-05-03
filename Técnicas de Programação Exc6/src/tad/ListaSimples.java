package tad;

import tad.No;

public class ListaSimples<tipo> implements Lista<tipo> {

	No inicio = null;

	@Override
	public boolean inserirAlgo(tipo dado) {
		No novoNo = new No(dado);
		No noAtual = this.inicio;
		if (this.inicio != null) {
			while (noAtual.proximo != null) {
				noAtual = noAtual.proximo;
			}
			noAtual.proximo = novoNo;
			return true;
		} else {
			if (this.inicio == null) {
				this.inicio = novoNo;
				return true;
			}
			return false;
		}
	}

	@Override
	public boolean removerAlgo(tipo algo) {
		No noAtual = this.inicio;
		No noAnterior = noAtual;

		if (this.inicio != null) {
			if (this.inicio.proximo != null) {
				if (noAtual.dado.equals(algo)) {
					this.inicio = this.inicio.proximo;
					return true;
				}
				while (noAtual != null) {
					if (noAtual.dado.equals(algo)) {
						noAnterior.proximo = noAtual.proximo;
						return true;
					}
					noAnterior = noAtual;
					noAtual = noAtual.proximo;
				}
			} else {
				if (this.inicio.proximo == null && this.inicio.dado.equals(algo)) {
					this.inicio = null;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String buscarAlgo(tipo algo) {
		No noAtual = this.inicio;
		while (noAtual != null) {
			if (noAtual.dado.equals(algo)) {
				return "Encontrado";
			}
			noAtual = noAtual.proximo;
		}
		return "Não foi encontrado";
	}

	@Override
	public String toString() {
		if (this.inicio == null) {
			return "null";
		}
		String elementos = new String();
		No noAtual = this.inicio.proximo;
		elementos = " " + this.inicio.dado;
		while (noAtual != null) {
			elementos = elementos + ", " + noAtual.dado;
			noAtual = noAtual.proximo;
		}
		return "Lista [" + elementos + " ]";
	}
}