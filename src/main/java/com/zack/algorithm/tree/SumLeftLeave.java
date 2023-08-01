package com.zack.algorithm.tree;


public class SumLeftLeave {
    static  int  sum=0;
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        System.out.println(sumOfLeftLeaves(root));
    }


    public static int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return sum;
        }
        sumLeft(root);
        return sum;
    }

    public static void sumLeft(TreeNode node){
        if(node.left!=null&&node.left.left==null&&node.left.right==null){
            sum+=node.left.val;
        }else {
            if(node.left!=null){
                sumLeft(node.left);
            }
        }
        if(node.right!=null){
            sumLeft(node.right);
        }
    }

}
