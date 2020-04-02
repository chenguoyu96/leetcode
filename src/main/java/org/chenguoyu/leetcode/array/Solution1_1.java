package org.chenguoyu.leetcode.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 */
public class Solution1_1 {
    public int[] twoSum(int[] nums, int target) {
        // key是数组的值 value是数组的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            if (map.containsKey(target - num)) {
                return new int[]{map.get(target - num), i};
            }
            map.put(num, i);
        }
        return new int[]{-1, -1};
    }

    @Test
    public void main() {
        int[] nums = new int[]{3, 3};
        Arrays.stream(twoSum(nums, 6)).forEach(System.out::println);
    }
}
