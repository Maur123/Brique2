public class Posizione {
    private final int row;
    private final int column;
    public Posizione(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
