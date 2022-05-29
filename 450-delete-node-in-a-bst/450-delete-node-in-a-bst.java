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
    
    public TreeNode find(TreeNode root, TreeNode oRoot){
      if(root == null)return null;
        if(root.right == null){
            oRoot.val = root.val;
            return root.left;
        }
        
        root.right = find(root.right, oRoot);
        return root;
        
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;
        
        if(root.val == key){
            if(root.left == null)return root.right;
            root.left = find(root.left, root);
            return root;
        }
        
        root.left = deleteNode(root.left, key);
        
        root.right = deleteNode(root.right,key);
        
        return root;
        
        
    }
}