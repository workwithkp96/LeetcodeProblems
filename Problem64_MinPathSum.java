package Leetcode;

public class Problem64_MinPathSum {
    public int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        for(int i=M-2;i>=0;i--){
            grid[i][N-1]+=grid[i+1][N-1];
        }

        for(int j=N-2;j>=0;j--){
            grid[M-1][j]+=grid[M-1][j+1];
        }

        for(int i=M-2;i>=0;i--){
            for(int j=N-2;j>=0;j--){
                grid[i][j]+=Math.min(grid[i+1][j],grid[i][j+1]);
            }
        }
        return grid[0][0];
    }
}
