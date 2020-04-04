package org.chenguoyu.leetcode.array;

import org.junit.Test;

/**
 * 11. 盛最多水的容器
 */
public class Solution11 {
    /*
    给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

    说明：你不能倾斜容器，且 n 的值至少为 2。
     */
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int valueL = height[l];
            int valueR = height[r];
            maxArea = Math.max(maxArea, Math.min(valueL, valueR) * (r - l));
            if (valueL < valueR) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    @Test
    public void main() {
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
/*        int l = 0, r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }*/
        System.out.println(maxArea(nums));
    }
}
