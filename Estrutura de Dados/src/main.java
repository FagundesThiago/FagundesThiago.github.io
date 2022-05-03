import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {

		FileInputStream arquivoDeEntrada = null;
		try {
			arquivoDeEntrada = new FileInputStream("Grafo.txt");
		} catch (FileNotFoundException e1) {
			System.out.println("Arquivo não encontrado!");
		}

		DataInputStream arquivoDeEntradaFiltrado = new DataInputStream(arquivoDeEntrada);
		StringBuffer inputLine = new StringBuffer();
		String arquivoParticionado[] = null, temporaria;
		try {
			while ((temporaria = arquivoDeEntradaFiltrado.readLine()) != null) {
				inputLine.append(temporaria + "\n");
			}
			arquivoParticionado = inputLine.toString().split("\n");
			arquivoDeEntradaFiltrado.close();
		} catch (IOException e) {
			System.out.println("Erro de IO ao fechar arquivo!");
			e.printStackTrace();
		}

		int vertice[] = new int[arquivoParticionado.length], aresta[] = new int[arquivoParticionado.length], controle;
		for (controle = 0; controle < arquivoParticionado.length; controle++) {
			String auxiliar2[] = arquivoParticionado[controle].split(" ");
			vertice[controle] = Integer.parseInt(auxiliar2[0]);
			aresta[controle] = Integer.parseInt(auxiliar2[1]);
		}

		Scanner entrada = new Scanner(System.in);
		int menu = 0;
		while (menu != 6) {
			System.out.println("Escolha a opcão na qual deseja exibir o arquivo 'Grafo.txt':\n"
					+ "1 - Lista de Adjacência \n2 - Matriz de Adjacência \n3 - Matriz de Incidência"
					+ "\n4 - Verificar laço da Matriz de Adjacência \n5 - Contar grau na Matriz de Incidência"
					+ "\n6 - Sair");
			menu = entrada.nextInt();
			switch (menu) {
			case 1:
				ListaAdjacencia print = new ListaAdjacencia(vertice, aresta);
				System.out.println(print.toString());
				continue;
			case 2:
				MatrizAdjacencia print1 = new MatrizAdjacencia(vertice, aresta);
				System.out.println(print1.toString());
				continue;
			case 3:
				MatrizIncidencia print2 = new MatrizIncidencia(vertice, aresta);
				System.out.println(print2.toString());
				continue;
			case 4:
				MatrizAdjacencia print4 = new MatrizAdjacencia(vertice, aresta);
				System.out.println("Há algum laço? " + print4.verificarLaco() + "\n");
				continue;
			case 5:
				MatrizIncidencia print5 = new MatrizIncidencia(vertice, aresta);
				System.out.println(print5.contarGraus());
			}
		}
	}

}
