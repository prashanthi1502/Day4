public class GridPaths {
    public static void printAllPaths(int m, int n) {
        int[] path = new int[m + n - 1];
        printPathsHelper(m, n, 0, 0, path, 0);
    }
    private static void printPathsHelper(int m, int n, int i, int j, int[] path, int index) {
        if (i == m - 1 && j == n - 1) {
            path[index] = 1;
            printPath(path, index + 1);
            return;
        }
        if (i < m - 1) {
            path[index] = 0;
            printPathsHelper(m, n, i + 1, j, path, index + 1);
        }
        if (j < n - 1) {
            path[index] = 1;
            printPathsHelper(m, n, i, j + 1, path, index + 1);
        }
    }
    private static void printPath(int[] path, int length) {
        for (int i = 0; i < length; i++) {
            if (path[i] == 0) {
                System.out.print("Down ");
            } else {
                System.out.print("Right ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int m = 2, n = 3;
        System.out.println("All possible paths in a " + m + "x" + n + " grid:");
        printAllPaths(m, n);
    }
}