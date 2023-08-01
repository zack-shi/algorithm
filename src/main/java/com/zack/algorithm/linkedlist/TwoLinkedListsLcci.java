package com.zack.algorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/  链表相交
 * <p>
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 */
public class TwoLinkedListsLcci {

    /**
     * set保存对比
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode sentinelA = new ListNode();
        ListNode sentinelB = new ListNode();
        sentinelA.next = headA;
        sentinelB.next = headB;
        Set<ListNode> listNodeSet = new HashSet<>();
        while (sentinelA.next != null) {
            sentinelA = sentinelA.next;
            listNodeSet.add(sentinelA);
        }
        while (sentinelB.next != null) {
            sentinelB = sentinelB.next;
            if (listNodeSet.contains(sentinelB)) {
                return sentinelB;
            }
        }
        return null;
    }

    /**
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeNew(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode sentinelA = new ListNode();
        sentinelA.next = headA;
        ListNode sentinelB = new ListNode();
        sentinelB.next = headB;
        ListNode currA = sentinelA;
        ListNode currB = sentinelB;
        while (true) {
            currA = currA.next;
            currB = currB.next;
            if (currA == null && currB == null) {
                return null;
            }
            if (currA == currB) {
                return currA;
            }
            if (currA == null) {
                currA = sentinelB;
            }
            if (currB == null) {
                currB = sentinelA;
            }
        }
    }

}
