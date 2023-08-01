package com.zack.algorithm.linkedlist;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = node1;
        ListNode newNode = removeNthFromEnd2(head, 1);

        while (newNode != null) {
            System.out.print(newNode.val + ",");
            newNode = newNode.next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode sentinelNode = new ListNode();
        sentinelNode.next = head;
        ListNode cur = sentinelNode;
        int size = 0;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        if (n > size) {
            return head;
        }
        int index = size - n;
        ListNode pre = sentinelNode;
        cur = sentinelNode.next;
        for (int i = 0; i < index; i++) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return sentinelNode.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if(head.next==null&&n!=1){
            return null;
        }
        ListNode sentinel=new ListNode(0);
        sentinel.next=head;
        ListNode currj= sentinel;
        for(int j=0;j<n;j++){
            currj=currj.next;
            if(currj==null){
                return null;
            }
        }
        ListNode curri=sentinel;
        while (currj.next!=null){
            currj=currj.next;
            curri=curri.next;
        }
        curri.next=curri.next.next;
        return sentinel.next;
    }

}
