package org.chenguoyu.leetcode.array;

import org.junit.Test;

import java.util.*;

/**
 * 两数之和
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.computeIfAbsent(num, k -> new LinkedList<>());
            map.get(num).add(i);
        }
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                LinkedList<Integer> numL = map.get(nums[l]);
                Integer leftValue = numL.get(0);
                numL.removeFirst();
                return new int[]{leftValue, map.get(nums[r]).get(0)};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{-1, -1};
    }

    @Test
    public void main() {
        int[] nums = new int[]{3, 3};
        Arrays.stream(twoSum(nums, 6)).forEach(System.out::println);
    }
}
