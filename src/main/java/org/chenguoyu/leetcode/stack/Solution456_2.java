package org.chenguoyu.leetcode.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 456. 132模式
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：
 * 当 i < j < k 时，ai < ak < aj。
 * 设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 * <p>
 * 注意：n 的值小于15000。
 */
public class Solution456_2 {
    /*
    输入: [1, 2, 3, 4]
    输出: False
    解释: 序列中不存在132模式的子序列。

    输入: [3, 1, 4, 2]
    输出: True
    解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
    */
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > min[i]) {
                while (!stack.isEmpty() && stack.peek() <= min[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }

    @Test
    public void main() {
        int[] nums = new int[]{1,0,1,-4,-3};
        System.out.println(find132pattern(nums));
    }
}
