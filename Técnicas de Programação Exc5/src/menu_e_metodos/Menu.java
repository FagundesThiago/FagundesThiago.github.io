package menu_e_metodos;

import java.util.Scanner;

import tad.FilaSimples;
import tad.PilhaSimples;

public class Menu {

	public static void main(String[] args) {
		Scanner entradaDoTeclado = new Scanner(System.in);
		Metodos teste = new Metodos();
		int opcaoDoMenu;
		do {
			System.out.println("\n#################################");
			System.out.println("1 - Verificar igualdade\n2 - Inversão de String"
					+ "\n3 - Verificar parênteses\n4 - Converter para poloneza reversa"
					+ "\n5 - Calcular\n6 - Três filas\n7 - Inverter fila\n8 - Sair\nEntre com a sua opção:");
			opcaoDoMenu = entradaDoTeclado.nextInt();
			entradaDoTeclado.nextLine();
			System.out.println("#################################");
			if (opcaoDoMenu == 1) {
				PilhaSimples<Integer> pilha1 = new PilhaSimples<>();
				PilhaSimples<Integer> pilha2 = new PilhaSimples<>();
				PilhaSimples<Character> pilha3 = new PilhaSimples<>();

				pilha1.empilhar(10);
				pilha1.empilhar(20);
				pilha2.empilhar(10);
				pilha2.empilhar(20);
				pilha3.empilhar('a');
				pilha3.empilhar('b');

				System.out.println("Primeiro teste: pilha1 == pilha2 ? " + teste.verificarIgualdade(pilha1, pilha2) + "\nSegundo teste: pilha1 == pilha3 ? "
						+ teste.verificarIgualdade(pilha1, pilha3));
			} else {
				if (opcaoDoMenu == 2) {
					System.out.println("String: alucarD -> " + teste.inverterString("alucarD"));
				} else {
					if (opcaoDoMenu == 3) {
						System.out.println("String: (10 x ( ( 20 - 30 ) / 40 )) -> "
								+ teste.verificarParenteses("(10 x ( ( 20 - 30 ) / 40 ))")
								+ "\nString: (10 x ( ( 20 - 30 ) / 40 ) -> "
								+ teste.verificarParenteses("(10 x ( ( 20 - 30 ) / 40 )"));

					} else {
						if (opcaoDoMenu == 4) {
							System.out.println("String: (10 x ( ( 20 - 30 ) / 40 )) -> "
									+ teste.converterPolonezaReversa("(10 x ( ( 20 - 30 ) / 40 ))"));

						} else {
							if (opcaoDoMenu == 5) {
								System.out.println("String: (10 x ( ( 20 - 30 ) / 40 )) -> ");
								teste.calculo("(10 x ( ( 20 - 30 ) / 40 ))");
							} else {
								if (opcaoDoMenu == 6) {
									FilaSimples<Integer> filaA = new FilaSimples<>();
									FilaSimples<Integer> filaB = new FilaSimples<>();
									FilaSimples<Integer> filaC = new FilaSimples<>();
									
									filaA.enfileirar(1);
									filaA.enfileirar(2);
									filaA.enfileirar(5);
									filaB.enfileirar(2);
									filaB.enfileirar(6);
									filaC.enfileirar(11);
									filaC.enfileirar(9);

									System.out.println("Antes: \n" + filaA.toString() + "\n" + filaB.toString() + "\n" + filaC.toString());
									teste.tresFilas(filaA, filaB, filaC);
									System.out.println("\n\nDepois: \n" + filaA.toString() + "\n" + filaB.toString() + "\n" + filaC.toString());
								} else {
									if (opcaoDoMenu == 7) {
										FilaSimples<Character> fila = new FilaSimples<>();
										
										fila.enfileirar('c');
										fila.enfileirar('a');
										fila.enfileirar('s');
										fila.enfileirar('a');
										
										System.out.println("Antes: \n" + fila.toString());
										teste.inverterFila(fila);
										System.out.println("\n\nDepois: \n" + fila.toString());
									}
								}
							}
						}
					}
				}
			}
		} while (opcaoDoMenu < 8);
	}
}