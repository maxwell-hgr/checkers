package checkers;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import util.Attack;
import util.Util;

import java.util.ArrayList;
import java.util.List;

import static util.Util.simpleMoves;

public class CheckersPiece extends Piece {
    private final Color color;
    private boolean checker;
    private final List<Attack> attacks = new ArrayList<>();

    public CheckersPiece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public boolean isChecker() {
        return checker;
    }

    public void setChecker(boolean checker) {
        this.checker = checker;
    }

    public boolean[][] possibleMoves(Board board) {
        boolean[][] possibleMoves = new boolean[8][8];

        if (this.color == Color.BLACK) {
            int[][] directions = {{-1, -1}, {-1, 1}};
            possibleMoves = simpleMoves(this, directions, board);
        }
        if (this.color == Color.WHITE) {
            int[][] directions = {{1, -1}, {1, 1}};
            possibleMoves = simpleMoves(this, directions, board);
        }
        if (this.isChecker()) {
            int[][] directions = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
            possibleMoves = simpleMoves(this, directions, board);
        }

        return possibleMoves;
    }

    @Override
    public String toString() {
        if (color == Color.BLACK) {
            return "B";
        } else if (color == Color.WHITE) {
            return "W";
        }
        return " ";
    }
}
