package septchallenge;

import java.util.ArrayList;
import java.util.List;

/* 1305
Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.



Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]
Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]
Example 4:

Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]
Example 5:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 */
public class AllElementsinTwoBinarySearchTrees {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(4, null, null));

        TreeNode root2 = new TreeNode(1, new TreeNode(0, null, null), new TreeNode(3, null, null));

        getAllElements(root1, root2);


    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> result = new ArrayList<>();
        List<Integer> root1List = new ArrayList<>();
        List<Integer> root2List = new ArrayList<>();

        DFS(root1, root1List);
        DFS(root2, root2List);

        merging(root1List, root2List, result);
        return result;
    }

    private static void DFS(TreeNode nodeTraverse, List<Integer> root) {
        if (nodeTraverse == null) {
            return;
        }
        DFS(nodeTraverse.left, root);
        root.add(nodeTraverse.val);
        DFS(nodeTraverse.right, root);
    }

    private static void merging(List<Integer> leftArray, List<Integer> rightArray, List<Integer> arr) {


        int i = 0, j = 0, k = 0;

        while (i < leftArray.size() && j < rightArray.size()) {
            if (leftArray.get(i) > rightArray.get(j)) {
                arr.add(rightArray.get(j++));
            } else if (leftArray.get(i) <= rightArray.get(j))
                arr.add(leftArray.get(i++));
        }

        for (; j < rightArray.size(); j++) {

            arr.add(rightArray.get(j));
        }
        for (; i < leftArray.size(); i++) {
            arr.add(leftArray.get(i));
        }
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
