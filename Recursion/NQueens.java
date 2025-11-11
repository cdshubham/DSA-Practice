package Recursion;

public class NQueens {
    public static void main(String[] args) {
        int n = 4; // Size of the chessboard (n x n)
        boolean[][] board = new boolean[n][n];
        System.out.println("All possible arrangements of " + n + " queens on a " + n + "x" + n + " chessboard are:");
        placeQueens(board, 0, "");
    }
    public static void placeQueens(boolean[][] board, int row, String arrangement) {
        if (row == board.length) {
            System.out.println(arrangement);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true; // Place queen
                placeQueens(board, row + 1, arrangement + "(" + row + "," + col + ") ");
                board[row][col] = false; // Backtrack
            }
        }
    }
}
