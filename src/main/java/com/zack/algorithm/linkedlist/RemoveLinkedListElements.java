package com.zack.algorithm.linkedlist;

/**
 * https://leetcode.cn/problems/remove-linked-list-elements/
 * 移除链表元素
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode virtualHead=new ListNode();
        virtualHead.next=head;
        ListNode curr=virtualHead;
        while(curr!=null&&curr.next!=null){
            if(curr.next.val==val){
                curr.next=curr.next.next;
            }else{
                curr=curr.next;
            }
        }
        return virtualHead.next;
    }


}
