package org.chenguoyu.leetcode.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 */
public class Solution139_1 {
    Boolean[] memory;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || "".equals(s)) {
            return false;
        }
        memory = new Boolean[s.length()];
        return wordBreak(s, 0, new HashSet<>(wordDict));
    }

    private boolean wordBreak(String s, int beginIndex, HashSet<String> wordDict) {
        if (s.length() == beginIndex) {
            return true;
        }
        if (memory[beginIndex] != null) {
            return memory[beginIndex];
        }
        memory[beginIndex] = false;
        for (int i = beginIndex + 1; i <= s.length(); i++) {
            String str = s.substring(beginIndex, i);
            if (wordDict.contains(str) && wordBreak(s, i, wordDict)) {
                memory[beginIndex] = true;
                break;
            }
        }
        return memory[beginIndex];
    }

    @Test
    public void main() {
        String str = "leetcode";
        System.out.println(wordBreak(str, Arrays.asList("leet","code")));
    }
}
