package dec2020;

import java.util.LinkedList;
import java.util.Queue;

//173. Binary Search Tree Iterator
class BSTIterator {

    Queue<TreeNode> queueRoot = new LinkedList<>();


    public BSTIterator(TreeNode root) {

        helper(root);

    }

    public int next() {


        TreeNode node = queueRoot.poll();
        return node.val;

    }

    public boolean hasNext() {
        if (queueRoot.peek() != null) {
            return true;
        }
        return false;
    }

    public void helper(TreeNode root) {

        if (root.left != null) {
            helper(root.left);
        }

        queueRoot.add(root);

        if (root.right != null) {
            helper(root.right);
        }
    }
}
