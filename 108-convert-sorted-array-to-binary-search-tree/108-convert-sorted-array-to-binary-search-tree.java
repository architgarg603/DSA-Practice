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
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums, 0, nums.length-1);
    }
    
    public TreeNode solve(int[] arr, int si, int ei){
        if(si == ei)return new TreeNode(arr[si]);
        if(si>ei)return null;
        
        int mid = si + (ei-si)/2;
        
        TreeNode root = new TreeNode(arr[mid]);
        
        root.left = solve(arr,si,mid-1);
        root.right = solve(arr, mid+1,ei);
        
        return root;
        
    }
    
}