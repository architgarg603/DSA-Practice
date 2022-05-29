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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        TreeNode ans = root;
        
        while(qu.size()>0){
            int size = qu.size();
            ans = qu.peek();
            for(int i=0;i<size;i++){
                TreeNode temp = qu.remove();
                
                if(temp.left != null)qu.add(temp.left);
                if(temp.right != null)qu.add(temp.right);
                
            }
        }
        
        return ans.val;
    }
}