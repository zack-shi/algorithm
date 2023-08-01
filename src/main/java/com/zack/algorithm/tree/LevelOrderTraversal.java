package com.zack.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<TreeNode> levelNodes = null;
        List<List<Integer>> allLevelNode = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list=new ArrayList<>();
            levelNodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node=queue.poll();
                levelNodes.add(node);
                list.add(node.val);
            }
            allLevelNode.add(list);
            for (TreeNode treeNode : levelNodes) {
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
        }
        return allLevelNode;
    }


}
