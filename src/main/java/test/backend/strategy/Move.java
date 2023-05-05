package test.backend.strategy;

import java.util.Objects;

public final class Move {
    private final int row;
    private final int col;

    private boolean isSpecial = false;

    public Move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }
    public void setSpecial(boolean variable){
        isSpecial = variable;
    }
    public boolean isSpecial(){
        return isSpecial;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Move) obj;
        return this.row == that.row &&
                this.col == that.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "Move[" +
                "row=" + row + ", " +
                "col=" + col + ']';
    }

}
