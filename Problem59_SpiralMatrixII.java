package Leetcode;

public class Problem59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result= new int[n][n];
        int val=1;
        int i=0,j=0;
        while(n>1){
            for(int count=0;count<n-1;count++){
                result[i][j++]=val++;
            }
            for(int count=0;count<n-1;count++){
                result[i++][j]=val++;
            }
            for(int count=0;count<n-1;count++){
                result[i][j--]=val++;
            }
            for(int count=0;count<n-1;count++){
                result[i--][j]=val++;
            }
            i+=1;
            j+=1;
            n-=2;
        }
        if(n==1){
            result[i][j]=val;
        }
        return result;
    }
}
