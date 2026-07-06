// ANNA TARASIDOU 

package core;

public class Grid {
	private Cell[][] grid;

    public Grid(int rows, int cols) {
        grid = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
    }

    public void printGrid() {
		System.out.print("    ");
		for (int j = 0; j < grid[0].length; j++) {
			System.out.print(" " + j + "  ");
		}
		System.out.println();

		for (int i = 0; i < grid.length; i++) {
			System.out.print("   ");
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print("+---");
			}
			System.out.println("+");

			System.out.print(" " + i + " ");
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print("| " + grid[i][j].getValue() + " ");
			}
			System.out.println("|");
		}

		System.out.print("   ");
		for (int j = 0; j < grid[0].length; j++) {
			System.out.print("+---");
		}
		System.out.println("+");
	}


    public void updateCell(int row, int col, char value) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            grid[row][col].setValue(value);
        } else {
            System.out.println("Not valid position.");
        }
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public boolean areAdjacent(Cell cell1, Cell cell2) {
        return Math.abs(cell1.getRow() - cell2.getRow()) <= 1 && Math.abs(cell1.getCol() - cell2.getCol()) <= 1;
    }
	
	public boolean isFull() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].getValue() == '-') {
                    return false;  
                }
            }
        }
        return true;  
    }
	
	public String checkForWinningCombination() {
		// Checking the rows 
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length - 2; j++) {
				String line = "" + grid[i][j].getValue() + grid[i][j+1].getValue() + grid[i][j+2].getValue();
				if (line.equals("XOX")) {
					return "X";
				} else if (line.equals("OXO")) {
					return "O";
				}
			}
		}

		// Checking the columns
		for (int j = 0; j < grid[0].length; j++) {
			for (int i = 0; i < grid.length - 2; i++) {
				String column = "" + grid[i][j].getValue() + grid[i+1][j].getValue() + grid[i+2][j].getValue();
				if (column.equals("XOX")) {
					return "X";
				} else if (column.equals("OXO")) {
					return "O";
				}
			}
		}

		// Checking the diagonals
		for (int i = 0; i < grid.length - 2; i++) {
			for (int j = 0; j < grid[i].length - 2; j++) {
				String diagonal1 = "" + grid[i][j].getValue() + grid[i+1][j+1].getValue() + grid[i+2][j+2].getValue();
				String diagonal2 = "" + grid[i][j+2].getValue() + grid[i+1][j+1].getValue() + grid[i+2][j].getValue();
				if (diagonal1.equals("XOX") || diagonal2.equals("XOX")) {
					return "X";
				} else if (diagonal1.equals("OXO") || diagonal2.equals("OXO")) {
					return "O";
				}
			}
		}

		if (isFull()) {
			return "tie";
		}

		return "The game continues..."; 
	}
}
