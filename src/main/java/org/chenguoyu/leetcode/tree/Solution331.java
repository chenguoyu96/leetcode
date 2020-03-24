package org.chenguoyu.leetcode.tree;


import org.junit.Test;

/**
 * 子集 II
 */
public class Solution331 {

    public boolean isValidSerialization(String preorder) {
        int slots = 1;
        for (String c : preorder.split(",")) {
            slots--;
            if (slots<0){
                return false;
            }
            if (!"#".equals(c)) {
                slots += 2;
            }
        }
        return slots == 0;
    }

    @Test
    public void main() {
        System.out.println(isValidSerialization("#,#,3,5,#"));
    }
}
