package org.chenguoyu.leetcode.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            int t = T[i];
            while (!stack.isEmpty() && t >= stack.peek()) {
                stack.pop();
                indexStack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = indexStack.peek() - i;
            }
            stack.push(t);
            indexStack.push(i);
        }
        return result;
    }

    @Test
    public void main() {
//        int[] nums = new int[]{73, 74, 75, 71, 69, 72, 76, 73}; //1, 1, 4, 2, 1, 1, 0, 0
        int[] nums = new int[]{89,62,70,58,47,47,46,76,100,70}; //8,1,5,4,3,2,1,1,0,0
        Arrays.stream(dailyTemperatures(nums)).forEach(item -> System.out.print(item + " "));
        System.out.println();
    }
}
