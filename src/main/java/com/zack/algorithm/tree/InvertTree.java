package com.zack.algorithm.tree;


import java.util.*;

/**
 * 翻转二叉树
 */
public class InvertTree {


    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    /**
     * 前序遍历 递归
     *
     * @param node
     */
    void reverse(TreeNode node) {
        if (null == node) {
            return;
        }
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;
        reverse(node.left);
        reverse(node.right);
    }


    /**
     * 层序遍历 迭代  （队列实现）
     *
     * @param root
     */
    public TreeNode levelTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                list.add(node);
            }
            for (TreeNode treeNode : list) {
                if (null != treeNode.left) {
                    queue.offer(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.offer(treeNode.right);
                }
            }
        }
        return root;
    }


    /**
     * 统一迭代遍历 （栈实现）
     */
    public TreeNode stackTraver(TreeNode root) {
        if(root==null){
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        Map<TreeNode,Boolean> map=new HashMap<>();
        map.put(root,false);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (map.getOrDefault(pop,false) == true) {
                TreeNode temp = pop.right;
                pop.right = pop.left;
                pop.left = temp;
            } else {
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                stack.push(pop);
                map.put(pop,true);
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
        }
        return root;
    }


}
