package com.zack.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < q.size(); i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    list.add(node);
                    sb.append(node.val + ",");
                } else {
                    sb.append("null,");
                }
            }
            for (TreeNode treeNode : list) {
                q.offer(treeNode.left);
                q.offer(treeNode.right);
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")){
            return null;
        }
        String [] datas=data.substring(1,data.length()-1).split(",");

        TreeNode root=new TreeNode(Integer.parseInt(datas[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int i=1;
        while (!q.isEmpty()&&i< datas.length){
            TreeNode node=q.poll();
            if(datas[i].equals("null")){
                node.left=null;
            }else {
                node.left=new TreeNode(Integer.parseInt(datas[i]));
                q.offer(node.left);
            }
            i++;
            if(datas[i].equals("null")){
                node.right=null;
            }else {
                node.right= new TreeNode(Integer.parseInt(datas[i]));
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeBinaryTree codec = new SerializeBinaryTree();
        TreeNode node=codec.deserialize("[1,2,3,null,null,4,5]");

        System.out.println(codec.serialize(node));
    }


}
