package com.zack.algorithm.tree;

/**
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class BST2DoublyList {

    Node pre=null;

    Node head=null;
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        inOrder(root);
        head.left=pre;
        pre.right=head;
        return head;
    }

   void inOrder(Node node){
        if(node==null){
            return;
        }
       inOrder(node.left);
        node.left=pre;
        if(pre!=null){
            pre.right=node;
        }else {
            head=node; // 为什么不是head=root,因为二叉搜索树啊，排序是左中右，那么遍历到的第一个节点 就是head
        }
        pre=node;
       inOrder(node.right);
    }


    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

}
