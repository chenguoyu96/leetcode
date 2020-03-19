package org.chenguoyu.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 合并两个有序数组
 */
public class Solution88_2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums2IndexEnd = n - 1;
        int nums1IndexEnd = m - 1;
        int index = nums1.length - 1;
        while (nums2IndexEnd >= 0 && nums1IndexEnd >= 0) {
            if (nums1[nums1IndexEnd] > nums2[nums2IndexEnd]) {
                nums1[index--] = nums1[nums1IndexEnd--];
            } else {
                nums1[index--] = nums2[nums2IndexEnd--];
            }
        }
        if (nums2IndexEnd >= 0) {
            while (nums2IndexEnd >= 0) {
                nums1[index--] = nums2[nums2IndexEnd--];
            }
        }
    }

    @Test
    public void main() {
        int[] nums1 = new int[]{4, 0, 0, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 3, 5, 6};
        merge(nums1, 1, nums2, 5);
        Arrays.stream(nums1).forEach(System.out::println);
    }
}
