package checkers;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import util.Attack;
import util.Player;

import java.util.ArrayList;
import java.util.List;

public class CheckersMatch {
    private final Board board;
    private Player currentPlayer;
    private Player[] players;

    public CheckersMatch() {
        this.board = new Board(8,8);

        startGame();
    }

    public Board getBoard() {
        return this.board;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void changeCurrentPlayer() {
        this.currentPlayer = getEnemyPlayer();
    }

    public Piece getOriginPiece(String string) {
        Position position = board.coordinateToPosition(string);
        return board.getPiece(position);
    }

    public boolean movePiece(CheckersPiece piece, String string) {
        Position origin = piece.getPosition();
        Position destiny = board.coordinateToPosition(string);
        if(!board.isValidPosition(destiny)) return false;

        boolean[][] possibleMoves = piece.possibleMoves(this.board);

        if(possibleMoves[destiny.getRow()][destiny.getColumn()]) {

            List<Attack> attacks = piece.getAttacks();
            if(!attacks.isEmpty()){
                for(Attack attack : attacks){
                    for(Position position : attack.getPositions()){
                        if(position.getRow() == destiny.getRow() && position.getColumn() == destiny.getColumn()){
                            CheckersPiece attackedPiece = (CheckersPiece) attack.getPiece();
                            getEnemyPlayer().getPieces().remove(attackedPiece);

                            board.clearPosition(attackedPiece.getPosition());
                            board.clearPosition(origin);

                            board.placePiece(destiny, piece);
                            piece.setPosition(destiny);


                            piece.getAttacks().removeAll(attacks);
                            piece.possibleMoves(this.board);

                            if(piece.getColor() == Color.BLACK){
                                if(piece.getPosition().getRow() == 0){
                                    piece.setChecker(true);
                                }
                            } else {
                                if(piece.getPosition().getRow() == 7){
                                    piece.setChecker(true);
                                }
                            }
                            return true;
                        }
                    }
                }
                return false;
            }

            board.placePiece(destiny, piece);
            board.clearPosition(origin);

            piece.setPosition(destiny);

            return true;
        } else {
            System.out.println("Invalid move");
            return false;
        }
    }


    private void startGame() {
        Player white = new Player(Color.WHITE);
        placeNewPiece(0,1, new CheckersPiece(Color.WHITE), white);
        placeNewPiece(0,3, new CheckersPiece(Color.WHITE), white);
        placeNewPiece(0,5, new CheckersPiece(Color.WHITE), white);
        placeNewPiece(0,7, new CheckersPiece(Color.WHITE), white);
        placeNewPiece(1,0, new CheckersPiece(Color.WHITE), white);
        placeNewPiece(1,2, new CheckersPiece(Color.WHITE), white);
        placeNewPiece(1,4, new CheckersPiece(Color.WHITE), white);
        placeNewPiece(1,6, new CheckersPiece(Color.WHITE), white);
        placeNewPiece(2,1, new CheckersPiece(Color.WHITE), white);
        placeNewPiece(2,3, new CheckersPiece(Color.WHITE), white);
        placeNewPiece(2,5, new CheckersPiece(Color.WHITE), white);
        placeNewPiece(2,7, new CheckersPiece(Color.WHITE), white);


        Player black = new Player(Color.BLACK);
        placeNewPiece(5,0, new CheckersPiece(Color.BLACK), black);
        placeNewPiece(5,2, new CheckersPiece(Color.BLACK), black);
        placeNewPiece(5,4, new CheckersPiece(Color.BLACK), black);
        placeNewPiece(5,6, new CheckersPiece(Color.BLACK), black);
        placeNewPiece(6,1, new CheckersPiece(Color.BLACK), black);
        placeNewPiece(6,3, new CheckersPiece(Color.BLACK), black);
        placeNewPiece(6,5, new CheckersPiece(Color.BLACK), black);
        placeNewPiece(6,7, new CheckersPiece(Color.BLACK), black);
        placeNewPiece(7,0, new CheckersPiece(Color.BLACK), black);
        placeNewPiece(7,2, new CheckersPiece(Color.BLACK), black);
        placeNewPiece(7,4, new CheckersPiece(Color.BLACK), black);
        placeNewPiece(7,6, new CheckersPiece(Color.BLACK), black);

        players = new Player[] {white, black};

        currentPlayer = white;
    }

    private void placeNewPiece(int row, int colum, Piece piece, Player player) {
        Position position = new Position(row, colum);
        piece.setPosition(position);
        board.placePiece(position, piece);
        player.addPiece(piece);
    }

    private Player getEnemyPlayer() {
        return this.currentPlayer.getColor() == Color.BLACK ?
                    players[0] : players[1];
    }

    public boolean checkEndGame(){
        return getEnemyPlayer().getPieces().isEmpty();
    }

    public List<Position> playerAttacks() {
        List<Position> attacks = new ArrayList<>();
        List<Piece> pieces = currentPlayer.getPieces();

        for (Piece piece : pieces) {
            CheckersPiece checkersPiece = (CheckersPiece) piece;
            checkersPiece.possibleMoves(board);

            if(!checkersPiece.getAttacks().isEmpty()){
                attacks.add(checkersPiece.getPosition());
            }
        }
        return attacks;
    }

    public String attackPiecesCoordinates(){
        List<Position> attacks = playerAttacks();

        StringBuilder attacksString = new StringBuilder();
        for(Position p : attacks){
            String coordinate = board.positionToCoordinate(p);
            attacksString.append(coordinate).append(" - ");
        }
        return attacksString.toString();
    }

    public boolean isAttackPiece(String coordinate){
        Position position = board.coordinateToPosition(coordinate);

        for(Position p : playerAttacks()){
            if(p.getRow() == position.getRow() && p.getColumn() == position.getColumn()){
                return true;
            }
        }
        return false;
    }

    public boolean invalidOrigin(String coordinate) {
        Position origin = board.coordinateToPosition(coordinate);
        if(!board.isValidPosition(origin)) return true;
        CheckersPiece checkersPiece = (CheckersPiece) board.getPiece(origin);

        if(checkersPiece == null) return true;

        if(checkersPiece.getColor() == currentPlayer.getColor()){
            boolean[][] possibleMoves = checkersPiece.possibleMoves(board);
            for(boolean[] x : possibleMoves){
                for (boolean y : x){
                    if (y) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
