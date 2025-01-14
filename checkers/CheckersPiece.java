package checkers;

import boardgame.Piece;

public class CheckersPiece extends Piece {
    private Color color;

    public CheckersPiece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if(color == Color.BLACK) {
            return "B";
        } else if(color == Color.WHITE) {
            return "W";
        }
        return " ";
    }
}
