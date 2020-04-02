package org.chenguoyu.leetcode.common;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while (curr != null) {
            sb.append(curr.val).append("->");
            curr = curr.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
