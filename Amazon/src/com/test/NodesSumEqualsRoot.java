package com.test;

public class NodesSumEqualsRoot {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

//        System.out.println(isNodesSumEqualsRoot(root));
    }

//    private static boolean isNodesSumEqualsRoot(TreeNode root){
//
//    }


    private static void helper(TreeNode root, int rootVal){
        if(root == null)
            return;

        if(root.left != null) {
            helper(root.left, root.left.val);
        }else{

        }

        if(root.right != null)
            helper(root.right, root.right.val);
    }
}
