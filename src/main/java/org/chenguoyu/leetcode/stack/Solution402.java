package org.chenguoyu.leetcode.stack;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 */
public class Solution402 {
    /*
    输入: num = "1432219", k = 3
    输出: "1219"
    解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
    */
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        LinkedList<Character> characters = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && characters.size() > 0 && num.charAt(i) < characters.getLast()) {
                characters.removeLast();
                k--;
            }
            if (k < num.length() - i) {
                characters.addLast(num.charAt(i));
            } else {
                k--;
            }
        }
        StringBuilder result = new StringBuilder();
        boolean isHeadZero = true;
        for (Character character : characters) {
            if (character == '0' && isHeadZero) {
                continue;
            } else {
                result.append(character);
                isHeadZero = false;
            }
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    @Test
    public void main() {
        System.out.println(removeKdigits("112", 1));
    }
}
