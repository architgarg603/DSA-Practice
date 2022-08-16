/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        solve(root,  p,  q);
        return ans;
    }
    
    
    public boolean solve(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return false;
        
        
        boolean left  = solve(root.left, p, q);
        boolean right = solve(root.right, p ,q);
        
        if((left == true && right == true) || ((root == p || root == q) && (left == true || right ==true))){
            this.ans = root;
            return true;
        }
        
        
        return (root == p || root == q || right == true || left == true); 
        
        
    }
    
}