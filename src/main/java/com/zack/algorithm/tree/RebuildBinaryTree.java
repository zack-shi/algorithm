package com.zack.algorithm.tree;

import java.util.HashMap;

public class RebuildBinaryTree {

    HashMap<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        TreeNode root = reConstruct(0, 0, inorder.length - 1, preorder);
        return root;
    }

    TreeNode reConstruct(int p, int start, int end, int[] preOrder) {
        if(start > end) return null;
        int pValue = preOrder[p];
        TreeNode root = new TreeNode(pValue);
        int index = inMap.get(pValue);
        root.left = reConstruct(p + 1, start, index - 1, preOrder);
        root.right = reConstruct(index - start + p + 1, index + 1, end, preOrder);
        return root;
    }

}
