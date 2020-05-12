package org.chenguoyu.leetcode.array;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Solution119 {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return Arrays.asList(1);
        if (rowIndex == 1) return Arrays.asList(1, 1);
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        result.add(1);
        result.add(1);
        for (int i = 2; i <= rowIndex; i++) {
            result.add(1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }

    @Test
    public void main() {
        List<Integer> result = getRow(5);
        System.out.println(JSONObject.toJSON(result));
    }
}
