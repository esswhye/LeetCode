package algo.leetcode1038;

public class Solution {

    //Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
    //Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

    public static void main(String[] args) {

        int arr[] = {4,1,6,0,2,5,7,3,8};
        TreeNode root = new TreeNode(arr);

        int totalSum = root.calculateSum(root);
        root.inOrderTraverseGST(root,totalSum);
        TreeNode.inOrderTraverse(root);

    }

    public TreeNode bstToGst(TreeNode root) {
        return null;
    }
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

    //{0,1,2,3,4,5,6,7,8}
    public int inOrderTraverseGST(TreeNode node, int totalSum)
    {
        int left, right;
        left = right = 0;

        if(node.left != null)
        {
            inOrderTraverseGST(node.left,totalSum);
        }

        int temp = node.val;
        node.val += totalSum;
        totalSum=-temp;

        if(node.right != null)
        {
            inOrderTraverseGST(node.right,totalSum);
        }

        return totalSum;
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

}

