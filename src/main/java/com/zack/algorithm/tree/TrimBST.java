package com.zack.algorithm.tree;

public class TrimBST {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(null==root){
            return null;
        }
        if(root.val<low){
            return trimBST(root.right,low,high);
        }else if(root.val>high){
            return  trimBST(root.left,low,high);
        }else {
            root.left= trimBST(root.left,low,high);
            root.right=trimBST(root.right,low,high);
            return root;
        }
    }
}
