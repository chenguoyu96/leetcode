package org.chenguoyu.leetcode.stack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1
 */
public class Solution496_2 {
    /*
    输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
    输出: [-1,3,-1]
    解释:
        对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
        对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
        对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            if (stack.isEmpty()) {
                stack.push(num);
            } else {
                while (!stack.isEmpty() && num > stack.peek()) {
                    map.put(stack.pop(), num);
                }
                stack.push(num);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            Integer integer = map.get(nums1[i]);
            if (integer != null) {
                result[i] = integer;
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    @Test
    public void main() {
        int[] nums1 = new int[]{1, 3, 5, 2, 4};
        int[] nums2 = new int[]{6, 5, 4, 3, 2, 1, 7};
        nextGreaterElement(nums1, nums2);
    }
}
