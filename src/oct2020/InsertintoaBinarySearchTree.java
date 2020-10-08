package oct2020;

/*

701. Insert into a Binary Search Tree

You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.



Example 1:


Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
Explanation: Another accepted tree is:

Example 2:

Input: root = [40,20,60,10,30,50,70], val = 25
Output: [40,20,60,10,30,50,70,null,null,25]
Example 3:

Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
Output: [4,2,7,1,3,5]
 */
public class InsertintoaBinarySearchTree {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(4);

        if (node == null) {
            TreeNode node1 = new TreeNode(5);
            //return
        }
        TreeNode insertNode = new TreeNode(2);

        node.traverseAndAddNode(node, insertNode);
        System.out.println();
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

    public void traverseAndAddNode(TreeNode root, TreeNode noteToAdd) {

        if (root.val > noteToAdd.val) {
            if (root.left == null) {
                root.left = noteToAdd;
            } else {
                traverseAndAddNode(root.left, noteToAdd);
            }
        } else if (root.val < noteToAdd.val) {
            if (root.right == null) {
                root.right = noteToAdd;
            } else {
                traverseAndAddNode(root.right, noteToAdd);
            }
        }
    }
}
