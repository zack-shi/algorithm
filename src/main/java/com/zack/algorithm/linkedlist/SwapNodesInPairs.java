package com.zack.algorithm.linkedlist;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 *  两两交换链表中的节点
 *  给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode oodNode=head;
        ListNode evenNode=head.next;
        ListNode temp=evenNode.next;
        evenNode.next=oodNode;
        oodNode.next=swapPairsNew(temp);
        return evenNode;
    }

    void swapPair(ListNode oodNode,ListNode evenNode){
        // 下一个奇数节点不存在
        if(evenNode.next==null){
            evenNode.next=oodNode;
            oodNode.next=null;
            return;
        }
        //下一个节点存在 但仅剩这一个节点
        if(evenNode.next!=null&&evenNode.next.next==null){
            ListNode nextOod= evenNode.next;  //保存下一个奇数指针；
            evenNode.next=oodNode;
            oodNode.next=nextOod;
            return;
        }
        //下一个节点存在  且同时存在下一个偶数节点
        if(evenNode.next!=null&&evenNode.next.next!=null){
            ListNode nextOod= evenNode.next;  //保存下一个奇数指针；
            ListNode nextEven= evenNode.next.next;  //保存下一个偶数指针；
            evenNode.next=oodNode;
            oodNode.next=nextEven;
            swapPair(nextOod,nextEven);
            return;
        }
    }

    ListNode swapPairsNew(ListNode node){
        //下一节点为空
        if(node==null){
            return null;
        }
        //仅有下一节点
        if(node.next==null){
            return node;
        }
        //有两个节点
        ListNode nextNode=node.next;
        node.next.next=node;
        node.next=swapPairsNew(nextNode.next);
        return nextNode;
    }

}
