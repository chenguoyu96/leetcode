package org.chenguoyu.leetcode.array;

import org.junit.Test;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class Solution55 {
    /*
      输入: [2,3,1,1,4]
      输出: true
      解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return true;
        }
        int distance = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= distance) {
                distance = 1;
            } else {
                distance++;
            }
            if (i == 0 && distance > nums[0]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void main() {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }
}
