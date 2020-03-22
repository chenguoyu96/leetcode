package org.chenguoyu.leetcode.stack;


import org.junit.Test;

import java.util.LinkedList;

/**
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 */
public class Solution1047 {
    public String removeDuplicates(String S) {
        LinkedList<Character> linkedList = new LinkedList<>();
        for (char c : S.toCharArray()) {
            if (!linkedList.isEmpty() && c == linkedList.getLast()) {
                linkedList.removeLast();
            }else {
                linkedList.add(c);
            }
        }
        char[] result = new char[linkedList.size()];
        for (int i = 0; i < linkedList.size(); i++) {
            result[i] = linkedList.get(i);
        }
        return new String(result);
    }

    @Test
    public void main() {

    }
}
