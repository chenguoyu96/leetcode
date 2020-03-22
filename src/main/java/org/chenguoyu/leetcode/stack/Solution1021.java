package org.chenguoyu.leetcode.stack;


import org.junit.Test;

import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 */
public class Solution1021 {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                if (stack.size() > 1) {
                    sb.append(c);
                }
            } else {
                stack.pop();
                if (stack.size() > 0) {
                    sb.append(c);
                }
            }

        }
        return sb.toString();
    }

    @Test
    public void main() {
        System.out.println(removeOuterParentheses(
                "(()())(())"));
    }
}
