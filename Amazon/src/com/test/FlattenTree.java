package com.test;

public class FlattenTree {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        new FlattenTree().flatten(root);
        System.out.println(root.val);
    }

    TreeNode previous = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode right = root.right;
        TreeNode left = root.left;
        if(previous != null){
            previous.right = root;
            previous.left = null;

        }
        previous = root;
        flatten(left);
        flatten(right);
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
