package dec2020;

//865. Smallest Subtree with all the Deepest Nodes
public class SmallestSubtreeWithAllTheDeepestNodes {

    int maxDepth = 0;
    TreeNode result = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        helper(root, 0);
        return result;
    }

    public int helper(TreeNode root, int depth) {
        if (root == null) return depth - 1;
        //found
        if (maxDepth < depth) maxDepth = depth;
        int left = helper(root.left, depth + 1);
        int right = helper(root.right, depth + 1);
        if (left == maxDepth && right == maxDepth) result = root;
        return Math.max(left, right);
    }

}
