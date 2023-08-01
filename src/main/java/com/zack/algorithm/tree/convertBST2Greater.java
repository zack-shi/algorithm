package com.zack.algorithm.tree;

public class convertBST2Greater {

    int preSum=0;
    int preVal=0;
    int totalSum=0;


    int pre=0;


    /**
     * 右中左遍历
     * @param root
     * @return
     */
    public TreeNode convertBST2Greater(TreeNode root){
        if(root==null){
           return null;
        }
        convertBST2Greater(root.right);
        root.val=pre+ root.val;
        pre=root.val;
        convertBST2Greater(root.left);
        return root;
    }




    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }
        //先遍历取到所有的值之和
        travesal(root);
        preSum=totalSum;
        travesalAgain(root);
        return root;
    }

    public void travesalAgain(TreeNode root){
        if(root==null){
            return;
        }
        travesalAgain(root.left);
        int newVal=preSum-preVal;
        preSum=newVal;
        preVal=root.val;
        root.val=newVal;
        travesalAgain(root.right);
    }


    public void travesal(TreeNode root){
        if(root==null){
            return;
        }
        travesal(root.left);
        totalSum=totalSum+root.val;
        travesal(root.right);
    }

}
