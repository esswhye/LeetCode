package algo.leetcode1315;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode original = new TreeNode(new int[]{4,7,2,1,8,6});
        //original.inOrderTraverse(original);
        Solution s = new Solution();
        System.out.println(s.sumEvenGrandparent(original));
    }
    int result = 0;
    public int sumEvenGrandparent(TreeNode root) {
        searchEvenNumGP(root,null,null);
        return result;
    }

    public void searchEvenNumGP(TreeNode curr, TreeNode gp ,TreeNode p)
    {
        if(curr==null)
        {
            return;
        }
        if( gp !=null && gp.val%2==0 )
        {
            result+=curr.val;
        }

        searchEvenNumGP(curr.left,p,curr);
        searchEvenNumGP(curr.right,p,curr);
    }
}
class TreeNode {

    int val;
    TreeNode right;
    TreeNode left;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int[] arr) {
        addAll(arr);
    }

    public void add(int data) {
        TreeNode noteToAdd = new TreeNode(data);

        traverseAndAddNode(this, noteToAdd);
    }

    private void addAll(int[] arr) {
        this.val = arr[0];
        for (int i = 1; i < arr.length; i++) {
            TreeNode noteToAdd = new TreeNode(arr[i]);
            traverseAndAddNode(this, noteToAdd);
        }

    }

    private void traverseAndAddNode(TreeNode root, TreeNode noteToAdd) {

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

    public static void inOrderTraverse(TreeNode node) {
        if (node.left != null) {
            inOrderTraverse(node.left);
        }

        System.out.println(node.val);

        if (node.right != null) {
            inOrderTraverse(node.right);
        }
    }

    public int calculateSum(TreeNode temp) {
        int sum, sumLeft, sumRight;
        sum = sumRight = sumLeft = 0;
        //Calculate the sum of nodes present in left subtree
        if (temp.left != null)
            sumLeft = calculateSum(temp.left);

        //Calculate the sum of nodes present in right subtree
        if (temp.right != null)
            sumRight = calculateSum(temp.right);

        //Calculate the sum of all nodes by adding sumLeft, sumRight and root node's data
        sum = temp.val + sumLeft + sumRight;
        return sum;
    }


    public void BFS(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        TreeNode nodeToAdd;

        while (!queue.isEmpty()) {
            nodeToAdd = queue.poll();
            if (nodeToAdd.left != null) {
                queue.add(nodeToAdd.left);
            }
            if (nodeToAdd.right != null) {
                queue.add(nodeToAdd.right);
            }
        }
    }

}

