package org.chenguoyu.leetcode.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 */
public class Solution394 {
    /*
        s = "3[a]2[bc]", 返回 "aaabcbc".
        s = "3[a2[c]]", 返回 "accaccacc".
        s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
     */
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int multi = 0;
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                numStack.push(multi);
                strStack.push(result.toString());
                multi = 0;
                result.setLength(0);
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                Integer size = numStack.pop();
                for (int i = 0; i < size; i++) {
                    tmp.append(result);
                }
                result = new StringBuilder(strStack.pop() + tmp.toString());
            } else if (Character.isDigit(c))
                multi = multi * 10 + Integer.parseInt(Character.toString(c));
            else result.append(c);
        }
        return result.toString();
    }

    @Test
    public void main() {
        System.out.println(decodeString("3[a2[c]]"));
    }
}
