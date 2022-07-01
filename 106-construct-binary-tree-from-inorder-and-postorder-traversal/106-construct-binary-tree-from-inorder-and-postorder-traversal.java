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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return solve(inorder, postorder, 0,inorder.length-1, 0,postorder.length-1);
    }
    
    public TreeNode solve(int[] in, int[] post, int isi, int iei, int psi, int pei){
        if(psi>pei)return null;
        int idx = isi;
        while(in[idx] != post[pei])idx++;
        int cnt = idx - isi;
        
        TreeNode root = new TreeNode(post[pei]);
        root.left = solve(in,post, isi, idx-1, psi, psi+cnt -1);
        root.right = solve(in,post,  idx+1, iei,psi + cnt, pei -1);
        return root;
        
    }
}