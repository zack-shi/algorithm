package com.zack.algorithm.tree;

public class SortedArrayToBST {


    public static void main(String[] args) {
        int [] a={-10,-3,0,5,9};
        TreeNode node=sortedArrayToBST(a);
        System.out.println(node.val);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return arrToBST(nums,0,nums.length-1);
    }

    public static TreeNode arrToBST(int [] nums,int l,int r){
        if(l==r){
            return new TreeNode(nums[l]);
        }
        if (l>r){
            return null;
        }
        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=arrToBST(nums,l,mid-1);
        root.right=arrToBST(nums,mid+1,r);
        return root;
    }
}
