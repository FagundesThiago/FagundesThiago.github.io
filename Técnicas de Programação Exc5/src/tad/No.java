package tad;

public class No<tipo> {
	public tipo dado;
	public No anterior;

	public No(tipo dado) {
		this.dado = dado;
		this.anterior = null;
	}
}