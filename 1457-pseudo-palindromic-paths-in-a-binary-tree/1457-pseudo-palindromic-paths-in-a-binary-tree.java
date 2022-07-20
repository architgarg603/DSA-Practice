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
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null)return 0;
        
        int[] freq = new int[10];
        return solve(root, freq);
    }
    
    public int solve(TreeNode root, int[] freq){
        if(root == null) return 0;
       
        freq[root.val]++;
       
        if(root.left == null && root.right == null){    
            int val =  check(freq);
            freq[root.val]--;
            return val;
        } 
        
        int ans = 0;
        ans += solve(root.left, freq);
        ans += solve(root.right, freq);
        freq[root.val]--;
        
        return ans;
        
    }
    
    public int check(int[] arr){
        int ans = 0;
        for(int i : arr){
            if((i & 1) == 1)ans++;
        }
        return (ans > 1) ? 0 : 1;
    }
}