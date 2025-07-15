import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

class Pair {
    TreeNode node;
    int row, col;
    Pair(TreeNode n, int r, int c) {
        node = n;
        row = r;
        col = c;
    }
}

public class ninth {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            map.putIfAbsent(p.col, new TreeMap<>());
            map.get(p.col).putIfAbsent(p.row, new PriorityQueue<>());
            map.get(p.col).get(p.row).offer(p.node.val);
            if (p.node.left != null) queue.offer(new Pair(p.node.left, p.row + 1, p.col - 1));
            if (p.node.right != null) queue.offer(new Pair(p.node.right, p.row + 1, p.col + 1));
        }
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) colList.add(nodes.poll());
            }
            result.add(colList);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = verticalTraversal(root);
        for (List<Integer> col : res) {
            System.out.println(col);
        }
    }
}
