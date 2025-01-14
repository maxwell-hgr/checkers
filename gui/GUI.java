package gui;

import boardgame.Board;
import boardgame.Piece;

public class GUI {
    public static void printBoard(Board board){
        Piece[][] pieces = board.getPieces();

        System.out.println("  12345678");
        for(int i = 0; i < pieces.length; i++){
            System.out.print((i + 1) + " ");
            for(int j=0; j<pieces[i].length; j++){
                if(pieces[i][j] != null){
                    System.out.print(pieces[i][j].toString());
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
