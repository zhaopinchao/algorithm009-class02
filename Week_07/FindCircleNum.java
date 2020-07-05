/**
 * @author: zhaopc@tuya.com
 * @date: 2020-07-05 22:07
 * @description
 */
public class FindCircleNum {

    public int findCircleNum(int[][] M) {
        int result = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    dfs(M, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int[][] M, int row, int col) {
        int[] a = {0, 0, 1, -1};
        int[] b = {1, -1, 0, 0};
        M[row][col] = 0;
        for (int i = 0; i < 4; i++) {
            int newRow = row + a[i];
            int newCol = col + b[i];
            if (newRow < 0 || newRow >= M.length || newCol < 0 || newCol >= M[newRow].length) {
                continue;
            }
            if (M[newRow][newCol] == 1) {
                dfs(M, newRow, newCol);
            }
        }
    }
}
