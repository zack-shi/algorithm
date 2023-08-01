package com.zack.algorithm.tree;

/**
 * 二叉搜索树中的搜索
 */
public class SearchInABinarySearchTree {

    /**
     * 迭代写法
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        while (root!=null){
            if(root.val==val){
                return root;
            } else if(root.val >val){
                root=root.left;
            }else {
              root=root.right;
            }
        }
        return root;
    }

    /**
     * 递归写法
     * @param root
     * @param val
     * @return
     */
    public TreeNode search(TreeNode root, int val){
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        if(root.val>val){
         return search(root.left,val);
        }else {
            return search(root.right,val);
        }
    }

}
