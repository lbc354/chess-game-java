package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ChessMatch cm = new ChessMatch();
		
		while (true) {
			try {
				UI.clearScreen();
				UI.printMatch(cm);
				
				System.out.print("\nEnter source position: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = cm.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(cm.getPieces(), possibleMoves);
				
				System.out.print("\nEnter target position: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = cm.performChessMove(source, target);
			} catch (ChessException e) {
				System.out.println(e.getMessage() + " (PRESS ENTER)");
				// programa vai aguardar clicar no enter
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage() + " (PRESS ENTER)");
				// programa vai aguardar clicar no enter
				sc.nextLine();
			}
		}
	}

}