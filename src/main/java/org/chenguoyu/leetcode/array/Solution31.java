package org.chenguoyu.leetcode.array;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 */
public class Solution31 {
    /*
        1,2,3 → 1,3,2
        3,2,1 → 1,2,3
        1,1,5 → 1,5,1
    */
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) {
            return;
        }
        int i = length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void main() {
//        int[] nums = new int[]{1, 2, 3};
//        int[] nums = new int[]{1, 3, 2};
        int[] nums = new int[]{2, 3, 1};
//        int[] nums = new int[]{3, 2, 1};
//        int[] nums = new int[]{1, 1, 5};
        nextPermutation(nums);
        System.out.println(JSONObject.toJSONString(nums));
    }
}
