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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        if(root ==null)return arr;
        qu.add(root);
        while(qu.size()>0){
            int size = qu.size();
            while(size-->1){
                TreeNode nn = qu.remove();
                if(nn.left != null)qu.add(nn.left);
                if(nn.right != null)qu.add(nn.right);
            }
            
                TreeNode nn = qu.remove();
                if(nn.left != null)qu.add(nn.left);
                if(nn.right != null)qu.add(nn.right);
                arr.add(nn.val);
        }
        
        return arr;
        
    }
}