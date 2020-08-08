package augchallenge;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversalBT {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(new int[]{5, 6, 3, 7, 1, 2, 8, 9});
        //node.BFS();
        node.verticalTraversal(node);
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


    public void BFS() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        TreeNode nodeToAdd;

        while (!queue.isEmpty()) {
            nodeToAdd = queue.poll();
            System.out.println(nodeToAdd.val);
            if (nodeToAdd.left != null) {
                queue.add(nodeToAdd.left);

            }
            if (nodeToAdd.right != null) {
                queue.add(nodeToAdd.right);
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode node) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        SortedMap<Integer, List<Integer>> map = new TreeMap<>();
        queue.add(new Pair<>(this, 0));
        TreeNode nodeToAdd;


        while (!queue.isEmpty()) {

            nodeToAdd = queue.peek().getFirst();
            int dist = queue.peek().getSecond();
            queue.poll();
            mapToVertical(dist, nodeToAdd.val, map);

            if (nodeToAdd.left != null) {
                queue.add(new Pair<>(nodeToAdd.left, dist - 1));

            }
            if (nodeToAdd.right != null) {
                queue.add(new Pair<>(nodeToAdd.right, dist + 1));

            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue().stream().sorted().collect(Collectors.toList()));
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        return result;
    }

    private void mapToVertical(int dist, int value, SortedMap<Integer, List<Integer>> map) {

        if (!map.containsKey(dist)) {
            map.put(dist, new ArrayList(Arrays.asList(value)));
        } else {
            List<Integer> list = map.get(dist);
            list.add(value);
            map.put(dist, list);
        }
    }
}

class Pair<E, V> {

    private E first;
    private V second;

    public Pair(E first, V second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }
}