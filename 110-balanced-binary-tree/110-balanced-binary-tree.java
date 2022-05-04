/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        // return height(root) != -1;
        if(root==null) return true;
        
        boolean ls=isBalanced(root.left);
        boolean rs=isBalanced(root.right);
        
        int bf=ht(root.left)-ht(root.right);
        if(ls && rs && bf>=-1 && bf<=1) return true;
        return false;
    }
    private int ht(TreeNode node){
        if(node==null) return -1;
        int ls=ht(node.left);
        int rs=ht(node.right);
        return Math.max(ls,rs)+1;
    }
    // private int height(TreeNode node){
    //     if(node==null) return 0;
    //     int ls=height(node.left);
    //     if(ls==-1) return -1;
    //     int rs=height(node.right);
    //     if(rs==-1) return -1;
    //     if(Math.abs(ls-rs)>1) return -1;
    //     return Math.max(ls,rs)+1;
    // }
}