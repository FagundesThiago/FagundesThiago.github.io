package fila;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner entradaDoTeclado = new Scanner(System.in);
		System.out.println("\n1 - FilaSimples\n2 - FilaVetor\nEntre com a sua opção:");
		int opcaoDoMenu = entradaDoTeclado.nextInt();
		entradaDoTeclado.nextLine();
		Fila fila;
		if(opcaoDoMenu == 1) {
			fila = new FilaSimples();
		} else {
			fila = new FilaVetor();
		}
		do {
			System.out.println("\n#################################");
			System.out.println(
					"1 - Enfileirar número\n2 - Desenfileirar número" + "\n3 - Obter frente\n4 - Verificar se está vazia"
							+ "\n5 - Listar conteúdo\n6 - Sair\nEntre com a sua opção:");
			opcaoDoMenu = entradaDoTeclado.nextInt();
			entradaDoTeclado.nextLine();
			System.out.println("#################################");
			if (opcaoDoMenu == 1) {
				System.out.println("Entre com o número: ");
				fila.enfileirar(entradaDoTeclado.nextInt());
			} else {
				if (opcaoDoMenu == 2) {
					System.out.println(fila.desenfileirar());
				} else {
					if (opcaoDoMenu == 3) {
						System.out.println(fila.obterFrente());
					} else {
						if (opcaoDoMenu == 4) {
							boolean n = fila.verificarConteudo();
							if (n) {
								System.out.println("A fila não está vazia.");
							} else {
								System.out.println("A fila está vazia.");
							}
						} else {
							if (opcaoDoMenu == 5) {
								System.out.println(fila.toString());
							}
						}
					}
				}
			}
		} while (opcaoDoMenu < 6);
	}
}