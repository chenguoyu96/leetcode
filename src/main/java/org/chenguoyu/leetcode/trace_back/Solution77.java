package org.chenguoyu.leetcode.trace_back;


import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 */
public class Solution77 {
    private List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        if (n < k) {
            return result;
        }
        combine(n, k, 1, new ArrayList<>());
        return result;
    }

    private void combine(int n, int k, int index, ArrayList<Integer> integers) {
        if (integers.size() == k) {
            result.add(new ArrayList<>(integers));
        }
        for (int i = index; i <= n; i++) {
            integers.add(i);
            combine(n, k, i + 1, integers);
            integers.remove(integers.size() - 1);
        }
    }
}
