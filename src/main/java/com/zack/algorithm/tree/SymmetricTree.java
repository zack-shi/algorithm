package com.zack.algorithm.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class SymmetricTree {

    /**
     * 中序遍历 再看数组是否对称
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left,root.right);
    }


    /**
     * 深度遍历 递归
     * @param left
     * @param right
     * @return
     */
    public boolean isMirror(TreeNode left,TreeNode right){
        if(null==left&&null==right){
            return true;
        }
        if(null==left||null==right){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return isMirror(left.left,right.right)&&isMirror(left.right,right.left);
    }


    /**
     * 广度遍历 迭代
     * @return
     */
    public boolean isSymme(TreeNode root){
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root.left);
        q.offer(root.right);
        while (!q.isEmpty()){
            TreeNode LN= q.poll();
            TreeNode RN= q.poll();
            if(null==LN&&null==RN){
                continue;
            }
            if(null==LN||null==RN){
                return false;
            }
            if(LN.val!=RN.val){
                return false;
            }
            q.offer(LN.left);
            q.offer(RN.right);
            q.offer(LN.right);
            q.offer(RN.left);
        }
        return true;
    }


}
