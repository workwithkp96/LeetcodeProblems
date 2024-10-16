package Leetcode;

import java.util.*;
import java.util.stream.Collectors;



public class Problem47_Permutation_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result =  new HashSet<>();
        int len = nums.length;
        findPermutations(nums,0,len,result);
        return result.stream().toList();
    }

    private void findPermutations(int[] nums, int idx, int len, Set<List<Integer>> result) {
        if(idx==len){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for(int i=idx;i<len;i++){
            if(i > idx && (nums[i] == nums[i - 1] || nums[i] == nums[idx]))
                continue;
            swap(nums,idx,i);
            findPermutations(nums,idx+1,len,result);
            swap(nums,idx,i);
        }
    }

    private void swap(int[] nums, int idx, int i) {
        int temp=nums[idx];
        nums[idx]=nums[i];
        nums[i]=temp;
    }
}
