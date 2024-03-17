package chess;

import boardgame.Board;
import boardgame.Position;
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
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new King(board, Color.BLACK), new Position(7, 4));
		board.placePiece(new King(board, Color.WHITE), new Position(0, 4));
	}
}