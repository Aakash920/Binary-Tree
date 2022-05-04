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
    public class Pair{
        TreeNode node;
        boolean sd;
        boolean ld;
        boolean rd; 
    } 
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<Pair> s=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        
        //creating a starting pair
        Pair sp=new Pair();
        sp.node=root;
        //put this sp into stack
        s.push(sp);
        
        while(!s.isEmpty()){
            Pair tp=s.peek();
            if (tp.node == null) {
				s.pop();
				continue;
			}
            if(tp.sd==false && tp.node!=null){
                ans.add(tp.node.val);
                tp.sd=true;
            }else if(tp.ld==false){
                Pair np=new Pair();
                np.node=tp.node.left;
                s.push(np);
                tp.ld=true;
            }else if(tp.rd==false){
                Pair np=new Pair();
                np.node=tp.node.right;
                s.push(np);
                tp.rd=true;
            }else{
                s.pop();
            }
        }
        return ans;
    }
}