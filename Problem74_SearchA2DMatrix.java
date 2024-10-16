package Leetcode;

public class Problem74_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int R = matrix.length,C = matrix[0].length;
        int left=0,right=(R*C)-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            int r = mid/(C);
            int c = mid%(C);
            if(matrix[r][c]==target)
                return true;
            if(matrix[r][c]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return false;
    }
}
