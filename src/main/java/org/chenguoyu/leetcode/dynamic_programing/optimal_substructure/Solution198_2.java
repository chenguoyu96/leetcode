package org.chenguoyu.leetcode.dynamic_programing.optimal_substructure;


import org.junit.Test;

/**
 * 打家劫舍 动态规划解法
 */
public class Solution198_2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] memory = new int[length];
        memory[length - 1] = nums[length - 1];
        //考虑抢劫nums[0,nums.length-1]的房屋
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                memory[i] = Math.max(memory[i], nums[j] + (j + 2 < nums.length ? memory[j + 2] : 0));
            }
        }
        return memory[0];
    }


    @Test
    public void main() {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}
