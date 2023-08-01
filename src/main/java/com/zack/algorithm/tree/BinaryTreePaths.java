package com.zack.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> list = binaryTreePaths(root);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.right == null && root.left == null) {
            list.add(String.valueOf(root.val));
            return list;
        }
        if (root.left != null) {
            path(root.left, new StringBuilder().append(root.val), list);
        }
        if (root.right != null) {
            path(root.right, new StringBuilder().append(root.val), list);
        }
        return list;
    }

    public static void path(TreeNode node, StringBuilder pathStr, List<String> list) {
        if (node.right == null && node.left == null) {
            list.add(pathStr.append("->").append(node.val).toString());
        }
        if (node.left != null) {
            StringBuilder sb=pathStr;
            path(node.left, sb.append("->").append(node.val), list);
        }
        if (node.right != null) {
            StringBuilder sb=pathStr;
            path(node.right, sb.append("->").append(node.val), list);
        }
    }

}
