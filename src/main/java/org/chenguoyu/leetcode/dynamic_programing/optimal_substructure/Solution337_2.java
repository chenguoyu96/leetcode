package org.chenguoyu.leetcode.dynamic_programing.optimal_substructure;


import org.chenguoyu.leetcode.common.TreeNode;
import org.junit.Test;

/**
 * 337 打家劫舍 III
 * 动态规划
 */
public class Solution337_2 {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int[] dp = dp(root);
        return Math.max(dp[0],dp[1]);
    }

    private int[] dp(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int[] result = new int[2];
        // 0表示不偷当前节点
        result[0] = Math.max(right[0], right[1]) + Math.max(left[0], left[1]);
        // 1表示偷当前节点
        result[1] = root.val + left[0] + right[0];
        return result;
    }

    @Test
    public void main() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        System.out.println(rob(root));
    }
}
