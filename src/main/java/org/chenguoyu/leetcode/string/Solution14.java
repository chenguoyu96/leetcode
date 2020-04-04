package org.chenguoyu.leetcode.string;

import org.junit.Test;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""
 */
public class Solution14 {
    /*
    输入: ["flower","flow","flight"]
    输出: "fl"
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }


    @Test
    public void main() {
//        String[] strArr = new String[]{"flower", "flow", "flight"};
//        String[] strArr = new String[]{"dog","racecar","car"};
        String[] strArr = new String[]{};
        System.out.println(longestCommonPrefix(strArr));
    }
}
