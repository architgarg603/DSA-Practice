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
        lca(root,p,q);
        return ans;
    }
    
    public boolean lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)return false;
        
        boolean check = (root == p || root == q);
        
        boolean left = lca(root.left,p,q);
        boolean right = lca(root.right,p,q);
        
        if((left == true && right == true) || ((left == true || right == true ) && check == true) ){
            ans = root;
            return true;
        }
        
        return left || right || check;
        
    }
}