package org.chenguoyu.leetcode.string;

import org.junit.Test;

/**
 * 125.验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class Solution125 {
    /*
    输入: "A man, a plan, a canal: Panama"
    输出: true
     */
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char beginChar;
        char endChar;
        while (left < right) {
            beginChar = s.charAt(left);
            endChar = s.charAt(right);
            while (!inPattern(beginChar)) {
                ++left;
                if (left > right) {
                    break;
                }
                beginChar = s.charAt(left);
            }
            while (!inPattern(endChar)) {
                right--;
                if (left > right) {
                    break;
                }
                endChar = s.charAt(right);
            }
            if (String.valueOf(beginChar).equalsIgnoreCase(String.valueOf(endChar))) {
                ++left;
                --right;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean inPattern(Character c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

    @Test
    public void main() {
        String str = ".,";
        System.out.println(isPalindrome(str));
    }
}
