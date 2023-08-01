package com.zack.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 530. 二叉搜索树的最小绝对差
 */
public class MinimumDifferenceBST {

    /**
     * stack迭代法 遍历 中序
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list=getInOrderList(root);
        int i = 0;
        int j = 1;
        int min = list.get(j) - list.get(i);
        i++;
        j++;
        while (j < list.size()) {
            int val = list.get(j) - list.get(i);
            min = val < min ? val : min;
            i++;
            j++;
        }
        return min;
    }

    public List<Integer> getInOrderListStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (null == node) {
                node = stack.pop();
                list.add(node.val);
            } else {
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return list;
    }

    public List<Integer> getInOrderList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraval(list,root);
        return list;
    }

    public void inOrderTraval(List<Integer> list,TreeNode node){
        if(node==null){
            return;
        }
        inOrderTraval(list,node.left);
        list.add(node.val);
        inOrderTraval(list,node.right);
    }

}
