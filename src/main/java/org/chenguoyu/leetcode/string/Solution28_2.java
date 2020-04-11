package org.chenguoyu.leetcode.string;

import org.junit.Test;

/**
 * 28 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class Solution28_2 {
    /*
    输入: haystack = "hello", needle = "ll"
    输出: 2
    KMP算法
    */
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if ("".equals(haystack) && "".equals(needle)) {
            return 0;
        }
        int[] next = getNext(needle);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j - 1];
                }
            }
        }
        if (j == needle.length()) {
            return i - j;
        }
        return -1;
    }

    public int[] getNext(String needle) {
        int length = needle.length();
        int[] next = new int[length];
        int index = 0;
        for (int i = 1; i < length; ) {
            if (needle.charAt(index) == needle.charAt(i)) {
                next[i] = index + 1;
                index++;
                i++;
            } else {
                if (index == 0) {
                    next[i] = 0;
                    i++;
                } else {
                    index = next[index - 1];
                }
            }
        }
        return next;
    }


    @Test
    public void main() {
//        System.out.println(strStr("hello", "ll"));
//        System.out.println(strStr("aaaaa", "bba"));
//        System.out.println(strStr("", ""));
//        System.out.println(strStr("mississippi", "mississippi"));
        System.out.println(strStr("mississippi", "issipi"));
    }
}
