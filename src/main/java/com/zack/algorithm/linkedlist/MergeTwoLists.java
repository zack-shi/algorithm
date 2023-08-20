package com.zack.algorithm.linkedlist;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/description/
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode l=new ListNode();
        ListNode head=l;
        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                l.next=l1;
                l1=l1.next;
                l=l.next;
            }else {
                l.next=l2;
                l2=l2.next;
                l=l.next;
            }
        }
        if(l1==null){
            l.next=l2;
        }
        if(l2==null){
            l.next=l1;
        }
        return head.next;
    }

}
