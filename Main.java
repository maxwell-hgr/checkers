import checkers.CheckersMatch;
import gui.GUI;

public class Main {
    public static void main(String[] args) {
        CheckersMatch checkersMatch = new CheckersMatch();

        GUI.printBoard(checkersMatch.getBoard());
    }
}
