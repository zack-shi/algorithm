package com.zack.algorithm.tree;

import java.util.LinkedList;

public class CountCompleteTree {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }


    public int countNode(TreeNode root) {
        if(root==null){
            return 0;
        }
        LinkedList<TreeNode> stack=new LinkedList();
        stack.offer(root);
        int count=0;
        while (!stack.isEmpty()){
            int sz=stack.size();
            while (sz>0) {
                TreeNode node=stack.poll();
                count++;
                if(node.left!=null){
                    stack.offer(node.left);
                }
                if(node.right!=null){
                    stack.offer(node.right);
                }
                sz--;
            }
        }
        return count;
    }

}
