package com.zack.algorithm.tree;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        if (postorder.length == 1) {
            return true;
        }
        int i = 0;
        int j = postorder.length - 1;
        int m=firstBiggerValue(0,postorder.length - 1,postorder);
        return verify(i, j, m, postorder);
    }

    public boolean verify(int i, int j, int m, int[] postorder) {
        if (i >= j) {
            return true;
        }
        for (int k = i; k <= m - 1; k++) {
            if (postorder[k] > postorder[j]) {
                return false;
            }
        }
        for (int k = m; k < j; k++) {
            if (postorder[k] < postorder[j]) {
                return false;
            }
        }
        int x=firstBiggerValue(i,m-1,postorder);
        boolean leftV = verify(i, m-1, x, postorder);
        int y=firstBiggerValue(m,j-1,postorder);
        boolean rightV = verify(m, j-1, y, postorder);
        return leftV && rightV;
    }


    public int firstBiggerValue(int i, int j, int[] postorder) {
        if(i>=j){
            return i;
        }
        while (postorder[i] < postorder[j]) i++;
        return i;
    }

    public static void main(String[] args) {
        int [] orders={5, 4, 3, 2, 1};
        new VerifyPostorder().verifyPostorder(orders);
    }

}
