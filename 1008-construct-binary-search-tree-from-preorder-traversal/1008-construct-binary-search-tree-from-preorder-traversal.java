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
    public TreeNode bstFromPreorder(int[] arr) {
        return solve(arr, Integer.MIN_VALUE, Integer.MAX_VALUE, new int[1]);
    }
    
    public TreeNode solve(int[] arr, int min, int max, int[] idx){
        int i = idx[0];
        if(i>= arr.length || arr[i]<min || arr[i]>max)return null;
        TreeNode root = new TreeNode(arr[i]);
        idx[0] = i+1;
        root.left = solve(arr,min, arr[i], idx);
        root.right = solve(arr,arr[i], max, idx);
        return root;
    }
}