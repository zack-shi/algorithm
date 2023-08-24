package com.zack.algorithm.tree;

/**
 * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
 * 树的子结构
 */
public class CheckIsSubStructure {

    TreeNode B;
    boolean result;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        this.B = B;
        travel(A);
        return result;
    }

    //遍历A，发现A.val等于B.val，则A和B同时开始遍历检查
    void travel(TreeNode A) {
        if (A != null && A.val == B.val) {
            if(B.left!=null&&A.left==null){  //B有的子节点 A没有，不用继续检查了，B肯定不是A的子树
                result=false;
                return;
            }
            if(B.right!=null&&A.right==null){ //同上
                result=false;
                return;
            }
            result=true;          //先默认为true
            if(B.left!=null&&A.left!=null){   //双方都有的节点需要进一步检查
                result=check(A.left, B.left);
            }
            if(B.right!=null&&A.right!=null){  //同上
                result=check(A.right, B.right);
            }
            if (result) { //要么检查结果是true，要么 A和B的子节点都为null,都为null说明B都遍历完了，检查为true
                return;
            }
        }
        //还没找到A.val=B.val,或者上面发现A.val=B.val 但是检查发现不对，但是A还有节点，继续往下遍历A，找下一个A.val=B.val
        if (A.left != null) {
            travel(A.left);
        }
        if (A.right != null) {
            travel(A.right);
        }
    }

    /**
     * 检查逻辑
     * @param A
     * @param B
     * @return
     */
    boolean check(TreeNode A, TreeNode B) {
        if (A.val != B.val) {  //值检查
            return false;
        }
        if(B.left!=null&&A.left==null){ //同上
            return false;
        }
        if(B.right!=null&&A.right==null){ //同上
            return false;
        }
        boolean check=true;
        if(B.left!=null&&A.left!=null){ //同上
            check=check(A.left, B.left);
        }
        if(B.right!=null&&A.right!=null){ //同上
            check=check(A.right, B.right);
        }
        return check;
    }

}
