package BitManipulations;

public class Problem137_SingleNumberII {
    public int singleNumber(int[] nums) {
        int N = nums.length;
        int ans=0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int j=0;j<N;j++){
                if(((nums[j]>>i)&1)==1)
                    count++;
            }
            if(count%3!=0)
                ans= ans|(1<<i);
        }
        return ans;
    }
}
