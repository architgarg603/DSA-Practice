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
    
    private TreeNode rightMost(TreeNode root, TreeNode curr){
        while(root.right != null && root.right != curr)root = root.right;
        return root;
    }
    
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        
        while(curr != null){
           if(curr.left != null){
               TreeNode rm = rightMost(curr.left, curr);
               rm.right = curr.right;
               
               curr.right = curr.left;
               curr.left = null;
           }
            
            curr = curr.right;
        }
        
        
    }
}