package org.chenguoyu.leetcode.dynamic_programing.optimal_substructure;

/**
 * 背包问题
 * 容量为capacity的背包 其中有重量为weight,价值为values 背包中所装的价值最大的
 */
public class backpack_1 {

    public int backpack(int[] weights, int[] values, int capacity) {
        int length = weights.length;
        // memory的行为
        int[][] memory = new int[length][capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            memory[0][i] = memory[0][i] >= weights[0] ? values[0] : 0;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= capacity; j++) {
                // 不选择 weights[i]
                int noSelect = memory[i - 1][j];
                int select = 0;

                if (j > weights[i]) {
                    select = memory[i - 1][j - weights[i]] + values[i];
                }
                memory[i][j] = Math.max(noSelect, select);
            }
        }
        return memory[length - 1][capacity];
    }
}
