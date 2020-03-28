package org.chenguoyu.leetcode.stack;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 456. 132模式
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：
 * 当 i < j < k 时，ai < ak < aj。
 * 设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 * <p>
 * 注意：n 的值小于15000。
 */
public class Solution456_1 {
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
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (stack.isEmpty()) {
                stack.add(num);
            } else if (stack.size() == 1) {
                if (num < stack.getLast()) {
                    stack.removeLast();
                }
                stack.addLast(num);
            } else if (stack.size() == 2) {
                if (stack.getFirst() < num && stack.getLast() > num) {
                    return true;
                } else {
                    if (stack.getFirst() > num) {
                        for (int j = i + 1; j < nums.length; j++) {
                            if (nums[j] > stack.getFirst() && nums[j] < stack.getLast()) {
                                return true;
                            }
                        }
                        stack.clear();
                        stack.addLast(num);
                        continue;
                    }
                    if (stack.getLast() <= num) {
                        stack.removeLast();
                        stack.addLast(num);
                    }
                }
            }
        }
        return false;
    }

    @Test
    public void main() {
        int[] nums = new int[]{-2, 1, -2};
        System.out.println(find132pattern(nums));
    }
}
