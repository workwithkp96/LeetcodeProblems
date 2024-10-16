package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getSubsets(nums,0,result,new ArrayList<Integer>());
        return result;
    }

    private void getSubsets(int[] nums, int n, List<List<Integer>> result, ArrayList<Integer> store) {
        result.add(new ArrayList<>(store));
        for(int i=n;i<nums.length;i++){
            store.add(nums[i]);
            getSubsets(nums,i+1,result,store);
            store.remove(store.size()-1);
        }
    }
}

//TC - O(n*(2^n))
