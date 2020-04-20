package org.chenguoyu.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
public class Solution56 {
    /*
    输入: [[1,3],[2,6],[8,10],[15,18]]
    输出: [[1,6],[8,10],[15,18]]
    解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    * */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int index = 0;
        int begin = intervals[0][0];
        int end = intervals[index][1];
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (end < intervals[i][0]) {
                result.add(new int[]{begin, end});
                begin = intervals[i][0];
            }
            end = Math.max(end, intervals[i][1]);
        }
        result.add(new int[]{begin, end});
        int[][] r = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    @Test
    public void main() {
//        int[][] nums = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] nums = new int[][]{{1, 4}, {4, 5}};
//        int[][] nums = new int[][]{{1, 4}, {2, 3}};
        int[][] nums = new int[][]{{3,3},{0,1},{0,0}};
        merge(nums);
    }
}
