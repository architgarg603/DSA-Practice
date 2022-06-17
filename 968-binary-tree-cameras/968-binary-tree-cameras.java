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
    int cnt = 0;
    public int minCameraCover(TreeNode root) {
        if(root.left == null && root.right == null)return 1;
         
        return solve(root) == -1 ? cnt+1 : cnt;
    }
    
    public int solve(TreeNode root){
        
        if(root == null)return 0;
        
        int l = solve(root.left);
        int r = solve(root.right);
        
        if( l== -1 || r==-1 ){
            cnt++;
            return 1;
        }
        
        if(l == 1 || r==1){
            return 0;
        }
        
        return -1;
        
    }
}