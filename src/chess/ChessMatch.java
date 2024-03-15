package chess;

import boardgame.Board;

public class ChessMatch {
//	é nessa classe q vai estar as regras do xadrez
	private Board board;
	
	
	
	public ChessMatch() {
		board = new Board(8,8);
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
}