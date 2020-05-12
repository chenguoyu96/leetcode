package org.chenguoyu.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        result.add(Arrays.asList(1));
        if (numRows == 1) {
            return result;
        }
        for (int i = 2; i <= numRows; i++) {
            List<Integer> level = new ArrayList<>(numRows);
            level.add(1);
            for (int j = 1; j < i - 1; j++) {
                List<Integer> lastLevel = result.get(i - 2);
                level.add(lastLevel.get(j - 1) + lastLevel.get(j));
            }
            level.add(1);
            result.add(level);
        }
        return result;
    }

    @Test
    public void main() {
        List<List<Integer>> generate = generate(5);
        for (List<Integer> integers : generate) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
