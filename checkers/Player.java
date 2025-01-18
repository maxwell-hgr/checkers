package checkers;

import boardgame.Piece;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final Color color;
    private final List<Piece> pieces = new ArrayList<Piece>();

    public Player(Color color) {
        this.color = color;
    };

    public Color getColor() {
        return color;
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}
