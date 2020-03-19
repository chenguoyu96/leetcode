package org.chenguoyu.leetcode.dynamic_programing.optimal_substructure;


import org.junit.Test;

/**
 * 337 打家劫舍 III
 * 记忆化搜索 超时
 */
public class Solution309_1 {
    private int[] memory;
    private int length;

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        length = prices.length;
        if (prices.length == 2) {
            return Math.max(prices[1] - prices[0], 0);
        }
        memory = new int[length];
        maxProfit(prices, 0);
        return memory[0];
    }

    private int maxProfit(int[] prices, int index) {
        if (index == length - 2) {
            return Math.max(prices[length - 1] - prices[length - 2], 0);
        }
        if (memory[index] != 0) {
            return memory[index];
        }
        int profit = 0;
        for (int buyIndex = index; buyIndex < length - 1; buyIndex++) {
            for (int sellIndex = buyIndex + 1; sellIndex < length; sellIndex++) {
                if (prices[sellIndex] <= prices[buyIndex]) {
                    continue;
                }
                profit = Math.max(profit, prices[sellIndex] - prices[buyIndex] + (sellIndex + 2 < length ? maxProfit(prices, sellIndex + 2) : 0));
            }
        }
        memory[index] = profit;
        return profit;
    }


    @Test
    public void main() {
        int[] nums = new int[]{1, 2, 2};
        System.out.println(maxProfit(nums));


    }
}
