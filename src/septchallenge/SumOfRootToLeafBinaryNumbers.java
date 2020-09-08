package septchallenge;

import java.util.ArrayList;
import java.util.List;

/*
1022. Sum of Root To Leaf Binary Numbers

Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.


Example 1:

Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22


Note:

The number of nodes in the tree is between 1 and 1000.
node.val is 0 or 1.
The answer will not exceed 2^31 - 1.
 */
public class SumOfRootToLeafBinaryNumbers {

    int globalStop = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.arrayAddBFS(new int[]{0}, root);

        System.out.println(sumRootToLeaf(root));
    }

    public static int sumRootToLeaf(TreeNode root) {

        if (root == null) {
            return 0;
        }

        List<String> result = new ArrayList<>();
        int resultInt = 0;
        helperV2(root, "", result);
        System.out.println(dfs(root, 0));

        for (int i = 0; i < result.size(); i++) {
            //Binary String to a base 10 integer in Java
            int temp = Integer.parseInt(result.get(i), 2);
            ;
            resultInt += temp;
        }
        return resultInt;

    }


    private static int dfs(TreeNode node, int result) {
        if (node == null) {
            return 0;
        }

        int num = 2 * result + node.val;

        return node.left == node.right ? num : dfs(node.left, num) + dfs(node.right, num);

    }

    public static void helper(TreeNode node, List<Integer> arr, List<List<Integer>> listLeafToNode) {

        if (node.left == null || node.right == null) {
            arr.add(node.val);
            listLeafToNode.add(new ArrayList<>(arr));
            return;
        }

        arr.add(node.val);
        helper(node.left, arr, listLeafToNode);
        arr.remove(arr.size() - 1);
        helper(node.right, arr, listLeafToNode);
        arr.remove(arr.size() - 1);
    }

    public static void helperV2(TreeNode node, String str, List<String> listLeafToNode) {
        if (node == null) return;
        //Compare the node.left and node.right if its not null continue
        if (node.left == node.right) {
            str += String.valueOf(node.val);
            listLeafToNode.add(str);
            return;
        }
        str += String.valueOf(node.val);
        helperV2(node.left, str, listLeafToNode);
        //String is immutable we dont need to change the reference
        helperV2(node.right, str, listLeafToNode);

    }

    public static void helperV3(TreeNode node, String str, List<String> listLeafToNode) {

        str += String.valueOf(node.val);
        if (node.left != null) {
            helperV3(node.left, str, listLeafToNode);
        }

        listLeafToNode.add(str);


        if (node.right != null) {
            helperV3(node.right, str, listLeafToNode);
        }
    }

}

