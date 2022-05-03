import java.io.DataInputStream;
import java.io.FileInputStream;
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
		while (menu != 4) {
			System.out.println("1 - Busca em profundidade\n2 - Busca em largura\n"
					+ "3 - Busca em profundidade na matriz de Adjacência\n4 - Encerrar");
			menu = entrada.nextInt();
			ListaAdjacencia lista = new ListaAdjacencia(vertice, aresta);
			switch (menu) {
			case 1:
				System.out.println(lista.buscaProfundidade());
				continue;
			case 2:
				System.out.println(lista.buscaLargura());
				continue;
			case 3:
				MatrizAdjacencia matriz = new MatrizAdjacencia(vertice, aresta);
				System.out.println(matriz.buscaProfundidade());
			}
		}
	}
}