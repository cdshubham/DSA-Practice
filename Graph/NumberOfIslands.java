public class NumberOfIslands {

    // DFS Approach
    public int numIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Boundary check
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        // Explore 4 directions (up, down, left, right)
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }

    // BFS Approach
    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}}; // 4 directions

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];

                        for (int[] d : directions) {
                            int nx = x + d[0], ny = y + d[1];
                            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols
                                    && grid[nx][ny] == '1' && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    // Test
    public static void main(String[] args) {
        NumberOfIslands obj = new NumberOfIslands();

        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        System.out.println("Number of Islands (DFS): " + obj.numIslandsDFS(grid));
        System.out.println("Number of Islands (BFS): " + obj.numIslandsBFS(grid));
    }
}
