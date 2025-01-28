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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        else 
            return areSymmetric(root.left, root.right);
        
    }

    public boolean areSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;
        if((left == null && right != null) || (left != null && right == null) || (left.val != right.val))
            return false;            
        else {
            return areSymmetric(left.left, right.right) && areSymmetric(left.right, right.left);
        }      
    }
}