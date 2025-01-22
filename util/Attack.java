package util;

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

    @Override
    public String toString() {
        return piece.toString() + " " + positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o instanceof Attack){
            if(((Attack) o).getPiece() != this.getPiece()){
                return false;
            } else {
                List<Position> positions = this.getPositions();
                List<Position> oPositions = ((Attack) o).getPositions();

                for(Position position : positions){
                    for(Position oPosition : oPositions){
                        if(position.equals(oPosition)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
