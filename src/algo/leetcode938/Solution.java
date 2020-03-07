package algo.leetcode938;

public class Solution {

    public static void main(String[] args) {
        //[10,5,15,3,7,null,18]
        int arr[] = {10, 5, 15, 3, 7, 0, 18};

        TreeNode root = (new TreeNode(10));

        for(int i = 0; i<arr.length; i++)
        {
            root.add(arr[i]);
        }

        System.out.println(rangeSumBST(root, 7 ,15));

    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        } else if (root.val >= L && root.val <= R) {
            return root.val + (rangeSumBST(root.left, L, R) + (rangeSumBST(root.right, L, R)));
        } else if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else {
            return rangeSumBST(root.left, L, R);
        }

    }

}

class TreeNode{

    int val;
    TreeNode right;
    TreeNode left;

    public TreeNode(int val) {
        this.val = val;
    }

    public void add(int data)
    {
        TreeNode noteToAdd = new TreeNode(data);

        traverseAndAddNode(this, noteToAdd);
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
}





