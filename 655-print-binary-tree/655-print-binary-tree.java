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
    
    class node{
        TreeNode node = null;
        int c = 0;
        
        node(TreeNode node,int c){
            this.node = node;
            this.c = c;
        }
    }
    
    public int height(TreeNode root){
        if(root == null)return -1;
        
        return Math.max(height(root.left), height(root.right) )+ 1;
        
    }
    
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        int h = height(root);
        int c = ((2<<h) - 1);
        for(int i =0;i<h+1;i++){
            List<String> temp = new ArrayList<>();
            for(int j=0;j< c;j++){
                temp.add("");
            }
            
            ans.add(temp);
        }
        
        Queue<node> qu = new LinkedList<>();
        qu.add(new node(root,c/2));
        
        int lev = 0;
        
        while(qu.size()>0){
            int size = qu.size();
            
            for(int i=0;i<size;i++){
                node nn = qu.remove();
                ans.get(lev).set(nn.c, nn.node.val+"");
                if(nn.node.left != null)qu.add(new node(nn.node.left, nn.c - (int)Math.pow(2,(h-lev-1))));
                if(nn.node.right != null)qu.add(new node(nn.node.right, nn.c + (int)Math.pow(2,(h-lev-1))));
                
            }
            
            lev++;
        }
        
        return ans;
    }
}