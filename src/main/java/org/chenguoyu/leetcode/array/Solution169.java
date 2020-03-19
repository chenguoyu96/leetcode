package org.chenguoyu.leetcode.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        if (nums.length==0){
            return -1;
        }
        if (nums.length==1){
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length / 2;
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                count++;
                if (count > n) {
                    return num;
                }
                map.put(num, count);
            }
        }
        return -1;
    }

    @Test
    public void main() {
        int[] nums = new int[]{3, 3};
        System.out.println(majorityElement(nums));
    }
}
