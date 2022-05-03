package listaEncadeada;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner entradaDoTeclado = new Scanner(System.in);
		ListaEncadeadaSimples listaEncadeada = new ListaEncadeadaSimples();
		int opcaoDoMenu;
		do {
			System.out.println("\n#################################");
			System.out.println(
					"1 - Inclus�o de nome\n2 - Busca de nome\n3 - Exclus�o de nome"
					+ "\n4 - Listagem dos nomes\n5 - Exclus�o da lista\n6 - Sair\nEntre com a sua op��o:");
			opcaoDoMenu = entradaDoTeclado.nextInt();
			entradaDoTeclado.nextLine();
			System.out.println("#################################");
			if (opcaoDoMenu == 1) {
				inclusaoNome(listaEncadeada);
			} else {
				if (opcaoDoMenu == 2) {
					System.out.println("Entre com o nome a buscado: ");
					String nome = entradaDoTeclado.nextLine();
					if (listaEncadeada.buscarNome(nome) != -1) {
						System.out.println("O nome buscado est� na posi��o " + opcaoDoMenu + ".");
					}
					else { System.out.println("O nome buscado n�o foi encontrado.");}
				} else {
					if (opcaoDoMenu == 3) {
						System.out.println("Entre com o nome a ser exclu�do: ");
						String nome = entradaDoTeclado.nextLine();
						System.out.println(listaEncadeada.excluirNome(nome));
					} else {
						if (opcaoDoMenu == 4) {
							Iterador iteradorListaEncadeada = listaEncadeada.obterIterador();
							while (iteradorListaEncadeada.temProximo()) {
								System.out.println(iteradorListaEncadeada.obterElemento());
							}
						} else {
							if (opcaoDoMenu == 5) {
								System.out.println(listaEncadeada.excluirLista());
							}
						}
					}
				}
			}
		} while (opcaoDoMenu < 6);
	}
	
	static void inclusaoNome(ListaEncadeadaSimples listaEncadeada) {
		Scanner entradaDoTeclado = new Scanner(System.in);
		System.out.println("1 - Incluir no in�cio\n2 - Incluir no meio\n3 - incluir no fim\nEntre com a sua op��o:");
		int opcaoDoMenu = entradaDoTeclado.nextInt();
		System.out.println("Entre com o nome a ser incluido: ");
		entradaDoTeclado.nextLine();
		String nome = entradaDoTeclado.nextLine();
		switch (opcaoDoMenu) {
			case 1:
				listaEncadeada.adicionarInicio(nome);
				break;
			case 2:
				System.out.println("Entre com a posi��o: ");
				opcaoDoMenu = entradaDoTeclado.nextInt();
				listaEncadeada.adicionarMeio(opcaoDoMenu, nome);
				break;
			case 3:
				listaEncadeada.adicionarFim(nome);
				break;
		}
	}
}
