package tad;

public class No<tipo> {
	public tipo dado;
	public No proximo;

	public No(tipo dado) {
		this.dado = dado;
		this.proximo = null;
	}
}