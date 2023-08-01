package com.zack.algorithm.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * <p>
 * 二叉树的前序遍历
 */
public class PreorderTraversal {


    public  List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        traversal(root,list);
        return list;
    }

     void  traversal(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        list.add(node.val);
        traversal(node.left,list);
        traversal(node.right,list);
    }

   void preTraversal(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
       Stack<TreeNode> stack=new Stack<>();
       stack.push(root);
       while (stack.size()>0){
           TreeNode node=stack.pop();
           list.add(node.val);
           if(node.right!=null){
               stack.push(node.right);
           }
           if(node.left!=null){
               stack.push(node.left);
           }
       }
   }



}
