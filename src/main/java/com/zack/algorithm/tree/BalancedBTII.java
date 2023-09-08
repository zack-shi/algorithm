package com.zack.algorithm.tree;

/**
 * 是否为平衡二叉树
 * 从顶至底
 * 先序遍历 根左右  先从根节点判断是否为平衡 再判断左子树 再判断右子树
 * 需要多次遍历，时间复杂度高
 */
public class BalancedBTII {

    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(Math.abs(depth(root.left)-depth(root.right))<=1){
            return isBalanced(root.left)&&isBalanced(root.right);
        }else {
            return false;
        }
    }

    int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        return Math.max(depth(node.left),depth(node.right))+1;
    }


}
