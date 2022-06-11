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
class BSTIterator {

    TreeNode root = null;
    public BSTIterator(TreeNode root) {
        this.root = root;
    }
    
    public int next() {
        int val = -1;
        while(this.root != null){
            if(this.root.left == null){
                val = this.root.val;
                this.root = this.root.right;
                break;
            }else{
                TreeNode rightNode = rightMostNode(this.root, this.root.left);
                if(rightNode.right == null){
                    rightNode.right = this.root;
                    this.root = this.root.left;
                }else{
                    val = this.root.val;
                    rightNode.right = null;
                    this.root = this.root.right;
                    break;
                        
                }
            }
            
        }
        return val;
        
    }
    
    public boolean hasNext() {
        return root != null;
    }
    
    private TreeNode rightMostNode(TreeNode curr, TreeNode root){
        while(root.right != null && root.right != curr)root = root.right;
        return root;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */