public class Problem114_FlattenBTToLinkedList {
    TreeNode prev;
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        prev= null;
        toLinkedList(root);
    }

    public void toLinkedList(TreeNode root){
        if(root==null)
            return;

        TreeNode rightNode = root.right;
        if(prev!=null) {
            prev.right = root;
            System.out.println(prev.val);
        }
        prev = root;
        toLinkedList(root.left);
        root.left = null;
        toLinkedList(rightNode);

    }
}
