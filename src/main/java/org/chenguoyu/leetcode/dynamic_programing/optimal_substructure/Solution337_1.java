package org.chenguoyu.leetcode.dynamic_programing.optimal_substructure;


import org.chenguoyu.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 337 打家劫舍 III
 * 记忆化搜索
 */
public class Solution337_1 {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Map<TreeNode, Integer> memory = new HashMap<>();
        return rob(root, memory);
    }

    private int rob(TreeNode root, Map<TreeNode, Integer> memory) {
        if (root == null) {
            return 0;
        }
        if (memory.containsKey(root)) {
            return memory.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left, memory) + rob(root.left.right, memory);
        }
        if (root.right != null) {
            money += rob(root.right.left, memory) + rob(root.right.right, memory);
        }
        int maxMoney = Math.max(rob(root.left, memory) + rob(root.right, memory), money);
        memory.put(root, maxMoney);
        return maxMoney;
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
