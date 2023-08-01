package com.zack.algorithm.tree;

public class InsertBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        TreeNode currNode=root;
        while (currNode!=null){
            if(currNode.val>val){
                if(currNode.left==null){
                    currNode.left=new TreeNode(val);
                    break;
                }else {
                    currNode=currNode.left;
                }
            }
            if(currNode.val<val){
                if(currNode.right==null){
                    currNode.right=new TreeNode(val);
                    break;
                }else {
                    currNode=currNode.right;
                }
            }
        }
        return root;

    }

}
