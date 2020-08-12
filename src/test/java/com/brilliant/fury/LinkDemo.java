package com.brilliant.fury;

/**
 * @author by fury.
 * version 2020/4/20.
 */
public class LinkDemo {

    public class Node {
        Node next;
        int value;

        Node(Node node, int value) {
            this.next = node;
            this.value = value;
        }
    }

    /**
     * 单链表翻转.
     */
    public Node reverseList(Node head) {
        if (null == head) {
            return null;
        }
        if (null == head.next) {
            return head;
        }
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            // 1.取出下一个节点的地址，为了交换后可以继续遍历
            Node nextTemp = curr.next;
            // 2.翻转指针
            curr.next = prev;
            // 3.保存当前节点，实际也是最后一个节点
            prev = curr;
            // 4.当前指针后移
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 大数相加.
     */
    Node add(Node head, int m) {
        int jinwei = diguiAdd(head, m);
        int result = head.value + jinwei;
        if(result > 9) {
            head.value = result - 10;
            return new Node(head, 1);
        } else {
            head.value = result;
            return head;
        }
    }

    int diguiAdd(Node node, int m) {
        if(null == node.next) {
            return m + node.value;
        }
        int value = node.value + diguiAdd(node, m);
        if(value > 9) {
            node.value = value - 10;
            return 1;
        }
        node.value = value;
        return 0;
    }

}
