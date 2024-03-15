package boardgame;

public class Piece {
//	essa posição ainda não é a posição do xadrez, é uma posição simples de matriz
	protected Position position;
//	a peça e o tabuleiro estão associados
	private Board board;
	
	
	
//	não passamos a posição pq a posição de uma peça recém-criada vai ser nula (ainda não foi colocada no tabuleiro)
	public Piece(Board board) {
		this.board = board;
//		por padrão o java já atribui o valor nulo, escrevemos apenas para enfatizar
		position = null;
	}



//	vamos deixar ele protected para que apenas classes do mesmo pacote e subclasses possam acessar o método
	protected Board getBoard() {
		return board;
	}
//	não escrevemos o set pq não vamos permitir q o tabuleiro seja alterado
}