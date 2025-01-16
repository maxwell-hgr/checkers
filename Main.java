import checkers.CheckersMatch;
import checkers.CheckersPiece;
import gui.GUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckersMatch checkersMatch = new CheckersMatch();

        GUI.printBoard(checkersMatch.getBoard());

        System.out.println("Type piece coordinates: (a1 - h8)");
        String input = scanner.nextLine();

        CheckersPiece origin = (CheckersPiece) checkersMatch.getBoard().getPieceWithString(input);
        System.out.println(origin);

        GUI.printPossibleMoves(checkersMatch.getBoard(), origin);

        // print board and possible moves or error

        System.out.println("Type destiny coordinates for piece: ");

    }
}
