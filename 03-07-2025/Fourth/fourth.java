class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class fourth {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static TreeNode find(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) return root;
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] values = {6, 2, 8, 0, 4, 7, 9, 3, 5};
        TreeNode root = null;
        for (int val : values) {
            root = insert(root, val);
        }
        TreeNode p = find(root, 2);
        TreeNode q = find(root, 8);
        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("LCA: " + (lca != null ? lca.val : "null"));
    }
}
