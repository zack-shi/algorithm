package com.zack.algorithm.linkedlist;

/**
 * 设计双向链表
 */
public class MyDoubleLinkedList {

    int size;
    ListNode head;
    ListNode tail;

    public MyDoubleLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.succ = tail;
        tail.prev = head;
        size = 0;
    }


    /**
     * 获取链表中第 index个节点的值。如果索引无效，则返回-1
     *
     * @param index
     * @return
     */
    public int get(int index) {
        //index 索引无效 返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode indexNode = getIndexNode(index);
        return indexNode.val;
    }

    /**
     * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     *
     * @param val
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * 将值为 val 的节点追加到链表的最后一个元素。
     *
     * @param val
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * 在链表中的第index个节点之前添加值为 val的节点。如果 index 等于链
     * 表的长度，则该节点将附加到链表的末尾。如果 index大于链表长度，则不会插入节点。如果index
     * 小于0，则在头部插入节点。
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        ListNode addNode = new ListNode(val);
        index=Math.max(0,index);
        ListNode indexNode = getIndexNode(index);
        indexNode.prev.succ = addNode;
        addNode.prev = indexNode.prev;

        addNode.succ = indexNode;
        indexNode.prev = addNode;
        size++;
    }


    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点
     *
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode indexNode = getIndexNode(index);
        indexNode.prev.succ=indexNode.succ;
        indexNode.succ.prev=indexNode.prev;
        size--;
    }

    ListNode getIndexNode(int index) {
        if (size-index> index) {
            ListNode indexNode = head;
            for (int i = 0; i <= index; i++) {
                indexNode = indexNode.succ;
            }
            return indexNode;
        } else {
            ListNode indexNode = tail;
            for (int i = size - 1; i >= index; i--) {
                indexNode = indexNode.prev;
            }
            return indexNode;
        }
    }

    public class ListNode {
        int val;
        ListNode prev;
        ListNode succ;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        MyDoubleLinkedList linkedList = new MyDoubleLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
    }
}
