package org.chenguoyu.leetcode.dynamic_programing.optimal_substructure;


import org.junit.Test;

/**
 * 打家劫舍II 动态规划
 */
public class Solution213_2 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    // 考虑抢劫nums[index...length]区间内房屋
    public int rob(int[] nums, int index, int length) {
        int[] memory = new int[length + 1];
        memory[length] = nums[length];
        for (int i = length; i >= index; i--) {
            for (int j = i; j <= length; j++) {
                memory[i] = Math.max(memory[i], nums[j] + (j + 2 <= length ? memory[j + 2] : 0));
            }
        }
        return memory[index];
    }

    @Test
    public void main() {
        int[] nums = new int[]{2,3,2};
        System.out.println(rob(nums));
    }
}
