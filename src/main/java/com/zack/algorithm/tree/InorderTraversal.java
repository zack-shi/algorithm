package com.zack.algorithm.tree;

import java.util.*;

/**
 * 二叉树的中序遍历
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        traversal(root,list);
        return list;
    }

    /**
     * 递归实现
     * @param node
     * @param list
     */
    void  traversal(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        traversal(node.left,list);
        list.add(node.val);
        traversal(node.right,list);

    }

    /**
     * 迭代实现
     *
     * 其核心思想如下：
     * 使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
     * 如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
     * 如果遇到的节点为灰色，则将节点的值输出。
     *
     * @param root
     * @param list
     */
    void inTraversal(TreeNode root, List<Integer> list){
        if (root==null){
            return;
        }
        Map<TreeNode,Boolean> map=new HashMap<>();
        Stack<TreeNode> stack=new Stack<>();
        map.put(root,false);
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node= stack.pop();
            boolean isVisit=map.getOrDefault(node,false);
            if(isVisit){
                list.add(node.val);
            }else {
                map.put(node,true);
                if(node.right!=null){
                    stack.push(node.right);  //右
                }
                stack.push(node);      //自身  中
                if(node.left!=null){
                    stack.push(node.left);  //左
                }
            }
        }
    }

}
