package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
//	é nessa classe q vai estar as regras do xadrez
	private Board board;
	
	
	
	public ChessMatch() {
		board = new Board(8,8);
		initialSetup();
	}
	
	
	
//	não vamos retornar peças do tipo Piece, esse tipo pertence a outra camada
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
//		percorrendo linhas
		for (int i = 0; i < board.getRows(); i++) {
//			percorrendo colunas
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i,j);
			}
		}
		return mat;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new King(board, Color.BLACK));
		placeNewPiece('e', 8, new King(board, Color.WHITE));
	}
}