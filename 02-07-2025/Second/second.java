class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        postorder(root);
        return maxSum;
    }

    private int[] postorder(TreeNode node) {
        if (node == null) return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left = postorder(node.left);
        int[] right = postorder(node.right);

        if (left[0] == 1 && right[0] == 1 && node.val > left[2] && node.val < right[1]) {
            int sum = left[3] + right[3] + node.val;
            maxSum = Math.max(maxSum, sum);
            return new int[]{1, Math.min(node.val, left[1]), Math.max(node.val, right[2]), sum};
        } else {
            return new int[]{0, 0, 0, 0};
        }
    }
}

public class second {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        Solution sol = new Solution();
        System.out.println(sol.maxSumBST(root));
    }
}
