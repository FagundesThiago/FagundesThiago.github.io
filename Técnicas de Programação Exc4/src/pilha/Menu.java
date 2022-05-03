package pilha;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner entradaDoTeclado = new Scanner(System.in);
		System.out.println("\n1 - PilhaSimples\n2 - PilhaVetor\nEntre com a sua op��o:");
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
					"1 - Empilhar n�mero\n2 - Desempilhar n�mero" + "\n3 - Obter topo\n4 - Verificar se est� vazia"
							+ "\n5 - Listar conte�do\n6 - Sair\nEntre com a sua op��o:");
			opcaoDoMenu = entradaDoTeclado.nextInt();
			entradaDoTeclado.nextLine();
			System.out.println("#################################");
			if (opcaoDoMenu == 1) {
				System.out.println("Entre com o n�mero: ");
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
								System.out.println("A pilha n�o est� vazia.");
							} else {
								System.out.println("A pilha est� vazia.");
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