package org.chenguoyu.leetcode.trace_back;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
public class Solution22 {
    /*
    例如，给出 n = 3，生成结果为：
    [
      "((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()"
    ]
     */
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generateParenthesis(0, 0, "", n);
        return result;
    }

    private void generateParenthesis(int open, int close, String curr, int max) {
        if (curr.length() == max * 2) {
            result.add(curr);
            return;
        }
        if (open < max) {
            generateParenthesis(open+1,close,curr+"(",max);
        }
        if (close<open){
            generateParenthesis(open,close+1,curr+")",max);
        }
    }


    @Test
    public void main() {
        generateParenthesis(3).forEach(System.out::println);
    }
}
