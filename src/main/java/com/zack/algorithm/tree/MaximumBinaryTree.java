package com.zack.algorithm.tree;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root= construct(nums,0,nums.length-1);
        return root;
    }

    public TreeNode construct(int[] nums,int left,int right){
        if(left==right){
            return new TreeNode(nums[left]);
        }
        if(left>right){
            return null;
        }
        int index=maxNum(nums,left,right);
        TreeNode root=new TreeNode(nums[index]);
        root.left=construct(nums,left,index-1);
        root.right=construct(nums,index+1,right);
        return root;
    }


    /**
     * 数组索引l和r之间取最大值
     * @param arr
     * @param l
     * @param r
     * @return
     */
    int maxNum(int[] arr,int l,int r){
        int max=arr[l];
        int maxVIndex=l;
        for(int i=l+1;i<=r;i++){
            if(arr[i]>max){
                max=arr[i];
                maxVIndex=i;
            }
        }
        return maxVIndex;

    }

}
