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

        CheckersPiece origin = (CheckersPiece) checkersMatch.getOriginPiece(input);

        GUI.printPossibleMoves(checkersMatch.getBoard(), origin);

        System.out.println("Type destiny coordinates for piece: ");
        String destiny = scanner.nextLine();

        checkersMatch.movePiece(origin, destiny);

        GUI.printBoard(checkersMatch.getBoard());

    }
}
