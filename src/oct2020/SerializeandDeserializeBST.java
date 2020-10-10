package oct2020;

import java.util.Arrays;
import java.util.Iterator;

/*
449. Serialize and Deserialize BST

Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.



Example 1:

Input: root = [2,1,3]
Output: [2,1,3]
Example 2:

Input: root = []
Output: []
 */
public class SerializeandDeserializeBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(6);
        root.left = root2;
        root.right = root3;

        SerializeandDeserializeBST s = new SerializeandDeserializeBST();

        String tree = serialize(root);
        System.out.println(tree);

        TreeNode ans = deserialize(tree);
        System.out.println(ans);


        String treeString = s.serializeV2(root);
        System.out.println(treeString);

        TreeNode asd = s.deserializeV2(treeString);
        System.out.println();
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {

        // preorder traversal
        if (root == null) return "n";

        return "" + root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        //5,2,n,n,3,n,n split array 5 2 n n 3 n n iterator class
        return build(Arrays.stream(data.split(",")).iterator());
    }

    private static TreeNode build(Iterator<String> iterator) {

        if (!iterator.hasNext())
            return null;

        String cur = iterator.next();

        if (cur.equals("n"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = build(iterator);
        root.right = build(iterator);
        return root;
    }

    // Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;


    public String serializeV2(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString().trim();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    public TreeNode deserializeV2(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] s = data.split(",");
        TreeNode bst = constructBST(s, 0, s.length - 1);
        return bst;
    }

    private TreeNode constructBST(String[] s, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(s[start]));

        int index;
        for (index = start; index <= end; index++) {
            //find the end of leftnode
            if (Integer.parseInt(s[index]) > Integer.parseInt(s[start]))
                break;
        }

        root.left = constructBST(s, start + 1, index - 1);
        root.right = constructBST(s, index, end);
        return root;
    }
}
