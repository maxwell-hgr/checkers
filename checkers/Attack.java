package checkers;

import boardgame.Piece;
import boardgame.Position;

import java.util.ArrayList;
import java.util.List;

public class Attack {
    private Piece piece;
    private final List<Position> positions = new ArrayList<>();

    public Attack() {}

    public Piece getPiece() {
        return piece;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
