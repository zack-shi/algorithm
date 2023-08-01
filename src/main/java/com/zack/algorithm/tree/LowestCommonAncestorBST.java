package com.zack.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        List<TreeNode> arrP = new ArrayList<>();
        List<TreeNode> arrQ = new ArrayList<>();
        TreeNode rootP = root;
        while (rootP != null) {
            arrP.add(rootP);
            if (p.val < rootP.val) {
                rootP = rootP.left;
            } else if (p.val > rootP.val) {
                rootP = rootP.right;
            } else {
                break;
            }

        }
        TreeNode rootQ = root;
        while (rootQ != null) {
            arrQ.add(rootQ);
            if (q.val < rootQ.val) {
                rootQ = rootQ.left;
            } else if (q.val > rootQ.val) {
                rootQ = rootQ.right;
            } else {
                break;
            }
        }
        int i = 0;
        int j = 0;
        while (i < arrP.size() && j < arrQ.size()) {
            if (arrP.get(i) == arrQ.get(j)) {
                i++;
                j++;
                continue;
            } else {
                break;
            }
        }
        return arrP.get(i - 1);
    }

    public TreeNode anotherMethod(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor=null;
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                ancestor=root;
                break;
            }
        }
        return ancestor;
    }


}
