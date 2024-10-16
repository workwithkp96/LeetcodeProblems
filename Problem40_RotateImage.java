package Leetcode;

public class Problem40_RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int top=0,right=n-1;
        while(n>1){
            int left=top, bottom=right;
            for(int count=0;count<n-1;count++){
                int temp=matrix[top][left];
                matrix[top][left]=matrix[bottom][left-count];
                matrix[bottom][left-count]=matrix[bottom+count][right-count];
                matrix[bottom+count][right-count]=matrix[top+count][right];
                matrix[top+count][right]=temp;
                left++;
                bottom--;
            }
            n-=2;
            top++;
            right--;
        }
    }
}
