public class main {

	public static void main(String[] args) {
		System.out.println("Instanciando um Heap L = {94, 59, 77, 38, 27, 65, 69, 32}");
		int[] n = { 0, 94, 59, 77, 38, 27, 65, 69, 32 };
		Heap h = new Heap(8, n);
		h.inserir(75);
		h.inserir(98);
		h.remover();
		h.remover();
		System.out.println("\nResultado após inserir 75, inserir 78, remover e remover:\n" + h.showHeap());

		System.out.println("\n--/--\n\nInstanciando um Heap L =  {63, 33, 94, 47, 82, 80, 53, 61}");
		int[] n2 = { 0, 63, 33, 94, 47, 82, 80, 53, 61 };
		Heap h2 = new Heap(8, n2);
		h2.arranjar();
		System.out.println("\nResultado após arranjar:\n" + h2.showHeap());
	}
}