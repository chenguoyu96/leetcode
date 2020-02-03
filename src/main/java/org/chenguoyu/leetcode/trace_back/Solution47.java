package org.chenguoyu.leetcode.trace_back;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列 II
 */
public class Solution47 {
    private List<List<Integer>> result;
    // 辅助数据结构 表示第i个元素是否被使用
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        permuteUnique(nums, 0, new ArrayList<>());
        return result;
    }

    private void permuteUnique(int[] nums, int index, ArrayList<Integer> integers) {
        if (integers.size() == nums.length) {
            result.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                integers.add(nums[i]);
                used[i] = true;
                permuteUnique(nums, index + 1, integers);
                used[i] = false;
                integers.remove(integers.size() - 1);
            }
        }
    }
}
