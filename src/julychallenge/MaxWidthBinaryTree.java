package julychallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a binary tree, write a function to get the maximum width of the given tree. The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

It is guaranteed that the answer will in the range of 32-bit signed integer.

Example 1:

Input:

           1
         /   \
        3     2
       / \     \
      5   3     9

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:

Input:

          1
         /
        3
       / \
      5   3

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:

Input:

          1
         / \
        3   2
       /
      5

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:

Input:

          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Constraints:

The given binary tree will have between 1 and 3000 nodes.
 */
public class MaxWidthBinaryTree {

    static int max = 1;

    public static void main(String[] args) {
        ThisTreeNode node = new ThisTreeNode(1);
        node.left = new ThisTreeNode(3);
        node.right = new ThisTreeNode(2);
        node.left.left = new ThisTreeNode(5);


        System.out.println(node.left.left.val);
        System.out.println(bfs(node));

    }

    //Each lvl
    public static int widthOfBinaryTree(ThisTreeNode root) {
        //return bfs(root);
        List<Integer> start = new ArrayList<>();
        dsf(root, 0, 1, start);
        return max;
    }

    //Every node.right will increment by 1 using 2*index +1
    public static int bfs(ThisTreeNode root) {
        if (root == null)
            return 0;

        LinkedList<Pair<ThisTreeNode, Integer>> queue = new LinkedList<>();
        Integer maxWidth = 0;

        queue.addLast(new Pair<>(root, 0));

        while (queue.size() > 0) {
            Pair<ThisTreeNode, Integer> head = queue.getFirst();
            Integer currentLvlSize = queue.size();
            Pair<ThisTreeNode, Integer> elem = null;

            //Each lvl
            for (int i = 0; i < currentLvlSize; i++) {
                elem = queue.removeFirst();
                ThisTreeNode node = elem.first;

                if (node.left != null) {
                    queue.add(new Pair<>(node.left, 2 * elem.second));
                }
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, 2 * elem.second + 1));
                }
                // On the lvl  maxWidth,endNode,startNode+1
                maxWidth = Math.max(maxWidth, elem.second - head.second + 1);
            }
        }

        return maxWidth;
    }

    public static void dsf(ThisTreeNode node, int level, int index, List<Integer> start) {

        if (node == null) {
            return;
        }
        if (level == start.size()) start.add(index);
        max = Math.max(max, index + 1 - start.get(level));
        dsf(node.left, level + 1, 2 * index, start);
        dsf(node.right, level + 1, 2 * index + 1, start);

    }


}

class Pair<T, E> {
    final T first;
    final E second;

    public Pair(T first, E second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }
}

class ThisTreeNode {
    int val;
    ThisTreeNode left;
    ThisTreeNode right;

    ThisTreeNode(int x) {
        val = x;
    }
}
