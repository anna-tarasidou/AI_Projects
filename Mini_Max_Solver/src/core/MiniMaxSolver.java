// ANNA TARASIDOU

package core;

public class MiniMaxSolver {
	private Grid grid;

    public MiniMaxSolver(Grid grid) {
        this.grid = grid;
    }

	public int minimax(boolean isMaximizing) {
		String result = grid.checkForWinningCombination();
		if (result.equals("X")) return 1; 
		if (result.equals("O")) return -1; 
		if (result.equals("tie")) return 0;

		int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid.getCell(i, j).getValue() == '-') {
					grid.getCell(i, j).setValue(isMaximizing ? 'X' : 'O');

					int score = minimax(!isMaximizing);

					grid.getCell(i, j).setValue('-');

					if (isMaximizing)
						bestScore = Math.max(bestScore, score);
					else
						bestScore = Math.min(bestScore, score);
				}
			}
		}
		return bestScore;
	}


	public int[] findBestMove() {
		int[] bestMove = {-1, -1};

		// 1. Check if MAX can win
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid.getCell(i, j).getValue() == '-') {
					grid.getCell(i, j).setValue('X');
					if (grid.checkForWinningCombination().equals("X")) {
						grid.getCell(i, j).setValue('-');
						return new int[]{i, j};
					}
					grid.getCell(i, j).setValue('-');
				}
			}
		}

		// 2. If not, check if you can block min
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid.getCell(i, j).getValue() == '-') {
					grid.getCell(i, j).setValue('O');
					if (grid.checkForWinningCombination().equals("O")) {
						grid.getCell(i, j).setValue('-');
						return new int[]{i, j}; 
					}
					grid.getCell(i, j).setValue('-');
				}
			}
		}

		// 3. Else, use minimax
		int bestScore = Integer.MIN_VALUE;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid.getCell(i, j).getValue() == '-') {
					grid.getCell(i, j).setValue('X');
					int score = minimax(false);
					grid.getCell(i, j).setValue('-');

					if (score > bestScore) {
						bestScore = score;
						bestMove[0] = i;
						bestMove[1] = j;
					}
				}
			}
		}

		return bestMove;
	}
}
