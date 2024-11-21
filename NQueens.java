public class NQueens {
    public static void solveNQueens(int n) {
        int[] board = new int[n];
        if (solve(board, 0, n)) {
            printBoard(board, n);
        } else {
            System.out.println("No solution exists.");
        }
    }
    private static boolean solve(int[] board, int row, int n) {
        if (row == n) {
            return true;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row] = col;
                if (solve(board, row + 1, n)) {
                    return true;
                }
                board[row] = -1;
            }
        }
        return false;
    }
    private static boolean isSafe(int[] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
    private static void printBoard(int[] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4;
        solveNQueens(n);
    }
}
//Time complexity ->   O(N!)