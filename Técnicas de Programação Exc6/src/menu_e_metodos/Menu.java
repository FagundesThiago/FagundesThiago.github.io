package menu_e_metodos;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner entradaDoTeclado = new Scanner(System.in);
		int opcaoDoMenu;
		System.out.println("Insira o tamanho desejado para o Array: ");
		opcaoDoMenu = entradaDoTeclado.nextInt();
		HashTable teste = new HashTable(opcaoDoMenu);
		do {
			System.out.println("\n#################################");
			System.out.println("1 - Inserir algo\n2 - Buscar"
					+ "\n3 - Remover\n4 - Visualizar conteúdo\n5 - Sair\nEntre com a sua opção:");
			opcaoDoMenu = entradaDoTeclado.nextInt();
			entradaDoTeclado.nextLine();
			System.out.println("#################################");
			if (opcaoDoMenu == 1) {
				System.out.println("Digite o que deseja inserir: ");
				teste.inserirAlgo(entradaDoTeclado.nextLine());
			} else {
				if (opcaoDoMenu == 2) {
					System.out.println("Digite o que deseja buscar: ");
					System.out.println(teste.buscarAlgo(entradaDoTeclado.nextLine()));
				} else {
					if (opcaoDoMenu == 3) {
						System.out.println("Digite o que deseja excluir: ");
						System.out.println(teste.removerAlgo(entradaDoTeclado.nextLine()));
					} else {
						if (opcaoDoMenu == 4) {
							System.out.println(teste.toString());
						}
					}
				}
			}
		} while (opcaoDoMenu != 5);
	}
}