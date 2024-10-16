package Leetcode;

public class Problem80_RemoveDuplicateFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int N = nums.length;
        int count=1,j=0;
        for(int i=1;i<N;i++){
            if(nums[i]==nums[j]){
                if(count<2){
                    nums[++j]=nums[i];
                }
                count++;
            }else{
                nums[++j]=nums[i];
                count=1;
            }
        }
        return (j+1);
    }
}
