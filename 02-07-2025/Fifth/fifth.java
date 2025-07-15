import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString().trim();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val).append(" ");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] vals = data.split(" ");
        Queue<Integer> queue = new LinkedList<>();
        for (String val : vals) queue.offer(Integer.parseInt(val));
        return build(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(Queue<Integer> queue, int lower, int upper) {
        if (queue.isEmpty()) return null;
        int val = queue.peek();
        if (val < lower || val > upper) return null;
        queue.poll();
        TreeNode node = new TreeNode(val);
        node.left = build(queue, lower, val);
        node.right = build(queue, val, upper);
        return node;
    }
}

public class fifth {
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);

        Codec codec = new Codec();
        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserializedRoot = codec.deserialize(serialized);
        System.out.print("Inorder of deserialized tree: ");
        inorder(deserializedRoot);
    }
}
