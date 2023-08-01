package com.zack.algorithm.linkedlist;

/**
 * 设计单向链表
 */
public class MySingleLinkedList {

    int val;
    MySingleLinkedList next;

    MySingleLinkedList head;

    public static void main(String[] args) {
        int max=Math.max(0, 10);
        System.out.println(max);
    }

    public MySingleLinkedList() {
        head = null;
        next = null;
    }

    /**
     * 获取链表中第 index 个节点的值。如果索引无效，则返回-1
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (head == null) {
            return -1;
        }
        if(index<0){
            return -1;
        }
        int start = 0;
        MySingleLinkedList cur = head;
        while (cur != null) {
            if (start == index) {
                return cur.val;
            }
            start++;
            cur = cur.next;
        }
        if (cur == null) {
            return -1;
        }
        return cur.val;
    }

    /**
     * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     *
     * @param val
     */
    public void addAtHead(int val) {
        MySingleLinkedList newHeadNode = new MySingleLinkedList();
        newHeadNode.val = val;
        //空链表插入
        if (head == null) {
            head = newHeadNode;
            return;
        }
        //大于等于一个节点时插入
        newHeadNode.next = head;
        head = newHeadNode;
    }

    /**
     * 将值为 val 的节点追加到链表的最后一个元素。
     *
     * @param val
     */
    public void addAtTail(int val) {
        MySingleLinkedList tailNode = new MySingleLinkedList();
        tailNode.val = val;
        tailNode.next = null;
        if (head == null) {
            head = tailNode;
            return;
        }
        MySingleLinkedList cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = tailNode;
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
        //空链表
        if (head == null) {
            if (index <= 0) {
                addAtHead(val);
                return;
            }
            return;
        }
        //只有一个头节点
        if (head.next == null) {
            if (index <= 0) {
                addAtHead(val);
                return;
            }
        }
        //两个节点以上
        if (index <= 0) {
            addAtHead(val);
            return;
        } else {
            MySingleLinkedList indexNode = new MySingleLinkedList();
            indexNode.val = val;
            int start = 0;
            MySingleLinkedList cur = head;
            while (cur != null) {
                if (start == index - 1) {
                    MySingleLinkedList next = cur.next;
                    cur.next = indexNode;
                    indexNode.next = next;
                    break;
                }
                start++;
                cur = cur.next;
            }
        }
    }

    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点
     *
     * @param index
     */
    public void deleteAtIndex(int index) {
        //空链表
        if (head == null) {
            return;
        }
        //只有一个节点
        if (head.next == null) {
            if (index == 0) {
                head = null;
            }
            return;
        }

        //删除头节点
        if (index == 0) {
            head = head.next;
        }

        //删除其他节点
        MySingleLinkedList cur = head;
        int start = 0;
        while (cur != null&&cur.next!=null) {
            if (start+1 == index) {
                cur.next = cur.next.next;
                break;
            }
            start++;
            cur = cur.next;
        }
    }

}


/**
 * Your MySingleLinkedList object will be instantiated and called as such:
 * MySingleLinkedList obj = new MySingleLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */