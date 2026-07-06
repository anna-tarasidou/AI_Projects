// ANNA TARASIDOU

package core;

public class Cell {
	private int row;
    private int col;
    private char value;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.value = '-';
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return this.value == '-';
    }
}
