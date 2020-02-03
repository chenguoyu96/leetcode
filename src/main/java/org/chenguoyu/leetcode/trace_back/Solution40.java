package org.chenguoyu.leetcode.trace_back;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II
 */
public class Solution40 {
    private List<List<Integer>> result;
    private boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        combinationSum2(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void combinationSum2(int[] candidates, int target, int index, ArrayList<Integer> integers) {
        if (sum(integers) == target) {
            result.add(new ArrayList<>(integers));
            return;
        } else if (sum(integers) > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                if (i > 0 && !used[i - 1] && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                integers.add(candidates[i]);
                used[i] = true;
                combinationSum2(candidates, target, i + 1, integers);
                used[i] = false;
                integers.remove(integers.size() - 1);

            }
        }
    }

    private Integer sum(List<Integer> integers) {
        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
        }
        return sum;
    }
}
