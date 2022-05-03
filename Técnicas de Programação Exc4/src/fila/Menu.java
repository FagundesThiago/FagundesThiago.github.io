package fila;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner entradaDoTeclado = new Scanner(System.in);
		System.out.println("\n1 - FilaSimples\n2 - FilaVetor\nEntre com a sua op��o:");
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
					"1 - Enfileirar n�mero\n2 - Desenfileirar n�mero" + "\n3 - Obter frente\n4 - Verificar se est� vazia"
							+ "\n5 - Listar conte�do\n6 - Sair\nEntre com a sua op��o:");
			opcaoDoMenu = entradaDoTeclado.nextInt();
			entradaDoTeclado.nextLine();
			System.out.println("#################################");
			if (opcaoDoMenu == 1) {
				System.out.println("Entre com o n�mero: ");
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
								System.out.println("A fila n�o est� vazia.");
							} else {
								System.out.println("A fila est� vazia.");
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