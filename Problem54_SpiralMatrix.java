package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int i=0,j=0;
        while(m>1 && n>1){
            for(int count=0;count<n-1;count++){
                result.add(matrix[i][j++]);
            }
            for(int count=0;count<m-1;count++){
                result.add(matrix[i++][j]);
            }
            for(int count=0;count<n-1;count++){
                result.add(matrix[i][j--]);
            }
            for(int count=0;count<m-1;count++){
                result.add(matrix[i--][j]);
            }
            m-=2;
            n-=2;
            i++;
            j++;
        }
        if(m==1){
            for(int count=0;count<n;count++){
                result.add(matrix[i][j++]);
            }
        }else if(n==1){
            for(int count=0;count<m;count++){
                result.add(matrix[i++][j]);
            }
        }
        return result;
    }
}

