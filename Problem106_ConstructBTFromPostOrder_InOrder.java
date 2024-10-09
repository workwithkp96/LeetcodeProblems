public class Problem106_ConstructBTFromPostOrder_InOrder {
    int pos=-1;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pos=postorder.length-1;
        return getBT(postorder,inorder,0,pos);
    }
    private TreeNode getBT(int[] postorder, int[] inorder, int left, int right) {
        if(left>right)
            return null;
        TreeNode root = new TreeNode(postorder[pos],null,null);
        int index = findPreOrderElement(inorder,left,right,postorder[pos]);
        pos--;
        if(index!=-1){
            root.right = getBT(postorder, inorder, index+1, right);
            root.left = getBT(postorder, inorder, left, index-1);
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
