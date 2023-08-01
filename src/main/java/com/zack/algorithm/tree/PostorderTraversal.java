package com.zack.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        traversal(root,list);
        return list;
    }
    void  traversal(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        traversal(node.left,list);
        traversal(node.right,list);
        list.add(node.val);
    }

    void postTra(TreeNode root,List<Integer> list){
        if(null==root){
            return;
        }
        LinkedList<Object> stack=new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Object pop = stack.pop();
            if(pop instanceof Integer){
                list.add((int)pop);
            }else {
                TreeNode node=(TreeNode) pop;
                stack.push(node.val);
                if(node.right!=null){
                    stack.push(node.right);
                }
                if(node.left!=null){
                    stack.push(node.left);
                }
            }
        }
    }

}
