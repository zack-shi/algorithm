package com.zack.algorithm.linkedlist;

/**
 * https://leetcode.cn/problems/reverse-linked-list/ 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class ReverseLinkedList {


    /**
     * 双指针
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode curr=head;
        ListNode next;
        while (curr!=null){
            next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return curr;
    }


    /**
     * 递归写法
     * @param head
     * @return
     */
    public ListNode reverseListNew(ListNode head) {
       ListNode node=reverse(null,head);
       return node;
    }

    public ListNode reverse(ListNode pre,ListNode curr){
        if(curr==null){
            return pre;
        }
        ListNode next=curr.next;
        curr.next=pre;
        return reverse(curr,next);
    }


}
