package Leetcode;

public class Problem81_SearchInASortedRotatedArrayII {
    public boolean search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return true;
            }
            if( (nums[left] == nums[mid]) && (nums[right] == nums[mid]) ) {
                ++left;
                --right;
            }else if(nums[mid]<=nums[right]){
                if(target>nums[mid] && target<=nums[right])
                    left=mid+1;
                else
                    right=mid-1;
            }else{
                if(target<nums[mid] && target>=nums[left])
                    right=mid-1;
                else
                    left=mid+1;
            }
        }
        return false;
    }
}
