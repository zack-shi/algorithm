package com.zack.algorithm.tree;

/**
 * https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/
 * 剑指 Offer 27. 二叉树的镜像
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
