package org.chenguoyu.leetcode.trace_back;


import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 */
public class Solution131 {
    private List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if (s == null || "".equals(s)) {
            return result;
        }

        partition(s, 0, new ArrayList<>());

        return result;
    }


    public void partition(String s, int beginIndex, List<String> palindromeStr) {
        if (beginIndex == s.length()) {
            result.add(new ArrayList<>(palindromeStr));
            return;
        }
        for (int i = beginIndex + 1; i <= s.length(); i++) {
            String str = s.substring(beginIndex, i);
            if (isPalindrome(str)) {
                palindromeStr.add(str);
                partition(s, i, palindromeStr);
                palindromeStr.remove(palindromeStr.size() - 1);
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

}
