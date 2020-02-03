package org.chenguoyu.leetcode.trace_back;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 */
public class Solution39 {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void combinationSum(int[] candidates, int target, int index, ArrayList<Integer> integers) {
        if (sum(integers) == target) {
            result.add(new ArrayList<>(integers));
            return;
        } else if (sum(integers) > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                integers.add(candidates[i]);
                combinationSum(candidates, target, i, integers);
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
