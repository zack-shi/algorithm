package com.zack.algorithm.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor {

    Map<Integer,TreeNode> map=new HashMap<>();

    Set<Integer> visited=new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p!=null){
            visited.add(p.val);
            TreeNode node=map.get(p.val);
            p=node;
        }
        while (q!=null){
            if(!visited.add(q.val)){
                return q;
            }
            TreeNode node=map.get(q.val);
            q=node;
        }
        return null;
    }

    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            map.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right!=null){
            map.put(root.right.val,root);
            dfs(root.right);
        }
    }


}
