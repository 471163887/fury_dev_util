package com.brilliant.fury;

/**
 * @author by fury.
 * version 2020/4/20.
 */
public class LinkDemo {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    /**
     * 单链表翻转.
     */
    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        if (null == head.next) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 取出下一个节点的地址，为了交换后可以继续遍历
            ListNode nextTemp = curr.next;
            // 翻转指针
            curr.next = prev;
            // 保存当前节点，实际也是最后一个节点
            prev = curr;
            // 当前指针后移
            curr = nextTemp;
        }
        return prev;
    }

}
