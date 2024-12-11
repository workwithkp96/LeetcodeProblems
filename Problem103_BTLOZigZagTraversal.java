import com.sun.source.tree.Tree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class Problem103_BTLOZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> d= new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;

        d.offer(root);
        int k=1;
        while(!d.isEmpty()){
            int n= d.size();
            List<Integer> res = new ArrayList<>();
            if(k%2!=0){
                for(int i=0;i<n;i++){
                    TreeNode temp=d.pollFirst();
                    res.add(temp.val);

                    if(temp.left!=null)
                        d.offerLast(temp.left);
                    if(temp.right!=null)
                        d.offerLast(temp.right);
                }
            }else{
                for(int i=0;i<n;i++){
                    TreeNode temp = d.pollLast();
                    res.add(temp.val);

                    if(temp.right!=null)
                        d.offerFirst(temp.right);
                    if(temp.left!=null)
                        d.offerFirst(temp.left);
                }
            }

            result.add(res);
            k++;
        }
        return result;
    }
}
