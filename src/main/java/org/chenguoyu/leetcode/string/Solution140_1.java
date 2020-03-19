package org.chenguoyu.leetcode.string;

import org.junit.Test;

import java.util.*;

/**
 * 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 */
public class Solution140_1 {
    Map<Integer, List<String>> memory;

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || "".equals(s)) {
            return null;
        }
        memory = new HashMap<>();
        return wordBreak(s, 0, new HashSet<>(wordDict));
    }

    private List<String> wordBreak(String s, int beginIndex, HashSet<String> wordDict) {
        if (memory.containsKey(beginIndex)) {
            return memory.get(beginIndex);
        }
        LinkedList<String> res = new LinkedList<>();
        if (s.length() == beginIndex) {
            res.add("");
            return res;
        }
        for (int i = beginIndex + 1; i <= s.length(); i++) {
            String str = s.substring(beginIndex, i);
            if (wordDict.contains(str)) {
                List<String> strings = wordBreak(s, i, wordDict);
                for (String string : strings) {
                    res.add(str + ("".equals(string) ? "" : " " + string));
                }
            }
        }
        memory.put(beginIndex, res);
        return res;
    }

    @Test
    public void main() {
        String str = "pineapplepenapple";
        System.out.println(wordBreak(str, Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
    }
}
