public class Problem105_ConstructBTFromPreOrder_InOrder {
    int pos=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getBT(preorder,inorder,0,inorder.length-1);
    }

    private TreeNode getBT(int[] preorder, int[] inorder, int left, int right) {
        if(left>right)
            return null;
        TreeNode root = new TreeNode(preorder[pos],null,null);
        int index = findPreOrderElement(inorder,left,right,preorder[pos]);
        pos++;
        if(index!=-1){

            root.left = getBT(preorder, inorder, left, index-1);
            root.right = getBT(preorder, inorder, index+1, right);
        }
        return root;
    }

    private int findPreOrderElement(int[] inorder, int left, int right, int target){
        for(int i=left;i<=right;i++){
            if(inorder[i]==target)
                return i;
        }
        return -1;
    }
}
