package org.chenguoyu.leetcode.dynamic_programing.optimal_substructure;


import org.junit.Test;

/**
 * 打家劫舍II 记忆化搜索解法
 */
public class Solution213_1 {
    private Integer[] memory;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        memory = new Integer[nums.length];
        rob(nums, 0, nums.length - 1);
        int result1 = memory[0];
        memory = new Integer[nums.length];
        rob(nums, 1, nums.length);
        return Math.max(result1, memory[1]);
    }

    /**
     * 考虑签解nums[index...nums.length)范围内的所有房子
     *
     * @param nums
     * @param index
     * @return
     */
    private int rob(int[] nums, int index, int length) {
        if (index == length) {
            return 0;
        }
        if (memory[index] != null) {
            return memory[index];
        }
        int result = 0;
        for (int i = index; i < length; i++) {
            result = Math.max(result, nums[i] + (i + 2 < length ? rob(nums, i + 2, length) : 0));
        }
        memory[index] = result;
        return memory[index];
    }

    @Test
    public void main() {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
