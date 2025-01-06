public class Problem129_SumRootToLeaveNumbers {
    int[] sum;
    public int sumNumbers(TreeNode root) {
        sum = new int[]{0};
        getSum(root,0);
        return sum[0];
    }

    private void getSum(TreeNode root,int presentSum) {
        if(root==null)
            return;

        if(root.left==null && root.right==null){
            sum[0]+=(presentSum*10)+ root.val;
            return;
        }

        getSum(root.left,(presentSum*10)+ root.val);
        getSum(root.right,(presentSum*10)+ root.val);

    }
}
