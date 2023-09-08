package com.zack.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    /**
     * 层序遍历
     *
     *队列形式
     * 1、入队每层所有节点
     * 2、出队这一层所有节点，并收集结果
     * 3、把这一层所有节点的左右节点全部再入队
     * 4、重复这个过程
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        List<Integer> res=new ArrayList<>();
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()){
            List<TreeNode> list=new ArrayList<>();
            while (!q.isEmpty()){
                TreeNode node= q.poll();
                list.add(node);
            }
            for(TreeNode node :list){
                res.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
        }
        int [] result=new int[res.size()];
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;
    }
}
