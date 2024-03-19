package chess;

import java.util.ArrayList;
import java.util.List;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
//	é nessa classe q vai estar as regras do xadrez
	private Board board;
	private int turn;
	private Color currentPlayer;
	
	private List<ChessPiece> alivePieces = new ArrayList<>();
	private List<ChessPiece> capturedPieces = new ArrayList<>();

	public ChessMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
	}
	
	public int getTurn() {
		return turn;
	}
	
	public Color getCurrentPlayer() {
		return currentPlayer;
	}

//	não vamos retornar peças do tipo Piece, esse tipo pertence a outra camada
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
//		percorrendo linhas
		for (int i = 0; i < board.getRows(); i++) {
//			percorrendo colunas
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	
	
	public boolean[][] possibleMoves(ChessPosition srcPos) {
		Position position = srcPos.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}

	public ChessPiece performChessMove(ChessPosition origin, ChessPosition destiny) {
		Position source = origin.toPosition();
		Position target = destiny.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		nextTurn();
//		downcasting
		return (ChessPiece) capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		if (currentPlayer != ((ChessPiece) board.piece(position)).getColor()) {
			throw new ChessException("The chosen piece is not yours");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	private void validateTargetPosition(Position src, Position tgt) {
		// se pra peça de origem a posição de destino não é um movimento possível
		if (!board.piece(src).possibleMove(tgt)) {
			throw new ChessException("The chosen piece can't move to the target position");
		}
	}
	
	private Piece makeMove(Position source, Position target) {
		// tira da origem...
		Piece p = board.removePiece(source);
		// ...tira do tabuleiro uma possível peça capturada...
		Piece capturedPiece = board.removePiece(target);
		// ...posiciona no destino a peça que estava na origem...
		board.placePiece(p, target);
		// ...e insere a peça capturada na lista
		if (capturedPiece != null) {
			alivePieces.remove(capturedPiece);
			capturedPieces.add((ChessPiece)capturedPiece);
		}
		return capturedPiece;
	}
	
	
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		alivePieces.add(piece);
	}

	private void initialSetup() {
		placeNewPiece('a', 1, new Rook(board, Color.WHITE));
//		placeNewPiece('b', 1, new Knight(board, Color.WHITE));
//		placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
//		placeNewPiece('d', 1, new Queen(board, Color.WHITE));

//		placeNewPiece('e', 1, new King(board, Color.WHITE, this));
		placeNewPiece('e', 1, new King(board, Color.WHITE));

//		placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
//		placeNewPiece('g', 1, new Knight(board, Color.WHITE));
		placeNewPiece('h', 1, new Rook(board, Color.WHITE));
//		placeNewPiece('a', 2, new Pawn(board, Color.WHITE, this));
//		placeNewPiece('b', 2, new Pawn(board, Color.WHITE, this));
//		placeNewPiece('c', 2, new Pawn(board, Color.WHITE, this));
//		placeNewPiece('d', 2, new Pawn(board, Color.WHITE, this));
//		placeNewPiece('e', 2, new Pawn(board, Color.WHITE, this));
//		placeNewPiece('f', 2, new Pawn(board, Color.WHITE, this));
//		placeNewPiece('g', 2, new Pawn(board, Color.WHITE, this));
//		placeNewPiece('h', 2, new Pawn(board, Color.WHITE, this));

		placeNewPiece('a', 8, new Rook(board, Color.BLACK));
//		placeNewPiece('b', 8, new Knight(board, Color.BLACK));
//		placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
//		placeNewPiece('d', 8, new Queen(board, Color.BLACK));

//		placeNewPiece('e', 8, new King(board, Color.BLACK, this));
		placeNewPiece('e', 8, new King(board, Color.BLACK));

//		placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
//		placeNewPiece('g', 8, new Knight(board, Color.BLACK));
		placeNewPiece('h', 8, new Rook(board, Color.BLACK));
//		placeNewPiece('a', 7, new Pawn(board, Color.BLACK, this));
//		placeNewPiece('b', 7, new Pawn(board, Color.BLACK, this));
//		placeNewPiece('c', 7, new Pawn(board, Color.BLACK, this));
//		placeNewPiece('d', 7, new Pawn(board, Color.BLACK, this));
//		placeNewPiece('e', 7, new Pawn(board, Color.BLACK, this));
//		placeNewPiece('f', 7, new Pawn(board, Color.BLACK, this));
//		placeNewPiece('g', 7, new Pawn(board, Color.BLACK, this));
//		placeNewPiece('h', 7, new Pawn(board, Color.BLACK, this));
	}
}