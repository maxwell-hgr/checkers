package boardgame;

public class Board {

    int rows;
    int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }

    public Piece getPiece(Position pos) {
        return pieces[pos.getRow()][pos.getColumn()];
    }

    public void placePiece(Position pos, Piece piece) {
        pieces[pos.getRow()][pos.getColumn()] = piece;
    }

    public void clearPosition(Position pos) {
        pieces[pos.getRow()][pos.getColumn()] = null;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[][] pieces) {
        this.pieces = pieces;
    }

    public Piece getPieceWithString(String coordinate) {
        char col = coordinate.charAt(0);
        int row = Integer.parseInt(coordinate.substring(1));
        Position pos = new Position(8 - row, col - 'a');
        System.out.println(pos.getRow() + " " + pos.getColumn());
        return getPiece(pos);
    }
}
