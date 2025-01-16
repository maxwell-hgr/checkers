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
        placeNewPiece(0,1, new CheckersPiece(Color.WHITE));
        placeNewPiece(0,3, new CheckersPiece(Color.WHITE));
        placeNewPiece(0,5, new CheckersPiece(Color.WHITE));
        placeNewPiece(0,7, new CheckersPiece(Color.WHITE));
        placeNewPiece(1,0, new CheckersPiece(Color.WHITE));
        placeNewPiece(1,2, new CheckersPiece(Color.WHITE));
        placeNewPiece(1,4, new CheckersPiece(Color.WHITE));
        placeNewPiece(1,6, new CheckersPiece(Color.WHITE));
        placeNewPiece(2,1, new CheckersPiece(Color.WHITE));
        placeNewPiece(2,3, new CheckersPiece(Color.WHITE));
        placeNewPiece(2,5, new CheckersPiece(Color.WHITE));
        placeNewPiece(2,7, new CheckersPiece(Color.WHITE));

        placeNewPiece(5,0, new CheckersPiece(Color.BLACK));
        placeNewPiece(5,2, new CheckersPiece(Color.BLACK));
        placeNewPiece(5,4, new CheckersPiece(Color.BLACK));
        placeNewPiece(5,6, new CheckersPiece(Color.BLACK));
        placeNewPiece(6,1, new CheckersPiece(Color.BLACK));
        placeNewPiece(6,3, new CheckersPiece(Color.BLACK));
        placeNewPiece(6,5, new CheckersPiece(Color.BLACK));
        placeNewPiece(6,7, new CheckersPiece(Color.BLACK));
        placeNewPiece(7,0, new CheckersPiece(Color.BLACK));
        placeNewPiece(7,2, new CheckersPiece(Color.BLACK));
        placeNewPiece(7,4, new CheckersPiece(Color.BLACK));
        placeNewPiece(7,6, new CheckersPiece(Color.BLACK));
    }

    private void placeNewPiece(int row, int colum, Piece piece) {
        Position position = new Position(row, colum);
        piece.setPosition(position);
        board.placePiece(position, piece);
    }
}
