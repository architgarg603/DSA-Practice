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
    
    public TreeNode rightMost(TreeNode root, TreeNode curr){
        while(root.right != null && root.right != curr)root = root.right;
        return root;
    }
    
    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        TreeNode prev= null, temp = root;
        
        while(temp != null){
            
            if(temp.left == null){
                if(prev != null && prev.val >= temp.val)return false;
                prev = temp;
                temp = temp.right;
            }else{
                TreeNode rightMostNode = rightMost(temp.left, temp);
                
                if(rightMostNode.right == temp){
                    
                    rightMostNode.right = null;
                    if(prev != null && prev.val >= temp.val)return false;
                    prev = temp;
                    temp = temp.right;
                }else{
                    rightMostNode.right = temp;
                    temp = temp.left;
                }
                
            }
        }
        
        return true;
    }
}