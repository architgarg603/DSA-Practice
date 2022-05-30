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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        
        solve(root,target,k,ans);
        
        return ans;
        
    }
    
    public int solve(TreeNode root, TreeNode tar, int k,List<Integer> ans){
        if(root == null)return -1;
        
        if(root == tar){
            kDis(root, null, k, ans);
            return 1;
        }
        
        int left = solve(root.left,tar,k,ans);
        if(left > 0 && left<=k){
            kDis(root, root.left,k-left,ans);
            return left+1;
        }
        
        
        int right = solve(root.right,tar,k,ans);
        if(right > 0 && right<= k){
            kDis(root, root.right,k-right,ans);
            return right+1;
        }
        
        return -1;
            
            
    }
    
    public void kDis(TreeNode root, TreeNode block, int lev, List<Integer> ans){
        if(root == null || lev<0 || root == block)return;
        if(lev == 0){
            ans.add(root.val);
            return;
        }
        
        kDis(root.left, block,lev-1,ans);
        kDis(root.right, block,lev-1,ans);
    }
        
        
        
}