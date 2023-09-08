package com.zack.algorithm.tree;

/**
 * 是否为平衡二叉树
 * 从底至顶
 * 后序遍历 左右根  先判断左子树 再判断右子树  最后根
 * 此方案较优
 */
public class BalancedBTIII {

    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return isBalanced(root.left)&&isBalanced(root.right)&&Math.abs(depth(root.left)-depth(root.right))<=1;
    }

    int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        return Math.max(depth(node.left),depth(node.right))+1;
    }

}
