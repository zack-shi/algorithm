package com.zack.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/description/
 * 按之字形顺序打印二叉树
 */
public class levelOrderIII {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                list.add(node);
            }
            List<Integer> level = new ArrayList<>();
            if (flag) {
                for (TreeNode node : list) {
                    level.add(node.val);
                }
            }
            if (!flag) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    TreeNode node = list.get(i);
                    level.add(node.val);
                }
            }
            for (TreeNode node : list) {
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(level);
            flag = !flag;
        }
        return res;
    }

}
