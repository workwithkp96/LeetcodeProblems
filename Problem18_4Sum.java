package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result= new ArrayList<>();
        int len = nums.length;
        if(len<4)
            return result;
        Arrays.sort(nums);

        for(int i=0;i<len-3;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;

            for(int j=i+1;j<len-2;j++){
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;

                int left=j+1,right=len-1;
                while(left<right){
                    long sum=(long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        result.add(List.of(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left<right && nums[left]==nums[left-1])
                            left++;
                    }else if(sum>target){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
