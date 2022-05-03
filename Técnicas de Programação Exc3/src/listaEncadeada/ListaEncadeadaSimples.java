package listaEncadeada;

public class ListaEncadeadaSimples implements ListaEncadeada{

	No inicio = null;
	
	@Override
	public void adicionarInicio(String dado) {
		No novoNo = new No(dado); 
		novoNo.proximo = this.inicio;
		this.inicio = novoNo;
	}
	
	@Override
	public void adicionarFim(String dado) {
		No novoNo = new No(dado);
		No noAtual = this.inicio;
		if (this.inicio != null) {
			while (noAtual.proximo != null) {
				noAtual = noAtual.proximo;
			}			
			noAtual.proximo = novoNo;
		}
		else {
			this.inicio = novoNo;
		}
	}
	
	@Override
	public boolean adicionarMeio(int posicaoInclusao, String dado) {
		No novoNo = new No(dado);
		No noAtual = this.inicio;
		No noAnterior = null;
		int posicaoAtual = 0;
			
		while ((noAtual != null) && (posicaoInclusao != posicaoAtual)) {
			noAnterior = noAtual;
			noAtual = noAtual.proximo;
			posicaoAtual++;
		}
		
		if (posicaoInclusao == posicaoAtual) {
			if (noAnterior == null) {
				novoNo.proximo = this.inicio;
				this.inicio = novoNo;
			}
			else {
				noAnterior.proximo = novoNo;
				novoNo.proximo = noAtual;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public boolean excluirInicio() {
		if (this.inicio != null) {
			this.inicio = this.inicio.proximo;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean excluirFim() {
		No noAtual = this.inicio;
		No noAnterior = null;
	
		if (this.inicio != null) {
			while (noAtual.proximo != null) {
				noAnterior = noAtual;
				noAtual = noAtual.proximo;
			}
			if (noAnterior != null) {
				noAnterior.proximo = null;
			}
			else {
				this.inicio = this.inicio.proximo;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public boolean excluirMeio(int posicaoExclusao) {
		No noAtual = this.inicio;
		No noAnterior = null;
		int posicaoAtual = 0;
		
		if (this.inicio != null) {
			while ((noAtual.proximo != null) && (posicaoExclusao != posicaoAtual)) {
				noAnterior = noAtual;
				noAtual = noAtual.proximo;
				posicaoAtual++;
			}
			if (posicaoExclusao == posicaoAtual) {
				if (noAnterior == null) {
					this.inicio = noAtual.proximo;
				}
				else {
					noAnterior.proximo = noAtual.proximo;
				}
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean excluirLista() {
		if (this.inicio != null) {
			this.inicio = null;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean excluirNome(String nome) {
		int posicao = buscarNome(nome);
		if (posicao != -1) {
			return excluirMeio(posicao);
		}
		return false;
	}
	
	@Override
	public int buscarNome(String nome) {
		Iterador iteradorListaEncadeada = obterIterador();
		int posicao = 0;
		while (iteradorListaEncadeada.temProximo()) {
			if (nome.equals(iteradorListaEncadeada.obterElemento())) {
				return posicao;
			}
			posicao++;
		}
		return -1;
	}

	@Override
	public String toString() {
		String elementos = new String();
		No noAtual = this.inicio;
		while (noAtual != null) {
			elementos = elementos + noAtual.dado + " "; 
			noAtual = noAtual.proximo;
		}
		return "ListaEncadeada [ "+ elementos + "]";
	}

	public Iterador obterIterador() {
		Iterador iterador = new Iterador(this.inicio);
		return iterador;
	}
	
}