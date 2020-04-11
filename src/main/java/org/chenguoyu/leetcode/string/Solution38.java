package org.chenguoyu.leetcode.string;

import org.junit.Test;

/**
 * 38. 外观数列
 * <p>
 * 1
 * 11
 * 21
 * 1211
 * 111221
 * <p>
 * 给一个数，这个数是1
 * 描述上一步的数，这个数是 1 即一个1，故写作11
 * 描述上一步的数，这个数是11即两个1，故写作21
 * 描述上一步的数，这个数是21即一个2一个1，故写作12-11
 * 描述上一步的数，这个数是1211即一个1一个2两个1，故写作11-12-21
 */
public class Solution38 {
    /*
       输入: 4
       输出: "1211"
       解释：当 n = 3 时，序列是 "21"，
       其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。
       所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
    */
    public String countAndSay(int n) {
        String[] strArr = new String[n];
        strArr[0] = "1";
        for (int i = 1; i < n; i++) {
            String lastStr = strArr[i - 1];
            StringBuilder sb = new StringBuilder();
            int index = 0;
            while (index < lastStr.length()) {
                int count = 0;
                char c = lastStr.charAt(index);
                while (index < lastStr.length()) {
                    if (lastStr.charAt(index) == c) {
                        count++;
                    } else {
                        break;
                    }
                    index++;
                }
                sb.append(count).append(c);
            }
            strArr[i] = sb.toString();
        }
        return strArr[n - 1];
    }


    @Test
    public void main() {
        System.out.println(countAndSay(4));
    }
}
