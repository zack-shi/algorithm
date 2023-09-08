package com.zack.algorithm.tree;

/**
 * 剑指offer 二叉查找树的第 K 个结点
 * 1、dfs，反中序遍历
 * 2、右根左的顺序dfs，计数=k时，说明找到了第k大的节点
 */
public class KthBSTNode {

    int count = 0; //计数
    int k;
    TreeNode p=null;

    public int kthLargest(TreeNode root, int k) {
        this.k=k;
        rightOrder(root);
        return p.val;
    }

    void rightOrder(TreeNode node){
        if(node==null){
            return;
        }
        if(count==k){
            return;
        }
        rightOrder(node.right);
        count++;
        if(count==k){
            p=node;
            return;
        }
        rightOrder(node.left);
    }


}
