package org.chenguoyu.leetcode.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 636. 函数的独占时间
 * 给出一个非抢占单线程CPU的 n 个函数运行日志，找到函数的独占时间。
 * <p>
 * 每个函数都有一个唯一的 Id，从 0 到 n-1，函数可能会递归调用或者被其他函数调用。
 * <p>
 * 日志是具有以下格式的字符串：function_id：start_or_end：timestamp。例如："0:start:0" 表示函数 0 从 0 时刻开始运行。"0:end:0" 表示函数 0 在 0 时刻结束。
 * <p>
 * 函数的独占时间定义是在该方法中花费的时间，调用其他函数花费的时间不算该函数的独占时间。你需要根据函数的 Id 有序地返回每个函数的独占时间。
 */
public class Solution636 {
    /*
    输入:
    n = 2
    logs =
    ["0:start:0",
     "1:start:2",
     "1:end:5",
     "0:end:6"]
    输出:[3, 4]
    说明：
    函数 0 在时刻 0 开始，在执行了  2个时间单位结束于时刻 1。
    现在函数 0 调用函数 1，函数 1 在时刻 2 开始，执行 4 个时间单位后结束于时刻 5。
    函数 0 再次在时刻 6 开始执行，并在时刻 6 结束运行，从而执行了 1 个时间单位。
    所以函数 0 总共的执行了 2 +1 =3 个时间单位，函数 1 总共执行了 4 个时间单位。
    */


    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<String> stack = new Stack<>();
        int lastEnd = 0;
        boolean lastIsEnd = false;
        for (String log : logs) {
            if (stack.isEmpty()) {
                stack.push(log);
            } else {
                String[] logArr = log.split(":");
                String[] peekArr = stack.peek().split(":");
                if (logArr[1].equals("start")) {
                    if (lastIsEnd) {
                        result[Integer.parseInt(peekArr[0])] += Integer.parseInt(logArr[2]) - lastEnd - 1;
                    } else {
                        result[Integer.parseInt(peekArr[0])] += Integer.parseInt(logArr[2]) - Integer.parseInt(peekArr[2]);
                    }
                    stack.push(log);
                    lastIsEnd = false;
                } else {
                    if (lastIsEnd) {
                        result[Integer.parseInt(logArr[0])] += Integer.parseInt(logArr[2]) - lastEnd;
                    } else {
                        result[Integer.parseInt(logArr[0])] += Integer.parseInt(logArr[2]) - Integer.parseInt(peekArr[2]) + 1;
                    }
                    lastEnd = Integer.parseInt(logArr[2]);
                    stack.pop();
                    lastIsEnd = true;
                }
            }
        }
        return result;
    }


    @Test
    public void main() {
        List<String> logs = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8");
        Arrays.stream(exclusiveTime(2, logs)).forEach(item -> System.out.print(item + " "));
        System.out.println();
    }
}
