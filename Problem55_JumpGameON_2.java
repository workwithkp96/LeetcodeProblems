package Leetcode;

public class Problem55_JumpGameON_2 {
    public boolean canJump(int[] nums) {
        int N = nums.length;
        if(N==1)
            return true;

        if(nums[0]==0)
            return false;

        nums[N-1]=0;
        for(int i=N-2;i>=0;i--){
            if(nums[i]==0){
                nums[i]=100001;
                continue;
            }
            int val = Integer.MAX_VALUE;
            for(int j=i+1;j<=Math.min(N-1,i+nums[i]);j++){
                val = Math.min(val,nums[j]);
            }
            nums[i]=1+val;
        }
        if(nums[0]<100001)
            return true;
        return false;
    }
}
