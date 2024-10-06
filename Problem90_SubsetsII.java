import java.util.*;

public class Problem90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        getSubsets(nums,0,N, new ArrayList<Integer>(), result);
        return result.stream().toList();
    }

    private void getSubsets(int[] nums, int index, int n, ArrayList<Integer> temp, Set<List<Integer>> result) {
        result.add(new ArrayList<>(temp));

        for(int i=index;i<n;i++){
            temp.add(nums[i]);
            getSubsets(nums,i+1,n,temp,result);
            temp.removeLast();
        }
    }

    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
