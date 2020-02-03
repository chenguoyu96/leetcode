package org.chenguoyu.leetcode.trace_back;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集 II
 */
public class Solution90 {
    private List<List<Integer>> result;
    private boolean[] used;


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new ArrayList<>());
        return result;
    }

    private void subsetsWithDup(int[] nums, int index, ArrayList<Integer> integers) {
        result.add(new ArrayList<>(integers));
        if (nums.length == index) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                integers.add(nums[i]);
                subsetsWithDup(nums, i + 1, integers);
                used[i] = false;
                integers.remove(integers.size() - 1);
            }
        }
    }
}
