package pilha;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner entradaDoTeclado = new Scanner(System.in);
		System.out.println("\n1 - PilhaSimples\n2 - PilhaVetor\nEntre com a sua opção:");
		int opcaoDoMenu = entradaDoTeclado.nextInt();
		entradaDoTeclado.nextLine();
		Pilha pilha;
		if(opcaoDoMenu == 1) {
			pilha = new PilhaSimples();
		} else {
			pilha = new PilhaVetor();
		}
		do {
			System.out.println("\n#################################");
			System.out.println(
					"1 - Empilhar número\n2 - Desempilhar número" + "\n3 - Obter topo\n4 - Verificar se está vazia"
							+ "\n5 - Listar conteúdo\n6 - Sair\nEntre com a sua opção:");
			opcaoDoMenu = entradaDoTeclado.nextInt();
			entradaDoTeclado.nextLine();
			System.out.println("#################################");
			if (opcaoDoMenu == 1) {
				System.out.println("Entre com o número: ");
				pilha.empilhar(entradaDoTeclado.nextInt());
			} else {
				if (opcaoDoMenu == 2) {
					System.out.println(pilha.desempilhar());
				} else {
					if (opcaoDoMenu == 3) {
						System.out.println(pilha.obterTopo());
					} else {
						if (opcaoDoMenu == 4) {
							boolean n = pilha.verificarConteudo();
							if (n) {
								System.out.println("A pilha não está vazia.");
							} else {
								System.out.println("A pilha está vazia.");
							}
						} else {
							if (opcaoDoMenu == 5) {
								System.out.println(pilha.toString());
							}
						}
					}
				}
			}
		} while (opcaoDoMenu < 6);
	}
}