package org.chenguoyu.leetcode.dynamic_programing.optimal_substructure;


import org.junit.Test;

/**
 * 打家劫舍 记忆化搜索解法
 */
public class Solution198_1 {
    private Integer[] memory;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        memory = new Integer[nums.length];
        rob(nums, 0);
        return memory[0];
    }

    /**
     * 考虑签解nums[index...nums.length)范围内的所有房子
     *
     * @param nums
     * @param index
     * @return
     */
    private int rob(int[] nums, int index) {
        if (index == nums.length) {
            return 0;
        }
        if (memory[index] != null) {
            return memory[index];
        }
        int result = 0;
        for (int i = index; i < nums.length; i++) {
            result = Math.max(result, nums[i] + (i + 2 < nums.length ? rob(nums, i + 2) : 0));
        }
        memory[index] = result;
        return memory[index];
    }

    @Test
    public void main() {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}
