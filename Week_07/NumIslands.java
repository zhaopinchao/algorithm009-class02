/**
 * @author: zhaopc@tuya.com
 * @date: 2020-07-05 22:06
 * @description
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int row, int col) {
        int[] a = {-1, 1, 0, 0};
        int[] b = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int newRow = row + a[i];
            int newCol = col + b[i];
            if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[newRow].length) {
                continue;
            }
            if (grid[newRow][newCol] == '1') {
                grid[newRow][newCol] = '0';
                dfs(grid, newRow, newCol);
            }
        }
    }
}
