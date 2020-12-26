package HackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DFSConnectedCellinaGrid {
    static int max = Integer.MIN_VALUE;

    static int maxRegion(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (!visited[i][j] && grid[i][j] == 1)
                    connect(i, j, grid, visited, 1);
            }
        }
        return max;
    }

    private static void connect(int i, int j, int[][] grid, boolean[][] visited, int count) {
        if(i < 0 || j>= grid[0].length ) return;
        if (visited[i][j]) return;
        visited[i][j] = true;
        max = Math.max(max, grid[i][j]);
        if (i - 1 >= 0) {
            if (grid[i - 1][j] == 1) connect(i - 1, j, grid, visited, count + 1);
            if (j - 1 >= 0 && grid[i - 1][j - i] == 1) connect(i - 1, j - 1, grid, visited, count + 1);
            if ((j + 1) <= grid[i-1].length-1 && grid[i - 1][j + i] == 1) connect(i - 1, j + 1, grid, visited, count + 1);
        }
        if (j - 1 >= 0 && grid[i][j - i] == 1) connect(i, j - 1, grid, visited, count + 1);
        if (j + 1 < grid[i].length && grid[i][j + i] == 1) connect(i, j + 1, grid, visited, count + 1);
        if (i + 1 < grid.length) {
            if (grid[i + 1][j] == 1) connect(i + 1, j, grid, visited, count + 1);
            if (j - 1 >= 0 && grid[i + 1][j - i] == 1) connect(i - 1, j + 1, grid, visited, count + 1);
            if (j + 1 < grid[i+1].length && grid[i + 1][j + i] == 1) connect(i + 1, j + 1, grid, visited, count + 1);
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);

        scanner.close();
    }
}
