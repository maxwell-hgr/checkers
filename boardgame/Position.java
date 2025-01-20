package boardgame;

public class Position {
    int column;
    int row;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "Position [column=" + column + ", row=" + row + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position p) {
            return p.row == this.row && p.column == this.column;
        }
        return false;
    }
}
