package julychallenge;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

/*

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

        For example:
        Given binary tree [3,9,20,null,null,15,7],
        3
        / \
       9  20
         /  \
        15   7
        return its bottom-up level order traversal as:
        [
        [15,7],
        [9,20],
        [3]
        ]
 */
public class BinaryTreeLevelOrderTraversalTwo {


    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        List<List<Integer>> list = levelOrderBottom(node);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " ");
            for (int f = 0; f < list.get(i).size(); f++) {
                System.out.print(" " + (list.get(i).get(f)));
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> list = new ArrayList();
        if (root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> levelNode = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();

                levelNode.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            list.add(0, levelNode);
        }


        return list;
    }

    public static void traverse(TreeNode node) {
        if (node.left != null)
            traverse(node.left);
        if (node.right != null)
            traverse(node.right);
        System.out.println(node.val);
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

    TreeNode(int val, TreeNode left,
             TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}