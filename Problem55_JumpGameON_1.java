package Leetcode;

public class Problem55_JumpGameON_1 {
    public boolean canJump(int[] nums) {
        int N = nums.length;
        if(N==1)
            return true;
        if(nums[0]==0)
            return false;

        int steps=nums[0];
        int maxReach = nums[0];
        int jump=1;
        for(int i=1;i<N;i++){
            maxReach = Math.max(maxReach,i+nums[i]);
            if(maxReach==N-1)
                return true;

            steps--;


            if(steps==0){
                jump++;
                if(i>=maxReach)
                    return false;
                steps = maxReach-i;
            }
        }
        return true;
    }
}
