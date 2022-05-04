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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) {
            return ans;
        }
        q.add(root);
        boolean ltor=true;
        while(!q.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            int len=q.size();
            for(int i=0 ; i<len ; i++){
                if(q.peek().left != null){
                    q.add(q.peek().left);
                }
                if(q.peek().right != null){
                    q.add(q.peek().right);
                }
                list.add(q.remove().val);
            }
            if(ltor==true){
                ans.add(list);
            }else{
                Collections.reverse(list);
                ans.add(list);
            }
            ltor = !ltor;
        }
        return ans;
        
    }
}