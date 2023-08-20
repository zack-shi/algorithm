package com.zack.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/find-bottom-left-tree-value/description/
 * 找树左下角的值
 */
public class FindBottomLeft {

    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> q=new LinkedList();
        q.offer(root);
        while (!q.isEmpty()){
            int sz=q.size();
            boolean hasNextLevel=false; //标记是否还有下一层元素
            ArrayList<TreeNode> list=new ArrayList<>();
            while (sz>0) {
                TreeNode pop= q.poll();
                list.add(pop);
                if(pop.left!=null){
                    q.offer(pop.left);
                    hasNextLevel=true;
                }
                if(pop.right!=null){
                    q.offer(pop.right);
                    hasNextLevel=true;
                }
                sz--;
            }
            //while循环后，没有下一层元素
            if(!hasNextLevel){
                return list.get(0).val;
            }
        }
        return 0;
    }


}
