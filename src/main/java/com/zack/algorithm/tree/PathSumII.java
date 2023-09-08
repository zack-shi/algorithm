package com.zack.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {

    int target; //目标值

    List<List<Integer>> paths = new ArrayList<>(); //所有路径和等于target的列表

    LinkedList<Integer> path = new LinkedList<>();//记录路径

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        this.target = target;
        travelAndSum(root, 0);
        return paths;
    }


    /**1、出入参
     * @param node    当前节点
     * @param lastSum 上一次最后累加sum的值
     */
    private void travelAndSum(TreeNode node, int lastSum) {
        if (node == null) {  //2、终止条件
            return;
        }
        //3、单层逻辑
        lastSum += node.val;
        path.add(node.val);
        if (node.left == null && node.right == null && lastSum == target) {
            paths.add(new LinkedList<>(path));//收集结果
        }

        travelAndSum(node.left, lastSum);
        travelAndSum(node.right, lastSum);
        path.removeLast(); //回溯
    }

}
