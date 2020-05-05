package org.chenguoyu.leetcode.array;

import org.junit.Test;

/**
 * 80. 删除排序数组中的重复项 II
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Solution80 {
    /*
    给定 nums = [1,1,1,2,2,3],

    函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。

    你不需要考虑数组中超出新长度后面的元素。
    * */
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return length;
        }
        int l = 0, count = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[l] && count < 2) {
                nums[++l] = nums[i];
                count++;
            }
            if (nums[i] != nums[l]) {
                nums[++l] = nums[i];
                count = 1;
            }
        }
        return l + 1;
    }

    @Test
    public void main() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
//        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
    }
}
