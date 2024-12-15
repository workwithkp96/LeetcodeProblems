import java.util.ArrayList;
import java.util.List;

public class Problem113_SumRootToLeaf {
    List<List<Integer>> result = null;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        getPathSum(root,targetSum,new ArrayList<>());
        return result;

    }

    public void getPathSum(TreeNode root,int targetSum, List<Integer> temp){
        if(root==null)
            return;

        temp.add(root.val);
        if(root.val==targetSum && root.left==null && root.right==null){
            result.add(new ArrayList<>(temp));
        }

        getPathSum(root.left,targetSum-root.val,temp);
        getPathSum(root.right, targetSum- root.val,temp);

        temp.removeLast();
    }
}
