package org.chenguoyu.leetcode.trace_back;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 */
public class Solution131 {
    private List<List<String>> result;

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return result;
        }
        result = new ArrayList<>();
        partition(s, 0, new LinkedList<>());
        return result;
    }

    private void partition(String s, int beginIndex, LinkedList<String> es) {
        if (beginIndex == s.length()) {
            result.add(new ArrayList<>(es));
            return;
        }
        for (int i = beginIndex + 1; i <= s.length(); i++) {
            String str = s.substring(beginIndex, i);
            if (isPalindrome(str)) {
                es.add(str);
                partition(s, i, es);
                es.removeLast();
            }
        }
    }

    private boolean isPalindrome(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void main() {
        partition("aab");
    }
}
