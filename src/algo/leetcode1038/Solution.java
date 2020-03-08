package algo.leetcode1038;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    //Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
    //Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

    int sum = 0;
    public static void main(String[] args) {

        int arr[] = {4,1,6,0,2,5,7,3,8};
        TreeNode root = new TreeNode(arr);


        Solution s = new Solution();
        //s.bstToGst(root);

        root.BFS(root);

    }

    //Traverse from left the right on a sorted element
    public TreeNode bstToGst(TreeNode node) {

        if(node.right!=null)
        {
            bstToGst(node.right);
        }

        sum += node.val;
        node.val= sum;

        if(node.left!=null)
        {
            bstToGst(node.left);
        }
        return node;
    }
    /*
    int sum = 0;
    public TreeNode bstToGst(TreeNode node) {
        if(node == null) return null;

        bstToGst(node.right);
        sum += node.val;
        node.val= sum;
        bstToGst(node.left);

        return node;
    }
     */
}

class TreeNode{

    int val;
    TreeNode right;
    TreeNode left;

    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int[] arr)
    {
        addAll(arr);
    }

    public void add(int data)
    {
        TreeNode noteToAdd = new TreeNode(data);

        traverseAndAddNode(this, noteToAdd);
    }

    private void addAll(int[] arr)
    {
        this.val = arr[0];
        for(int i = 1; i<arr.length; i++)
        {
            TreeNode noteToAdd = new TreeNode(arr[i]);
            traverseAndAddNode(this, noteToAdd);
        }

    }

    private void traverseAndAddNode(TreeNode root, TreeNode noteToAdd) {

        if(root.val>noteToAdd.val)
        {
            if(root.left == null)
            {
                root.left = noteToAdd;
            }
            else{
                traverseAndAddNode(root.left, noteToAdd);
            }
        }
        else if (root.val< noteToAdd.val)
        {
            if(root.right == null)
            {
                root.right = noteToAdd;
            }
            else{
                traverseAndAddNode(root.right, noteToAdd);
            }
        }
    }

    public static void inOrderTraverse(TreeNode node)
    {
        if(node.left != null)
        {
            inOrderTraverse(node.left);
        }

        System.out.println(node.val);

        if(node.right != null)
        {
            inOrderTraverse(node.right);
        }
    }

    public int calculateSum(TreeNode temp){
        int sum, sumLeft, sumRight;
        sum = sumRight = sumLeft = 0;
        //Calculate the sum of nodes present in left subtree
        if(temp.left != null)
            sumLeft = calculateSum(temp.left);

        //Calculate the sum of nodes present in right subtree
        if(temp.right != null)
            sumRight = calculateSum(temp.right);

        //Calculate the sum of all nodes by adding sumLeft, sumRight and root node's data
        sum = temp.val + sumLeft + sumRight;
        return sum;
    }


    public void BFS(TreeNode node)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        TreeNode nodeToAdd;

        while(!queue.isEmpty()){
            nodeToAdd = queue.poll();
            if(nodeToAdd.left != null)
            {
             queue.add(nodeToAdd.left);
            }
            if(nodeToAdd.right != null)
            {
                queue.add(nodeToAdd.right);
            }
        }
     }
}

