// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans=new ArrayList<>();
	    if(node.left==null && node.right==null){
	        ans.add(node.data);
	        return ans;
	    }
	    ans.add(node.data); 
	    leftTree(node.left,ans);
	    leaf(node,ans);
	    rightTree(node.right,ans);
	    
	    return ans;
	}
	private void leftTree(Node node,ArrayList<Integer> list){
	    if(node == null){
	        return;
	    }
	    if(node.left != null){
	        list.add(node.data);
	        leftTree(node.left,list);
	    }else if(node.right != null){
	        list.add(node.data);
	        leftTree(node.right,list);
	    }
	}
	private void leaf(Node node, ArrayList<Integer> list){
	    if(node==null) return;
	    leaf(node.left,list);
	    if(node.left==null && node.right==null) {
	        list.add(node.data);
	    }
	    leaf(node.right,list);
	}
	private void rightTree(Node node, ArrayList<Integer> list){
	    if(node==null){
	        return ;
	    }
	    if(node.right!=null){
	        rightTree(node.right,list);
            list.add(node.data);
       }else if(node.left!=null){
           rightTree(node.left,list);
           list.add(node.data);
       }
	}
}
