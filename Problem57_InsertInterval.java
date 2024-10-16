package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem57_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int N = intervals.length;
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<N;i++){
            if(newInterval[0]>intervals[i][1]){
                result.add(intervals[i]);
            }else if(intervals[i][0]>newInterval[1]){
                result.add(newInterval);
                for(int j=i;j<N;j++){
                    result.add(intervals[j]);
                }
                return result.toArray(new int[result.size()][]);
            }else{
                newInterval[0]= Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]= Math.max(newInterval[1],intervals[i][1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
