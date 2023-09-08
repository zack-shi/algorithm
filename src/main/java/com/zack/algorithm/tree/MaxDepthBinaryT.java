package com.zack.algorithm.tree;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/
 */
public class MaxDepthBinaryT {

    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
