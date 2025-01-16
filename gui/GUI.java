package gui;

import boardgame.Board;
import boardgame.Piece;
import checkers.CheckersPiece;

public class GUI {

    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void printBoard(Board board) {
        Piece[][] pieces = board.getPieces();

        System.out.println("  a b c d e f g h");

        int rows = 8;
        for (Piece[] row : pieces) {
            System.out.print((rows) + " ");

            for (Piece piece : row) {
                if (piece != null) {
                    System.out.print(piece + " ");
                } else {
                    System.out.print("  ");
                }
            }
            rows--;
            System.out.println();
        }
    }

    public static void printPossibleMoves(Board board, CheckersPiece origin) {
        boolean[][] possibleMoves = origin.simpleMoves(board);
        Piece[][] pieces = board.getPieces();

        System.out.println("  a b c d e f g h");

        int rows = 8;
        for (int i = 0; i < 8; i++) {
            System.out.print((rows) + " ");

            for (int j = 0; j < 8; j++) {
                Piece piece = pieces[i][j];

                if(possibleMoves[i][j]) {
                    if (piece != null) {
                        System.out.print(ANSI_BLUE_BACKGROUND + piece + " " + ANSI_RESET);
                    } else {
                        System.out.print(ANSI_BLUE_BACKGROUND + " " + ANSI_RESET);
                    }
                } else {
                    if (piece != null) {
                        System.out.print(piece + " ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            rows--;
            System.out.println();
        }
    }
}
