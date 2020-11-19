package oct2020;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {


    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));

        while (!queue.isEmpty()) {

            Pair pair = queue.poll();
            int depth = pair.depth;
            TreeNode node = pair.node;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.add(new Pair(node.left, depth + 1));
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, depth + 1));
            }

        }
        return 0;

    }
}

class Pair {
    TreeNode node;
    int depth;

    public Pair(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}
