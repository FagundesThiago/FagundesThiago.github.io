package listaEncadeada;

public class Iterador {

	No noAtual; 
	
	public Iterador(No no) {
		this.noAtual = no;
	}
	
	public boolean temProximo() {
		if (this.noAtual != null) {
			return true;
		}
		return false;
	}
	
	public String obterElemento() {
		No auxiliar = this.noAtual;
		this.noAtual = this.noAtual.proximo;
		return auxiliar.dado;
	}
}
