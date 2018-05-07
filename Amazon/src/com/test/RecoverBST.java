package com.test;

//two elements are swapped by mistake
//find them and recover
public class RecoverBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(16);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(5);
        recoverTree(root);
        System.out.println("Hello");
    }

    static TreeNode firstElement = null;
    static TreeNode secondElement = null;
    public static void recoverTree(TreeNode root) {
        if(root == null)return;
        checkBSTAndFindElements(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if(firstElement != null && secondElement != null) {
            int temp = firstElement.val;
            firstElement.val = secondElement.val;
            secondElement.val = temp;
        }
    }

    private static void checkBSTAndFindElements(TreeNode root, int min_val, int max_val){
        if(root == null) return;

        if(min_val <= root.val && root.val <= max_val){
            checkBSTAndFindElements(root.left, min_val, root.val);
            checkBSTAndFindElements(root.right, root.val, max_val);
        }else{
            if(firstElement == null)
                firstElement = root;
            else
                secondElement = root;
        }
    }
}
