package org.chenguoyu.leetcode.array;

import org.junit.Test;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class Solution152 {
    /*
        输入: [2,3,-2,4]
        输出: 6
        解释: 子数组 [2,3] 有最大乘积 6。
    */

    /**
     * 状态转移方程为
     * f(i) = max(nums[i],nums[i]*iMax,nums[i]*iMin)
     * f(i) = min(nums[i],nums[i]*iMax,nums[i]*iMin)
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int iMin = nums[0];
        int iMax = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = iMax, min = iMin;
            iMax = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            iMin = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
            result = Math.max(iMax, result);
        }
        return result;
    }

    @Test
    public void main() {
//        int[] nums = new int[]{2, 3, -2, 4};
        int[] nums = new int[]{-1, -2, -9, -6};
        System.out.println(maxProduct(nums));
    }
}
