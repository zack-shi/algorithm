package com.zack.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class levelOrderII {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()){
            List<TreeNode> list=new ArrayList<>();
            while (!q.isEmpty()){
                TreeNode node= q.poll();
                list.add(node);
            }
            List<Integer> level=new ArrayList<>();
            for(TreeNode node :list){
                level.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
