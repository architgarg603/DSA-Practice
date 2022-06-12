/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        solve(root,sb);
        return sb.toString().trim();
    }
    
    public void solve(TreeNode root, StringBuilder sb){
        if(root == null)return;
        
        sb.append(root.val+" ");
        
        solve(root.left, sb);
        solve(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(" ");
        return convert(str,Integer.MIN_VALUE,Integer.MAX_VALUE, new int[1]);
    }
    
    public TreeNode convert(String[] str, int min, int max, int[] idx){
        if(idx[0] >= str.length)return null;
        if(str[idx[0]].equals(""))return null;
        TreeNode root = new TreeNode(Integer.parseInt(str[idx[0]++]));
        
        if(idx[0] >= str.length)return root;
        int val = Integer.parseInt(str[idx[0]]);
        if(val>min && val <root.val)root.left = convert(str,min,root.val,idx);
        
        if(idx[0] >= str.length)return root;
        val = Integer.parseInt(str[idx[0]]);
        if(val>root.val && val <max)root.right = convert(str,root.val,max,idx);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;