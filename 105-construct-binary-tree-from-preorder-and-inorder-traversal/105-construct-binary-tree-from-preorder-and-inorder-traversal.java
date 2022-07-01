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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder,0,preorder.length-1,0,inorder.length-1);
    }
    
    public TreeNode solve(int[] pre, int[] in, int psi, int pei, int isi, int iei){
        if(psi>pei)return null;
        int idx = isi;
        while(pre[psi] != in[idx])idx++;
        int cnt = idx - isi;
        TreeNode root = new TreeNode(pre[psi]);
        
        root.left = solve(pre, in, psi+1,psi+cnt, isi, idx-1);
        root.right = solve(pre, in, psi+cnt+1, pei, idx+1, iei);
        return root;
    }
}