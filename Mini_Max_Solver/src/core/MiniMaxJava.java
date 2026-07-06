// ANNA TARASIDOU

package core;

import java.util.*;

public class MiniMaxJava {
	public static void main(String[] args) {
        Grid grid = new Grid(4, 3);
        Random rand = new Random();

        int xRow, xCol, oRow, oCol;

        do {
            xRow = rand.nextInt(4);
            xCol = rand.nextInt(3);
            oRow = rand.nextInt(4);
            oCol = rand.nextInt(3);
        } while (grid.areAdjacent(grid.getCell(xRow, xCol), grid.getCell(oRow, oCol)) ||
                 !grid.getCell(xRow, xCol).isEmpty() ||
                 !grid.getCell(oRow, oCol).isEmpty());

        grid.updateCell(xRow, xCol, 'X');
        grid.updateCell(oRow, oCol, 'O');

        Scanner scanner = new Scanner(System.in);
        MiniMaxSolver solver = new MiniMaxSolver(grid);

        System.out.println("\n===== GAME START =====");
        grid.printGrid();

        while (true) {
            String result = grid.checkForWinningCombination();
            if (!result.equals("The game continues...")) {
                printFinalMessage(result);
                break;
            }

            System.out.println("\nYour move (O) - enter row and column:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            while (row < 0 || row >= 4 || col < 0 || col >= 3 || !grid.getCell(row, col).isEmpty()) {
                System.out.println("Invalid move. Try again:");
                row = scanner.nextInt();
                col = scanner.nextInt();
            }

            grid.updateCell(row, col, 'O');
            grid.printGrid();

            result = grid.checkForWinningCombination();
            if (!result.equals("The game continues...")) {
                printFinalMessage(result);
                break;
            }

            System.out.println("\nMAX (X) is thinking...");
            int[] bestMove = solver.findBestMove();
            if (bestMove[0] != -1) {
                grid.updateCell(bestMove[0], bestMove[1], 'X');
                grid.printGrid();
            } else {
                System.out.println("No valid moves left.");
                break;
            }
        }

        System.out.println("===== GAME OVER =====");
        scanner.close();
    }

    private static void printFinalMessage(String result) {
        System.out.println("\n===== RESULT =====");
        switch (result) {
            case "X":
                System.out.println("MAX (X) has won with 'XOX'");
                break;
            case "O":
                System.out.println("MIN (O) has won with 'OXO'");
                break;
            case "tie":
                System.out.println("This game is a tie.");
                break;
            default:
                System.out.println("Unexpected result: " + result);
        }
    }
}
