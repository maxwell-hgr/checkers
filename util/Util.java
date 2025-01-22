package util;

import boardgame.Board;
import boardgame.Position;
import checkers.CheckersPiece;

public class Util {
    public static boolean[][] simpleMoves(CheckersPiece checkersPiece, int[][] directions, Board board) {
        boolean[][] possibleMoves = new boolean[8][8];

        outerloop:
        for (int[] direction : directions) {
            int rowIncrement = direction[0];
            int columnIncrement = direction[1];

            int row = checkersPiece.getPosition().getRow() + rowIncrement;
            int col = checkersPiece.getPosition().getColumn() + columnIncrement;

            Position pos = new Position(row, col);
            Attack attack = new Attack();

            boolean enemyPieceFound = false;
            if (checkersPiece.isChecker()) {
                while (board.isValidPosition(pos)) {
                    if (board.getPiece(pos) != null) {
                        CheckersPiece piece = (CheckersPiece) board.getPiece(pos);
                        if (piece.getColor() == checkersPiece.getColor()){
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

                    if (piece.getColor() == checkersPiece.getColor()){
                        continue;
                    } else {
                        attack.setPiece(piece);
                        Position nextPos = new Position(row + rowIncrement, col + columnIncrement);
                        if (board.isValidPosition(nextPos) && board.getPiece(nextPos) == null) {
                            possibleMoves[nextPos.getRow()][nextPos.getColumn()] = true;
                            attack.getPositions().add(nextPos);
                        }
                    }
                } else {
                    possibleMoves[pos.getRow()][pos.getColumn()] = true;
                }
            }
            if(isValidAttack(attack, checkersPiece)) checkersPiece.getAttacks().add(attack);
        }
        return possibleMoves;
    }

    public static boolean isValidAttack(Attack attack, CheckersPiece checkersPiece) {
        if(attack.getPiece() == null){
            return false;
        }
        if(attack.getPositions().isEmpty()){
            return false;
        } else {
            for(Attack att : checkersPiece.getAttacks()) {
                if(att.equals(attack)){
                    return false;
                }
            }
            return true;
        }
    }
}
