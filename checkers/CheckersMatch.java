package checkers;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

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

    public Piece getOriginPiece(String string) {
        Position position = board.coordinateToPosition(string);
        return board.getPiece(position);
    }

    public List<Position> playerHaveAttacks() {
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

    public void movePiece(CheckersPiece piece, String string) {
        Position origin = piece.getPosition();
        Position position = board.coordinateToPosition(string);
        boolean[][] possibleMoves = piece.possibleMoves(this.board);

        if(possibleMoves[position.getRow()][position.getColumn()]) {
            board.placePiece(position, piece);
            board.clearPosition(origin);

            changeCurrentPlayer();
        } else {
            System.out.println("Invalid move");
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

    private void changeCurrentPlayer() {
        currentPlayer = this.currentPlayer.getColor() == Color.BLACK ?
                    players[0] : players[1];
    }
}
