package Leetcode;

public class Problem63_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[R-1][C-1]==1)
            return 0;

        obstacleGrid[R-1][C-1]=1;
        for(int i=R-2;i>=0;i--){
            if(obstacleGrid[i][C-1]==1)
                obstacleGrid[i][C-1]=0;
            else if(obstacleGrid[i+1][C-1]==1)
                obstacleGrid[i][C-1]=1;
        }

        for(int j=C-2;j>=0;j--){
            if(obstacleGrid[R-1][j]==1)
                obstacleGrid[R-1][j]=0;
            else if(obstacleGrid[R-1][j+1]==1)
                obstacleGrid[R-1][j]=1;
        }

        for(int i=R-2;i>=0;i--){
            for(int j=C-2;j>=0;j--){
                if(obstacleGrid[i][j]==0){
                    obstacleGrid[i][j] = obstacleGrid[i+1][j]+obstacleGrid[i][j+1];
                }else{
                    obstacleGrid[i][j]=0;
                }
            }
        }
        return obstacleGrid[0][0];
    }
}
