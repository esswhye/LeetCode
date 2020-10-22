package oct2020;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {


    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int minDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode tempNode = queue.poll();
            minDepth++;

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }

        }


        return minDepth;

    }
}
