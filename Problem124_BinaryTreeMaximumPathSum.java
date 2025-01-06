public class Problem124_BinaryTreeMaximumPathSum {
    int[] maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = new int[]{Integer.MIN_VALUE};
        getMaxPathSum(root);
        return maxSum[0];
    }

    private int getMaxPathSum(TreeNode root) {
        if(root==null)
            return 0;

        int leftSum = getMaxPathSum(root.left);
        int rightSum = getMaxPathSum(root.right);
        int currentSum = root.val;

        if(leftSum>=0)
            currentSum+=leftSum;
        if(rightSum>=0)
            currentSum+=rightSum;

        maxSum[0] = Math.max(maxSum[0],currentSum);

        if(leftSum<0 && rightSum<0)
            return root.val;

        return root.val + Math.max(leftSum,rightSum);
    }
}
