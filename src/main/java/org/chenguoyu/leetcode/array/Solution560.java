package org.chenguoyu.leetcode.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 */
public class Solution560 {
    /*
      输入:nums = [1,1,1], k = 2
      输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
    */
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            int value = pre - k;
            if (map.containsKey(value)) {
                result += map.get(value);
            }
            if (map.containsKey(pre)) {
                map.put(pre, map.get(pre) + 1);
            } else {
                map.put(pre, 1);
            }
        }
        return result;
    }

    @Test
    public void main() {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));

//        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));

//        System.out.println(subarraySum(new int[]{1, 2, 1, 2, 1}, 3));

    }
}
