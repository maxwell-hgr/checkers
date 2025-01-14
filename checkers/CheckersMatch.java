package checkers;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public class CheckersMatch {
    private final Board board;

    public CheckersMatch() {
        this.board = new Board(8,8);

        startGame(this.board);
    }

    public Board getBoard() {
        return this.board;
    }


    private void startGame(Board board) {
        placeNewPiece(0,0, new CheckersPiece(Color.WHITE));
        placeNewPiece(0,2, new CheckersPiece(Color.WHITE));
        placeNewPiece(1,1, new CheckersPiece(Color.WHITE));
        placeNewPiece(2,0, new CheckersPiece(Color.WHITE));
        placeNewPiece(2,2, new CheckersPiece(Color.WHITE));
        placeNewPiece(3,1, new CheckersPiece(Color.WHITE));
        placeNewPiece(4,0, new CheckersPiece(Color.WHITE));
        placeNewPiece(4,2, new CheckersPiece(Color.WHITE));
        placeNewPiece(5,1, new CheckersPiece(Color.WHITE));
        placeNewPiece(6,0, new CheckersPiece(Color.WHITE));
        placeNewPiece(6,2, new CheckersPiece(Color.WHITE));
        placeNewPiece(7,1, new CheckersPiece(Color.WHITE));

        placeNewPiece(0,5, new CheckersPiece(Color.BLACK));
        placeNewPiece(0,7, new CheckersPiece(Color.BLACK));
        placeNewPiece(1,6, new CheckersPiece(Color.BLACK));
        placeNewPiece(2,5, new CheckersPiece(Color.BLACK));
        placeNewPiece(2,7, new CheckersPiece(Color.BLACK));
        placeNewPiece(3,6, new CheckersPiece(Color.BLACK));
        placeNewPiece(4,5, new CheckersPiece(Color.BLACK));
        placeNewPiece(4,7, new CheckersPiece(Color.BLACK));
        placeNewPiece(5,6, new CheckersPiece(Color.BLACK));
        placeNewPiece(6,5, new CheckersPiece(Color.BLACK));
        placeNewPiece(6,7, new CheckersPiece(Color.BLACK));
        placeNewPiece(7,6, new CheckersPiece(Color.BLACK));
    }

    private void placeNewPiece(int row, int colum, Piece piece) {
        Position position = new Position(row, colum);
        board.placePiece(position, piece);
    }
}
