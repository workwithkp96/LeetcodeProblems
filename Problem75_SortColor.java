package Leetcode;

public class Problem75_SortColor {
    public void sortColors(int[] nums) {
        int N = nums.length;
        int red=0,white=0,blue=N-1;
        while(white<N && nums[white]==0){
            red++;
            white++;
        }
        while(blue>=0 && nums[blue]==2){
            blue--;
        }
        while(white<=blue){
            if(nums[white]==0){
                int temp=nums[red];
                nums[red]=nums[white];
                nums[white]=temp;
                red++;
                white++;
            }else if(nums[white]==2){
                int temp = nums[blue];
                nums[blue] = nums[white];
                nums[white]=temp;
                blue--;
            }else{
                white++;
            }
        }
    }
}
