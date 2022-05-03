package menu_e_metodos;

import tad.ListaSimples;

public class HashTable<tipo> {

	ListaSimples[] listaArray;

	public HashTable(int tamanho) {
		this.listaArray = new ListaSimples[tamanho];
	}

	public int hashCode(tipo algo) {
		try {
			return Integer.parseInt(algo.toString()) % this.listaArray.length;
		} catch (Exception e) {
			try {
				return (int) Float.parseFloat(algo.toString()) % this.listaArray.length;
			} catch (Exception e1) {
				return obterValorString(algo.toString()) % this.listaArray.length;
			}
		}
	}

	public int obterValorString(String algo) {
		if (!algo.isEmpty()) {
			int controle = 0, calculo = 0;
			while (controle < algo.length()) {
				calculo = calculo + ((int) algo.charAt(controle) * (controle + 1));
				controle++;
			}
			return calculo / algo.length();
		}
		return 0;
	}

	public void inserirAlgo(tipo algo) {
		int valor = hashCode(algo);
		if (valor == -1) {
			System.out.println("Erro!");
		} else {
			if (this.listaArray[valor] == null) {
				this.listaArray[valor] = new ListaSimples();
				System.out.println(this.listaArray[valor].inserirAlgo(algo));
			} else {
				System.out.println(this.listaArray[valor].inserirAlgo(algo));
			}
		}
	}

	public String buscarAlgo(tipo algo) {
		int valor = hashCode(algo);
		if (valor != -1 && listaArray[valor] != null) {
			return this.listaArray[valor].buscarAlgo(algo);
		}
		return "Não foi encontrado";
	}

	public boolean removerAlgo(tipo algo) {
		int valor = hashCode(algo);
		if (valor != -1 && listaArray[valor] != null) {
			return this.listaArray[valor].removerAlgo(algo);
		}
		return false;
	}

	/*
	 * Se é só para usar o equals, não precisaria de um método para isso, mas já que
	 * o senhor pediu na atividade, aqui está.
	 */ public boolean compararObjetos(tipo algo1, tipo algo2) {
		return algo1.equals(algo2);
	}

	@Override
	public String toString() {
		int controle = 0;
		String algo = "\n*****\n";
		while (controle < this.listaArray.length) {
			algo = algo + "\nArray " + controle + ": " + this.listaArray[controle];
			controle++;
		}
		return algo = algo + "\n\n*****";
	}

}
