import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Problem117_PopulatingNextToRightNod {
    public Node connect(Node root) {
        if(root==null)
            return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int n = q.size();
            Node prev = null;
            for(int i=0;i<n;i++){
                Node temp = q.poll();
                if(prev!=null){
                    prev.next = temp;
                }
                prev = temp;

                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
        }
        return root;
    }
}
