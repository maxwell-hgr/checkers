package checkers;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

import java.util.*;

public class CheckersPiece extends Piece {
    private Color color;
    private boolean checker;

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

    public boolean[][] simpleMoves(Board board){
        boolean[][] possibleMoves = new boolean[8][8];

        int pieceRow = this.getPosition().getRow();
        int pieceColumn = this.getPosition().getColumn();


        if(this.isChecker()){
            Position p1 = new Position(pieceRow - 1 , pieceColumn - 1);
            Position p2 = new Position(pieceRow + 1 , pieceColumn - 1);
            Position p3 = new Position(pieceRow - 1 , pieceColumn + 1);
            Position p4 = new Position(pieceRow + 1 , pieceColumn + 1);

            Position[] positions = new Position[]{p1,p2,p3,p4};

            for (Position position : positions) {
                if(isInvalidPosition(position)){
                    continue;
                }
                iterator(possibleMoves, position, board, this.color);
            }
        } else {
            Map<Position, Position> positionMap = new HashMap<>();
            positionMap.put(
                    new Position(pieceRow - 1, pieceColumn - 1),
                    new Position(pieceRow - 2, pieceColumn - 2)
            );
            positionMap.put(
                    new Position(pieceRow + 1, pieceColumn - 1),
                    new Position(pieceRow + 2, pieceColumn - 2)
            );
            positionMap.put(
                    new Position(pieceRow - 1, pieceColumn + 1),
                    new Position(pieceRow - 2, pieceColumn + 2)
            );
            positionMap.put(
                    new Position(pieceRow + 1, pieceColumn + 1),
                    new Position(pieceRow + 2, pieceColumn + 2)
            );

            for(Position position : positionMap.keySet()){
                if(isInvalidPosition(position)){
                    continue;
                }

                System.out.println(position.getRow() + " " + position.getColumn());

                CheckersPiece checkersPiece = (CheckersPiece) board.getPiece(position);
                if(checkersPiece == null){
                    possibleMoves[position.getRow()][position.getColumn()] = true;
                } else {
                    if(checkersPiece.getColor() == this.color){
                        continue;
                    }
                    possibleMoves[positionMap.get(position).getRow()][position.getColumn()] = true;
                }
            }

        }
        return possibleMoves;
    }

    private static void iterator(boolean[][] moves, Position position, Board board, Color color){
        for(int i = 0; i < 8; i++){
            if(board.getPiece(position) == null){
                moves[position.getRow()][position.getColumn()] = true;
            } else {
                CheckersPiece checkersPiece = (CheckersPiece) board.getPiece(position);
                if(checkersPiece.getColor() != color){
                    moves[position.getRow()][position.getColumn()] = false;
                } else {
                    break;
                }
            }
        }
    }

    private boolean isInvalidPosition(Position position){
        int row = position.getRow();
        int column = position.getColumn();

        return row < 0 || row >= 8 || column < 0 || column >= 8;
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
