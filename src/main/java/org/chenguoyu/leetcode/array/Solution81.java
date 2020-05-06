package org.chenguoyu.leetcode.array;

import org.junit.Test;

/**
 * 81. 搜索旋转排序数组 II
 */
public class Solution81 {
    /*
        假设按照升序排序的数组在预先未知的某个点上进行了旋转。

        ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

        编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
    * */
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return false;
        }
        if (length == 1) {
            return nums[0] == target;
        }
        int start = 0, end = length - 1;
        int mid;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            int midValue = nums[mid];
            if (midValue == target) {
                return true;
            }
            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }
            if (nums[start] < nums[mid]) {
                //target在前半部分
                if (nums[mid] > target && nums[start] <= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;

                }
            }
        }
        return false;
    }


    @Test
    public void main() {
//      int[] nums = new int[]{0, 0, 1, 2, 2, 5, 6};
//        int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
//        int[] nums = new int[]{1, 1, 3, 1};
        int[] nums = new int[]{3, 1, 1};
        System.out.println(search(nums, 3));
    }
}
