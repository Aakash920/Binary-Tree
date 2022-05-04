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
    public int diameterOfBinaryTree(TreeNode node) {
        // if(node==null) return 0;
        // int ls=diameterOfBinaryTree(node.left);
        // int rs=diameterOfBinaryTree(node.right);
        // int both=ht(node.left)+ht(node.right)+2;
        // return Math.max(ls,Math.max(rs,both));
        
        //efficient approach
        int[] dia=new int[1];
        ht(node,dia);
        return dia[0];
    }
    private int ht(TreeNode node, int[] dia){
        if(node==null) return 0;
        int ls=ht(node.left,dia);
        int rs=ht(node.right,dia);
        dia[0]=Math.max(dia[0],ls+rs);
        return Math.max(ls,rs) +1;
    }
    // private int ht(TreeNode node){
    //     if(node==null) return -1;
    //     int ls=ht(node.left);
    //     int rs=ht(node.right);
    //     return Math.max(ls,rs)+1;
    // }
}