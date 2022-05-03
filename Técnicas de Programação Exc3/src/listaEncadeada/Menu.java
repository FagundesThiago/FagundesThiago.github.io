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
					"1 - Inclusão de nome\n2 - Busca de nome\n3 - Exclusão de nome"
					+ "\n4 - Listagem dos nomes\n5 - Exclusão da lista\n6 - Sair\nEntre com a sua opção:");
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
						System.out.println("O nome buscado está na posição " + opcaoDoMenu + ".");
					}
					else { System.out.println("O nome buscado não foi encontrado.");}
				} else {
					if (opcaoDoMenu == 3) {
						System.out.println("Entre com o nome a ser excluído: ");
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
		System.out.println("1 - Incluir no início\n2 - Incluir no meio\n3 - incluir no fim\nEntre com a sua opção:");
		int opcaoDoMenu = entradaDoTeclado.nextInt();
		System.out.println("Entre com o nome a ser incluido: ");
		entradaDoTeclado.nextLine();
		String nome = entradaDoTeclado.nextLine();
		switch (opcaoDoMenu) {
			case 1:
				listaEncadeada.adicionarInicio(nome);
				break;
			case 2:
				System.out.println("Entre com a posição: ");
				opcaoDoMenu = entradaDoTeclado.nextInt();
				listaEncadeada.adicionarMeio(opcaoDoMenu, nome);
				break;
			case 3:
				listaEncadeada.adicionarFim(nome);
				break;
		}
	}
}
