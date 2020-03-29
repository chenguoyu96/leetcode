package org.chenguoyu.leetcode.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 */
public class Solution503 {
    /**
     * 求下一个最大值的时候可以倒序遍历
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for (int j = 0; j < 2; j++) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    if (stack.peek() > nums[i]) {
                        result[i] = stack.peek();
                    } else {
                        while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                            stack.pop();
                        }
                        if (stack.isEmpty()) {
                            result[i] = -1;
                        } else {
                            result[i] = stack.peek();
                        }
                    }
                }
                stack.push(nums[i]);
            }
        }
        return result;
    }

    @Test
    public void main() {
        int[] nums = new int[]{1, 2, 1};
        nextGreaterElements(nums);
    }
}
