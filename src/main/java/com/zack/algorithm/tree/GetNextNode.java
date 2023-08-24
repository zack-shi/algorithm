package com.zack.algorithm.tree;

/**
 * 剑指offer 8.二叉树的下一个结点
 * https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
 */
public class GetNextNode {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (null == pNode) {
            return null;
        }
        //1、如果当前节点有右子树，则根据中序遍历顺序（左根右），下一个节点一定是右子树中的最左节点
        TreeLinkNode p = pNode.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            TreeLinkNode root = pNode.next;
            TreeLinkNode child=pNode;
            while (root != null) {
                if (root.left == child) {//2、如果当前节点无右子树，但是有父节点，且当前节点为左孩子，那根据中序遍历顺序，刚好下一个节点就是：当前节点的父节点
                    return root;
                } else {//3、当前节点有父节点，但是当前节点是右孩子，根据中序遍历，下一步要找当前父节点作为左孩子的祖父节点，如果父节点不是左孩子，继续找祖父节点作为左孩子的 曾祖父节点。。。 依次类推
                    child=root;
                    root = root.next;
                }
            }
            //4、没有找到，说明当前节点就是最后的节点，无下一个节点了，返回null;
            return root;
        }
    }


    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

}
