package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> results = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparing(a->a[0]));
        int N = intervals.length;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<N;i++){
            if(intervals[i][0]<=end){
                start = Math.min(start,intervals[i][0]);
                end = Math.max(end,intervals[i][1]);
            }else{
                results.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        results.add(new int[]{start,end});
        return results.toArray(new int[results.size()][]);
    }
}
