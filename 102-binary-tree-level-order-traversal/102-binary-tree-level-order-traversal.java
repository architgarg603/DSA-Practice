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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null)return ans;
        
        Queue<TreeNode> qu = new LinkedList<>();
        
        qu.add(root);
        
        while(qu.size()>0){
            int size = qu.size();
            List<Integer> temp = new ArrayList<>();
            
            while(size-->0){
                TreeNode nn = qu.remove();
                temp.add(nn.val);
                
                if(nn.left != null)qu.add(nn.left);
                if(nn.right != null)qu.add(nn.right);
            }
            
            ans.add(temp);
        }
        
        return ans;
    }
}