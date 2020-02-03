package org.chenguoyu.leetcode.trace_back;


import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和 III
 */
public class Solution216 {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        if (k <= 0) {
            return result;
        }
        combinationSum3(k, n, 1, new ArrayList<>());
        return result;
    }

    private void combinationSum3(int k, int n, int index, ArrayList<Integer> integers) {
        if (integers.size() == k && sum(integers) == n) {
            result.add(new ArrayList<>(integers));
            return;
        }
        if (integers.size() > k || sum(integers) > n) {
            return;
        }
        for (int i = index; i <= 9; i++) {
            integers.add(i);
            combinationSum3(k, n, i + 1, integers);
            integers.remove(integers.size() - 1);
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
