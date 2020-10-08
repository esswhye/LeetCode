package algo.leetcode700;


public class SearchInABinarySearchTree {

    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = new TreeNode();
        node = searchBSTHelper(root, val);
        return node;


    }

    public TreeNode searchBSTHelper(TreeNode root, int val) {
        if (root.val == val) {
            return root;
        }

        if (val < root.val) {
            if (root.left != null)
                root = searchBST(root.left, val);
        } else if (val > root.val) {
            if (root.right != null)
                root = searchBST(root.right, val);
        } else if (root.right == null && root.left == null) {
            return null;
        }

        return root;
    }

    public TreeNode searchBSTV2(TreeNode root, int val) {
        if (root == null)
            return null;
        if (val < root.val)
            return searchBST(root.left, val);
        else if (val > root.val)
            return searchBST(root.right, val);
        else return root; //if(val==root.val)
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
