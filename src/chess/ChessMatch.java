package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
//	é nessa classe q vai estar as regras do xadrez
	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
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
	
	

	public ChessPiece performChessMove(ChessPosition origin, ChessPosition destiny) {
		Position source = origin.toPosition();
		Position target = destiny.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
//		downcasting
		return (ChessPiece) capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
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