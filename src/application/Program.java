package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		System.out.println();

		while (true) {
			try {
				
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(in);

				System.out.println();
				System.out.print("Target: ");
				ChessPosition targe = UI.readChessPosition(in);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, targe);
				UI.clearScreen();
			} 
			catch (ChessException e) {
				System.out.println(e.getMessage());
				in.nextLine();
			} 
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				in.nextLine();
			}
		}
	}

}
