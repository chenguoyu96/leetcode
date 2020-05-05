package org.chenguoyu.leetcode.array;

import org.junit.Test;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 */
public class Solution75 {
    /*
    输入: [2,0,2,1,1,0]
    输出: [0,0,1,1,2,2]
    * */
    public void sortColors(int[] nums) {
        int length = nums.length;
        int l = 0, r = length - 1, i = 0;
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, i++, l++);
            } else if (nums[i] == 2) {
                swap(nums, i, r--);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void main() {
//        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        int[] nums = new int[]{2, 0, 1};
        sortColors(nums);
        System.out.println(nums);
    }
}
