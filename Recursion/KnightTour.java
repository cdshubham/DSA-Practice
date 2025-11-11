package Recursion;

public class KnightTour {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] board=new int[n][m];
        int sr=sc.nextInt();
        int sc=sc.nextInt();
        knightTour(board,sr,sc,1);
        sc.close();
    }
    public static void knightTour(int[][] board, int sr, int sc, int move) {
        if (sr < 0 || sc < 0 || sr == board.length || sc == board[0].length || board[sr][sc] != 0) {
            return;
        }
        if (move == board.length * board[0].length) {
            board[sr][sc] = move;
            displayBoard(board);
            board[sr][sc] = 0; // backtrack
            return;
        }
        board[sr][sc] = move;
        knightTour(board, sr - 2, sc + 1, move + 1);
        knightTour(board, sr - 1, sc + 2, move + 1);
        knightTour(board, sr + 1, sc + 2, move + 1);
        knightTour(board, sr + 2, sc + 1, move + 1);
        knightTour(board, sr + 2, sc - 1, move + 1);
        knightTour(board, sr + 1, sc - 2, move + 1);
        knightTour(board, sr - 1, sc - 2, move + 1);
        knightTour(board, sr - 2, sc - 1, move + 1);
        board[sr][sc] = 0; // backtrack
    }
    public static void displayBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
