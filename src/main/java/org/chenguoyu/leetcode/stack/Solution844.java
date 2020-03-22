package org.chenguoyu.leetcode.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 */
public class Solution844 {
    /*
    输入：S = "ab#c", T = "ad#c"
    输出：true
    解释：S 和 T 都会变成 “ac”。
    */
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = toStack(S);
        Stack<Character> stack2 = toStack(T);
        if (stack1.size() != stack2.size()) {
            return false;
        }
        while (!stack1.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;
    }

    private Stack<Character> toStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack;
    }

    @Test
    public void main() {
        System.out.println(backspaceCompare("bxj##tw", "bxj###tw"));
    }
}
