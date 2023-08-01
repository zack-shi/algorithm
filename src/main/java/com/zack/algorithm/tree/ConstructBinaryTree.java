package com.zack.algorithm.tree;


import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 */
public class ConstructBinaryTree {

    Map<Integer, Integer> inOrderMap = new HashMap<>();
    int[] inorder;
    int[] postorder;
    int postNum;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        postNum = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        //特性 后序遍历的最后一个元素 一定是根节点
        //然后根据它在中序遍历中的位置，又可以分为左右子树
        //接着同样原理继续往下推
        TreeNode root = build(0, inorder.length - 1);
        return root;
    }

    TreeNode build(int inleft, int inright) {
        if (inleft > inright) {
            return null;
        }
        int rootVal=postorder[postNum];
        TreeNode root = new TreeNode(rootVal);
        int index = inOrderMap.get(rootVal);
        postNum--;
        //右子树
        root.right = build(index + 1, inright);
        //左子树
        root.left = build(inleft, index - 1);
        return root;
    }

}
