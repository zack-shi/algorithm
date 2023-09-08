package com.zack.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class SymmetricTree2 {

    /**
     * 递归
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left.val == right.val){
            return check(left.left, left.right, right.left, right.right);
        }
        return false;
    }

    public boolean check(TreeNode LL, TreeNode LR, TreeNode RL, TreeNode RR) {
        if(LL == null && RR == null&&LR == null && RL == null){
            return true;
        }
        boolean check1 = (LL == null && RR == null) || (LL != null && RR != null && LL.val == RR.val);
        boolean check2 = (LR == null && RL == null) || (LR != null && RL != null && LR.val == RL.val);
        if (check1 && check2) {
            return check(LL==null?null:LL.left, RR==null?null:RR.right, LL==null?null:LL.right, RR==null?null:RR.left)
                    && check(LR==null?null:LR.left, RL==null?null:RL.right, LR==null?null:LR.right, RL==null?null:RL.left);
        }
        return false;
    }


    /**
     * 层序遍历
     * @param root
     * @return
     */
    boolean levelCheck(TreeNode root){
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        if(root.left.val != root.right.val){
            return false;
        }
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root.left);
        q.offer(root.right);
        while (!q.isEmpty()){
            TreeNode L=q.poll();
            TreeNode R=q.poll();

            TreeNode LL=L.left;
            TreeNode LR=L.right;
            TreeNode RL=R.left;
            TreeNode RR=R.right;
            if(LL == null && RR == null&&LR == null && RL == null){
               continue;
            }
            if (LL != null && RR != null && LL.val == RR.val){
                q.offer(LL);
                q.offer(RR);
            }else if(!(LL==null&&RR==null)) {
                return false;
            }
            if (LR != null && RL != null && LR.val == RL.val) {
                q.offer(LR);
                q.offer(RL);
            }else if(!(LR==null&&RL==null)) {
                return false;
            }
        }
        return true;
    }


}
