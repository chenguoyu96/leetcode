package org.chenguoyu.leetcode.linklist;

import org.chenguoyu.leetcode.common.ListNode;
import org.junit.Test;

/**
 * 2. 两数之和
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Solution2 {
    /*
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 是否有进位
        boolean flag = false;
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        while (l1 != null || l2 != null) {
            int value = 0;
            if (l1 != null && l2 != null) {
                value = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                value = l2.val;
                l2 = l2.next;
            } else {
                value = l1.val;
                l1 = l1.next;
            }
            if (flag) {
                value++;
                flag = false;
            }
            if (value > 9) {
                value %= 10;
                flag = true;
            }
            prev.next = new ListNode(value);
            prev = prev.next;
        }
        if (flag){
            prev.next = new ListNode(1);
        }
        return dummyHead.next;
    }

    @Test
    public void main() {
    /*    ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3)
        addTwoNumbers()*/
    }
}
