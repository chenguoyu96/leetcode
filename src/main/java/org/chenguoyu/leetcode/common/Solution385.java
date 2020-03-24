package org.chenguoyu.leetcode.common;

import org.chenguoyu.leetcode.common.NestedInteger;
import org.junit.Test;

import java.util.Stack;

/**
 * 385. 迷你语法分析器
 * 给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。
 * <p>
 * 列表中的每个元素只可能是整数或整数嵌套列表
 * <p>
 * 提示：你可以假定这些字符串都是格式良好的：
 * <p>
 * 字符串非空
 * 字符串不包含空格
 * 字符串只包含数字0-9, [, - ,, ]
 * <p>
 */
public class Solution385 {
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) {
            return new NestedInteger(Integer.parseInt(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        boolean flag = true, isDigit = false;
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + Integer.parseInt(Character.toString(c));
                isDigit = true;
            } else if (c == '-') {
                flag = false;
            } else if (c == '[') {
                stack.push(new NestedInteger());
            } else if (c == ',' || c == ']') {
                if (isDigit) {
                    stack.peek().add(new NestedInteger(flag ? num : -num));
                }
                flag = true;
                isDigit = false;
                num = 0;
                if (c == ']' && stack.size() > 1) {
                    NestedInteger pop = stack.pop();
                    stack.peek().add(pop);
                }
            }
        }
        return stack.pop();
    }


    @Test
    public void main() {
        System.out.println(deserialize("[123,[456,[789]]]"));
    }
}
