package com.zack.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 */
public class FindModeBST {

    int curVal;
    int maxCount;
    int count;
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            mode[i] = list.get(i);
        }
        return mode;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (root.val == curVal) {
            count++;
        } else {
            count = 1;
            curVal = root.val;
        }
        if (maxCount == count) {
            list.add(root.val);
        } else if (count > maxCount) {
            maxCount=count;
            list.clear();
            list.add(root.val);
        }
        dfs(root.right);
    }

}
