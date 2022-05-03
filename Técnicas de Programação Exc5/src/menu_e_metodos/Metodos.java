package menu_e_metodos;

import tad.PilhaSimples;

import java.util.Arrays;

import tad.FilaSimples;


public class Metodos {

	public int verificarIgualdade(PilhaSimples pilhaA, PilhaSimples pilhaB) {
		if (pilhaA.toString().equals(pilhaB.toString())) {
			return 1;
		}
		return 0;
	}

	public String inverterString(String palavra) {
		if (palavra.length() <= 20) {
			int controle = 0;
			PilhaSimples<Character> pilha = new PilhaSimples<>();
			while (controle < palavra.length()) {
				pilha.empilhar(palavra.charAt(controle));
				controle++;
			}
			palavra = "";
			while (controle > 0) {
				palavra = palavra + pilha.desempilhar();
				controle--;
			}
			return palavra;
		}
		return "Erro!";
	}

	public boolean verificarParenteses(String palavra) {
		if (palavra != null) {
			int controle = 0;
			PilhaSimples<Character> pilha = new PilhaSimples<>();
			while (controle < palavra.length()) {
				if (palavra.charAt(controle) == '(') {
					pilha.empilhar(palavra.charAt(controle));
				}
				if (palavra.charAt(controle) == ')') {
					pilha.desempilhar();
				}
				controle++;
			}
			if (pilha.verificarConteudo() == 0) {
				return true;
			}
		}
		return false;
	}

	public String converterPolonezaReversa(String palavra) {
		if (verificarParenteses(palavra)) {
			int controle = 0;
			String novaPalavra = new String();
			PilhaSimples<Character> pilha = new PilhaSimples<>();
			while (controle < palavra.length()) {
				if (palavra.charAt(controle) != '(' && palavra.charAt(controle) != ' ') {
					if (palavra.charAt(controle) == '+' || palavra.charAt(controle) == '-'
							|| palavra.charAt(controle) == 'x' || palavra.charAt(controle) == 'X'
							|| palavra.charAt(controle) == '/') {
						pilha.empilhar(palavra.charAt(controle));
						novaPalavra = novaPalavra + " ";
					} else {
						if (palavra.charAt(controle) == ')') {
							novaPalavra = novaPalavra + " " + pilha.desempilhar();
						} else {
							novaPalavra = novaPalavra + palavra.charAt(controle);
						}
					}
				}
				controle++;
			}
			return novaPalavra;
		}
		return "Erro!";
	}

	public void calculo(String palavra) {
		palavra = converterPolonezaReversa(palavra);
		String palavraDividida[] = palavra.split(" ");
		PilhaSimples<Float> fila = new PilhaSimples<>();
		int controle = 0;
		float n, n2;
		while (controle < palavraDividida.length) {
			try {
				fila.empilhar(Float.parseFloat(palavraDividida[controle]));
			} catch (NumberFormatException e) {
				if (palavraDividida[controle].equals("+")) {
					n = Float.parseFloat(fila.desempilhar());
					fila.empilhar(Float.parseFloat(fila.desempilhar()) + n);
				} else {
					if (palavraDividida[controle].equals("-")) {
						n = Float.parseFloat(fila.desempilhar());
						fila.empilhar(Float.parseFloat(fila.desempilhar()) - n);
					} else {
						if (palavraDividida[controle].equalsIgnoreCase("x")) {
							n = Float.parseFloat(fila.desempilhar());
							fila.empilhar(Float.parseFloat(fila.desempilhar()) * n);
						} else {
							if (palavraDividida[controle].equals("/")) {
								n = Float.parseFloat(fila.desempilhar());
								fila.empilhar(Float.parseFloat(fila.desempilhar()) / n);
							}
						}
					}
				}
			}
			controle++;
		}
		System.out.println("O resultado é: " + fila.desempilhar());
	}
	
	public void tresFilas(FilaSimples<Integer> filaA, FilaSimples<Integer> filaB, FilaSimples<Integer> filaC) {
		FilaSimples<Integer> filaAuxiliar = new FilaSimples();
		String palavra[] = filaA.toString().split(" ");
		int controle = 2, n;
		while(controle < filaA.verificarConteudo() + 2) {
			n = Integer.parseInt(palavra[controle]);
			filaAuxiliar.enfileirar(n);
			if (n%2 == 0) {
				filaB.enfileirar(n);
			} else {
				filaC.enfileirar(n);
			}
			controle++;
		}
	}
	
	public void inverterFila(FilaSimples fila) {
		PilhaSimples pilha = new PilhaSimples();
		while(fila.verificarConteudo() > 0) {
			pilha.empilhar(fila.desenfileirar());
		}
		while(pilha.verificarConteudo() > 0) {
			fila.enfileirar(pilha.desempilhar());
		}
	}
}
