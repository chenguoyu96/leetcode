package org.chenguoyu.leetcode.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 856. 括号的分数
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 */
public class Solution856 {
    /*
        输入： "(()(()))"
        输出： 6
     */
    public int scoreOfParentheses(String S) {
        Stack<Integer> result = new Stack<>();
        result.push(0);
        for (char c : S.toCharArray()) {
            if (c == '(') {
                result.push(0);
            } else {
                Integer v = result.pop();
                Integer w = result.pop();
                result.push(w + Math.max(v * 2, 1));
            }
        }
        return result.peek();
    }

    @Test
    public void main() {
        System.out.println(scoreOfParentheses("(()(()))"));
    }
}
