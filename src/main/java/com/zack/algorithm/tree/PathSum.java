package com.zack.algorithm.tree;

import java.util.Stack;

/**
 * 路径总和
 */
public class PathSum {

    int target;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        int sum=0;
        target=targetSum;
        return pathSum(root,sum);
    }

    public boolean pathSum(TreeNode node,int sum){
        boolean flag=false;
        if(node.left==null&&node.right==null){
            if(sum+node.val==target){
                flag=true;
            }
        }
        if(node.left!=null){
            pathSum(node.left,sum+node.val);
        }

        if(node.right!=null){
            pathSum(node.right,sum+node.val);
        }
        return flag;
    }



}
