package com.zack.algorithm.tree;

public class MinDepthOfTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }else if(root.right==null&&root.left==null){
            return 0;
        }else if(root.right!=null&&root.left!=null){
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
        }else if(root.left==null){
            return minDepth(root.right);
        }else{
            return minDepth(root.left);
        }
    }

}
