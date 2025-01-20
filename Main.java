import checkers.CheckersMatch;
import checkers.CheckersPiece;
import gui.GUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckersMatch checkersMatch = new CheckersMatch();

        boolean gameOver = false;
        while(!gameOver) {
            System.out.println(checkersMatch.getCurrentPlayer() + " player turn!");
            GUI.printBoard(checkersMatch.getBoard());

            String input = "";
            CheckersPiece origin;
            boolean originControl = true;
            while(originControl){
                if(!checkersMatch.playerAttacks().isEmpty()){
                    System.out.println("Player Have Attacks!");
                    System.out.println("Select a piece which have an active attack: " + checkersMatch.attackPiecesCoordinates());
                    input = scanner.nextLine();

                    if(checkersMatch.isAttackPiece(input)){
                        break;
                    } else {
                        System.out.println("Select a valid attack piece!");
                        continue;
                    }
                } else {
                    System.out.println("Type piece coordinates: (a1 - h8)");
                    input = scanner.nextLine();
                }
                originControl = checkersMatch.invalidOrigin(input);
            }
            origin = (CheckersPiece) checkersMatch.getOriginPiece(input);


            GUI.printPossibleMoves(checkersMatch.getBoard(), origin);


            boolean destinyControl = true;
            while(destinyControl){
                System.out.println("Type destiny coordinates for piece: ");
                String destiny = scanner.nextLine();
                if(checkersMatch.movePiece(origin, destiny)){
                    destinyControl = false;
                }

                if(!origin.getAttacks().isEmpty()){
                    System.out.println("Player Still Have Attacks!");
                } else {
                    checkersMatch.changeCurrentPlayer();
                }
            }

            if(checkersMatch.checkEndGame()){
                gameOver = true;
            }
        }
    }
}
