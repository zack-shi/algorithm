package com.zack.algorithm.tree;

public class BalancedBinaryTree {


    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int heigtDiff=height(root.left)-height(root.right);
        boolean flag= isBalanced(root.left)&&isBalanced(root.right);
        if (Math.abs(heigtDiff)<=1&&flag) {
            return true;
        }
        return false;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return Math.max(height(node.right) , height(node.left))+1;
    }


}

