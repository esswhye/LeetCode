package dec2020;

//98. Validate Binary Search Tree

public class ValidateBinarySearchTree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(6, new TreeNode(3), new TreeNode(7)));

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();

        System.out.println(validateBinarySearchTree.isValidBST(root));
    }
    //low grand parents high parents
    public boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
}
