package com.zack.algorithm.linkedlist;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class GetIntersectionNode {


    ListNode getIntersectionNodeSimple(ListNode headA, ListNode headB){
        ListNode startA = headA;
        ListNode startB = headB;
        while (headA!=headB){
            if(headA!=null){
                headA=headA.next;
            }else {
                headA=startB;
            }
            if(headB!=null){
                headB=headB.next;
            }else {
                headB=startA;
            }
        }
        return headA;
    }


    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode startA = headA;
        ListNode startB = headB;
        //分别从A,B起点开始跑
        while (headA != null && headB != null) {
            if(headA==headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;

        }
        //A先跑到终点，A指向B的起点继续跑
        if (headA == null && headB != null) {
            headA = startB;
            while (headB!=null) {
                if(headA==headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            //B也跑到了终点 指向A的起点继续跑
            headB=startA;
            while (headA!=null){
                if(headB==headA){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;

            }
        }
        //相反的情况，逻辑同上
        if (headB == null && headA != null) {
            headB = startA;
            while (headA!=null) {
                if(headB==headA){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            headA=startB;
            while (headB!=null){
                if(headB==headA){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
