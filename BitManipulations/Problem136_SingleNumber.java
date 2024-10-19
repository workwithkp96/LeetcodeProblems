package BitManipulations;

public class Problem136_SingleNumber {
    public int singleNumber(int[] nums) {
        //XOR of same number will be zero
        //we will fetch the XOR value of all the elements.
        //only the unique element in the array will be standing
        //rest all will be zero
        int ans=0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;

    }
}
