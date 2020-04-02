package org.chenguoyu.leetcode.stack;

import org.junit.Test;

/**
 * 880. 索引处的解码字符串
 * 给定一个编码字符串 S。为了找出解码字符串并将其写入磁带，从编码字符串中每次读取一个字符，并采取以下步骤：
 * <p>
 * 如果所读的字符是字母，则将该字母写在磁带上。
 * 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
 * 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
 */
public class Solution880_2 {
    /*
    输入：S = "leet2code3", K = 10
    输出："o"
    解释：
    解码后的字符串为 "leetleetcodeleetleetcodeleetleetcode"。
    字符串中的第 10 个字母是 "o"。
    * */
    public String decodeAtIndex(String S, int K) {
        if (K == 1) {
            return Character.toString(S.charAt(0));
        }
        long size = 0;
        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }
        int length = S.length();
        for (int i = length - 1; i >= 0; i--) {
            char c = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(c)) {
                return Character.toString(c);
            }
            if (Character.isDigit(c)) {
                size /= c - '0';
            } else {
                size--;
            }
        }
        return "";
    }

    @Test
    public void main() {
        System.out.println(decodeAtIndex("leet2code3", 10));
//        System.out.println(decodeAtIndex("yyuele72uthzyoeut7oyku2yqmghy5luy9qguc28ukav7an6a2bvizhph35t86qicv4gyeo6av7gerovv5lnw47954bsv2xruaej", 123365626));
//        System.out.println(decodeAtIndex("a2345678999999999999999999999999999999999999999999999999999999999999", 1));
//        System.out.println(decodeAtIndex("y959q969u3hb22odq595", 222280369));
    }
}
