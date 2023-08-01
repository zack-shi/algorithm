package com.zack.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class ValidBST {

    Integer currNum = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        return valid(root);
    }

    public boolean valid(TreeNode root) {
        if (root != null) {
            boolean isLeftValid = valid(root.left);
            if (!isLeftValid) {
                return false;
            }
            if (currNum == null) {
                currNum = root.val;
            } else {
                boolean isRootValid = root.val > currNum;
                if (!isRootValid) {
                    return false;
                }
                if (isRootValid) {
                    currNum = root.val;
                }
            }
            boolean isRigthtValid = valid(root.right);
            if (!isRigthtValid) {
                return false;
            }
        }
        return true;
    }


    List<Integer> list = new ArrayList<>();

    public boolean validBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        traversal(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
               return false;
            }
        }
        return true;
    }

    void traversal(TreeNode root) {
        if(root==null){
            return;
        }
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }

}
