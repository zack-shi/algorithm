package com.zack.algorithm.linkedlist;

import java.util.HashMap;

public class CopyRandomList {

    /**
     * 思路
     * 1、复制节点作为原节点的next，复制节点的next指向原节点的next 如 x->x'->y->y'
     * 2、设置x'节点的random节点，同理为原节点的random节点的next节点
     * 3、最后把复制节点和原来节点拆分
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        //第一步 复制节点作为原节点的next
        Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        //第二步 设置random节点
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        //第三步 拆分
        Node dummy = new Node(-1);
        p = head;
        Node cur = dummy;
        while (p != null) {
            cur=cur.next.next;
            p.next=cur.next;
            p=p.next;
        }
        return dummy.next;
    }

    /**
     * hash 解法 非常强
     * @return
     */
    public Node copyRandomListHash(Node head){
        HashMap<Node,Node> map=new HashMap<>();
        Node p=head;
        while(p !=null){
            map.put(p,new Node(p.val));
            p=p.next;
        }
        p=head;
        while(p!=null) {
            Node newNode=map.get(p);
            if(p.next!=null){
                newNode.next=map.get(p.next);
            }
            if(p.random!=null){
                newNode.random=map.get(p.random);
            }
            p = p.next;
        }
        return map.get(head);
    }



    public static void main(String[] args) {
        Node node1 = new Node(1);

        Node node2 = new Node(2);

        Node node3 = new Node(3);

        node1.next = node2;
        node1.random = node3;
        node2.next = node3;
        node3.random = node1;
        Node newHead = new CopyRandomList().copyRandomList(node1);
        while (newHead != null) {
            System.out.println("val=" + newHead.val + ",random.val=" + newHead.random.val);
            newHead = newHead.next;
        }

    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
