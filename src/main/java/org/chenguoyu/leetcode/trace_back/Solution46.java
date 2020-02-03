package org.chenguoyu.leetcode.trace_back;


import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class Solution46 {
    private List<List<Integer>> result;
    // 辅助数据结构 表示第i个元素是否被使用
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];
        permute(nums, 0, new ArrayList<>());
        return result;
    }

    private void permute(int[] nums, int index, List<Integer> integers) {
        if (nums.length == integers.size()) {
            result.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                integers.add(nums[i]);
                used[i] = true;
                permute(nums, index + 1, integers);
                used[i] = false;
                integers.remove(integers.size() - 1);
            }
        }
    }
}
