import java.util.Objects;

public class Posizione {
    private int row;
    private int column;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posizione posizione = (Posizione) o;
        return row == posizione.row && column == posizione.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
