package com.zack.algorithm.linkedlist;

public class DeleteSinglyLinkedNode {

    public ListNode deleteNode(ListNode head, int val) {
        if(head==null){
            return head;
        }
        ListNode sentinel=new ListNode();
        sentinel.next=head;
        ListNode pre=sentinel;
        ListNode cur=head;
        while (cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
                return sentinel.next;
            }
            pre=cur;
            cur=cur.next;
        }
        return sentinel.next;
    }

}
