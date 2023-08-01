package com.zack.algorithm.tree;

public class DeleteBST {


    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        TreeNode left=new TreeNode(3);
        TreeNode right=new TreeNode(6);
        root.left=left;
        root.right=right;
        left.left=new TreeNode(2);
        left.right=new TreeNode(4);
        right.right=new TreeNode(7);

        root=deleteNodeBST(root,5);

    }

    /**
     * 递归
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }
        if(root.val==key){
            //要删除的的节点 左右子树都为空，直接删除当前节点，返回null即可
            if(root.left==null&&root.right==null){
                return null;
            }
            //要删除的的节点 左子节点为空,返回右子树的根
            else if(root.left==null){
                return root.right;
            }
            //要删除的的节点 右子节点为空,返回左子树的根
           else if(root.right==null){
                return root.left;
            }
            // 要删除的的节点 右子节点都不为空,则将删除节点的左子树放到删除节点的右子树的最左面节点的左孩子的位置
            // 并返回删除节点右孩子为新的根节点。
            else {
                //寻找右子树最左边的的节点
                TreeNode minLeft=root.right;
                while (minLeft.left!=null){
                    minLeft=minLeft.left;
                }

                root.right=deleteNode(root.right,minLeft.val);
                minLeft.left=root.left;
                minLeft.right=root.right;
                return minLeft;
            }
        }

        //继续在左右子树中寻找要删除的节点 并返回删除后的子树
        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }
        if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        return root;
    }

    /**
     * 迭代法
     * @param root
     * @param key
     * @return
     */
    public static TreeNode deleteNodeBST(TreeNode root, int key) {
        if(root==null){
            return root;
        }
        TreeNode curP=null;  //定义一个当前节点的父节点 初始为null
        TreeNode cur=root;   //当前节点
        // BST查找要删除的节点
        while (cur!=null){
            if(cur.val==key){
                break;
            }
            curP=cur;
            if(cur.val>key){
                cur=cur.left;
            }else {
                cur=cur.right;
            }
        }
        //遍历完都没找到
        if(cur==null){
            return root;
        }
        //说明要删的是根节点
        if(curP==null){
            if(cur.right==null||cur.left==null){
                if(cur.right!=null){
                    return cur.right;
                } else if(cur.left!=null){
                    return cur.left;
                }else {
                    return null;
                }
            }
        }
        //找到了要删除的节点
        //1、要删除的节点 无左右子节点
        if(cur.left==null&&cur.right==null){
            delCur(curP,cur,key);
            return root;
        }
        //2、要删除的节点 有一个左孩子
        else if(cur.right==null){
            delCur(curP,cur,key);
            return root;
        }
        //3、要删除的节点 有一个右孩子
        else if(cur.left==null){
            delCur(curP,cur,key);
            return root;
        }
        //4、要删除的节点 既有左孩子，又有右孩子
        else {
            //找到右子树中最小（最左边）的节点
            TreeNode minNodeP=cur; //初始化 右子树最小节点的父节点
            TreeNode minNode=cur.right; //初始化右子树最小节点
            //从右子树一直往左找最小节点
            while (minNode.left!=null){
                minNodeP=minNode;
                minNode=minNode.left;
            }
            //如果最小节点父节点 还是等于当前要删除的节点
            //说明右子树没有左边节点，右子树的根节点就是最小（最左）节点
            if(minNodeP.val==cur.val){
                //将最小节点的值赋给要删除的节点 替换
                cur.val=minNode.val;
                //然后将要删除的节点的右子节点 指向 最小节点的右子树
                cur.right=minNode.right;
                return root;
            }
            //右子树存在左边最小节点
            //赋值 替换
            cur.val=minNode.val;
            //这里又有 两种情况
            //1.最左节点无右子树
            if(minNode.right==null){
                //将最左节点的父节点的左子节点置空
                minNodeP.left=null;
                return root;

            }//2.最左节点 有右子树
            else {
                minNodeP.left=minNode.right;
                return root;
            }
        }
    }

    public static void delCur(TreeNode curP, TreeNode cur, int key){
        //判断当前节点是父节点的左孩子还是右孩子
        //右孩子，则将父节点的右孩子置为 当前节点的左孩子
        if(curP.right!=null&&curP.right.val==key){
            curP.right=cur.left;
        }
        //左孩子，则将父节点的左孩子置为 当前节点的左孩子
        if(curP.left!=null&&curP.left.val==key){
            curP.left=cur.left;
        }
    }






}
