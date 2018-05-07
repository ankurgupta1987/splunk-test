package com.test;

public class CheckSumTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(24);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(isSumTree(root));
    }

    private static boolean isSumTree(TreeNode root){
        if(root==null || isLeaf(root))return true;

        if(isSumTree(root.left) && isSumTree(root.right)){
            int leftSum = 0;
            int rightSum = 0;

            if(root.left==null)leftSum=0;
            else if(isLeaf(root.left))leftSum = root.left.val;
            else leftSum = 2*root.left.val;

            if(root.right==null)rightSum=0;
            else if(isLeaf(root.right))rightSum = root.right.val;
            else rightSum = 2*root.right.val;

            if(root.val == rightSum + leftSum){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    private static boolean isLeaf(TreeNode root){
        if(root != null && root.left==null && root.right == null){
            return true;
        }
        return false;
    }
}

//class TreeNode{
//    TreeNode left;
//    TreeNode right;
//    int val;
//    public TreeNode(int val){
//        this.val = val;
//    }
//}