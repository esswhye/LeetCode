package augchallenge;

import java.util.ArrayList;
import java.util.List;

/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */
public class PathSumIII {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    static int counter = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode node = new TreeNode(new int[]{5, 6, 3, 7, 1, 2, 8, 9});
        System.out.println(pathSumV2(node, 8));
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, sum) + pathSum2(root, sum) + pathSum(root.right, sum);
    }

    private int pathSum2(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum) res++;
        res += pathSum2(root.left, sum - root.val);
        res += pathSum2(root.right, sum - root.val);
        return res;
    }

    //First 10|5|3|3 --> 10|5|3 --> 10|5 --> 10 backtracking summing 3+3|3+3+5|3+3+5|10| --> 3+5|3+5+10
    public static int pathSumV2(TreeNode root, int sum) {

        calculateSum(root, sum);
        return counter;
    }

    private static void calculateSum(TreeNode node, int sum) {
        if (node == null)
            return;

        list.add(node.val);
        calculateSum(node.left, sum);
        calculateSum(node.right, sum);

        int temp = 0;

        for (int i = list.size() - 1; i >= 0; i--) {
            temp += list.get(i);

            if (temp == sum)
                counter++;
        }
        list.remove(list.size() - 1);
    }
}

