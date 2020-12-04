package dec2020;

import java.util.ArrayList;
import java.util.List;

//893
/*
Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.

 */
public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        nodeToList(arr, root);
        TreeNode ans = new TreeNode(0), cur = ans;

        for (int v : arr) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }

        return ans.right;

    }

    public void nodeToList(List<Integer> arr, TreeNode node) {

        if (node == null) {
            return;
        }

        if (node.left != null) {
            nodeToList(arr, node.left);
        }
        arr.add(node.val);
        if (node.right != null) {
            nodeToList(arr, node.right);
        }

    }
}
