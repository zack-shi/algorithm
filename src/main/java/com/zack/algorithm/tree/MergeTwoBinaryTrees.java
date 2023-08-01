package com.zack.algorithm.tree;

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode root = new TreeNode();
        if (root1 != null && root2 != null) {
            root.val = root1.val + root2.val;
        } else if (root1 != null) {
            root.val = root1.val;
        } else {
            root.val = root2.val;
        }
        root.left=mergeTrees(root1==null?null:root1.left,root2==null?null:root2.left);
        root.right=mergeTrees(root1==null?null:root1.right,root2==null?null:root2.right);
        return root;
    }

}
