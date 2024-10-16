package Leetcode;

public class Problem53_maximumSubarray {
    public int maxSubArray(int[] nums) {
        int N = nums.length;
        if(N==0)
            return 0;
        int curSum = nums[0];
        int maxSum = nums[0];
        for(int i=1;i<N;i++){
            curSum = Math.max(curSum+nums[i],nums[i]);
            maxSum = Math.max(maxSum,curSum);
        }
        return maxSum;
    }
}
