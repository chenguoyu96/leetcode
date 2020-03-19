package org.chenguoyu.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 合并两个有序数组
 */
public class Solution88_1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = nums1[i];
        }
        int numsIndex = 0, nums2Index = 0, i = 0;
        while (numsIndex < m && nums2Index < n) {
            if (nums[numsIndex] < nums2[nums2Index]) {
                nums1[i++] = nums[numsIndex++];
            } else {
                nums1[i++] = nums2[nums2Index++];
            }
        }
        if (numsIndex < m) {
            while (numsIndex < m) {
                nums1[i++] = nums[numsIndex++];
            }
        } else {
            while (nums2Index < n) {
                nums1[i++] = nums2[nums2Index++];
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
