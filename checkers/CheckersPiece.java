package checkers;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

import java.util.ArrayList;
import java.util.List;

public class CheckersPiece extends Piece {
    private Color color;
    private boolean checker;
    private List<Attack> attacks = new ArrayList<>();

    public CheckersPiece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
            System.out.println(1);
            int[][] directions = {{-1, -1}, {-1, 1}};
            possibleMoves = simpleMoves(directions, board);
        }
        if (this.color == Color.WHITE) {
            int[][] directions = {{1, -1}, {1, 1}};
            possibleMoves = simpleMoves(directions, board);
        }
        if (this.isChecker()) {
            int[][] directions = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
            possibleMoves = simpleMoves(directions, board);
        }

        return possibleMoves;
    }

    private boolean[][] simpleMoves(int[][] directions, Board board) {
        boolean[][] possibleMoves = new boolean[8][8];

        outerloop:
        for (int[] direction : directions) {
            int rowIncrement = direction[0];
            int columnIncrement = direction[1];

            int row = this.getPosition().getRow() + rowIncrement;
            int col = this.getPosition().getColumn() + columnIncrement;

            Position pos = new Position(row, col);
            System.out.println(pos.getRow() + " " + pos.getColumn());
            Attack attack = new Attack();

            if (this.isChecker()) {
                boolean enemyPieceFound = false;

                while (board.isValidPosition(pos)) {
                    if (board.getPiece(pos) != null) {
                        CheckersPiece piece = (CheckersPiece) board.getPiece(pos);
                        if (piece.getColor() == this.getColor()){
                            continue outerloop;
                        } else {
                            if(!enemyPieceFound){
                                attack.setPiece(piece);

                                row += rowIncrement;
                                col += columnIncrement;
                                pos = new Position(row, col);

                                if(board.getPiece(pos) == null){
                                    enemyPieceFound = true;
                                    continue;
                                } else {
                                    continue outerloop;
                                }
                            } else {
                                continue outerloop;
                            }
                        }
                    }
                    if(enemyPieceFound){
                        attack.getPositions().add(pos);
                    }

                    possibleMoves[pos.getRow()][pos.getColumn()] = true;

                    row += rowIncrement;
                    col += columnIncrement;
                    pos = new Position(row, col);
                }
            } else {
                if (!board.isValidPosition(pos)) continue;

                if (board.getPiece(pos) != null) {
                    CheckersPiece piece = (CheckersPiece) board.getPiece(pos);

                    if (piece.getColor() == this.getColor()) continue;

                    Position nextPos = new Position(row + rowIncrement, col + columnIncrement);
                    if (board.isValidPosition(nextPos) && board.getPiece(nextPos) == null) {
                        possibleMoves[nextPos.getRow()][nextPos.getColumn()] = true;
                    }
                } else {
                    System.out.println(2);
                    possibleMoves[pos.getRow()][pos.getColumn()] = true;
                }
            }
            attacks.add(attack);
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
