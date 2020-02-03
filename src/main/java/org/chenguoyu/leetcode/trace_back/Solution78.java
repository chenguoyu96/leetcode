package org.chenguoyu.leetcode.trace_back;


import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 */
public class Solution78 {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        subsets(nums, 0, new ArrayList<Integer>());
        return result;
    }

    private void subsets(int[] nums, int index, ArrayList<Integer> integers) {
        result.add(new ArrayList<>(integers));
        if (nums.length == index) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            integers.add(nums[i]);
            subsets(nums, i + 1, integers);
            integers.remove(integers.size() - 1);
        }
    }
}
