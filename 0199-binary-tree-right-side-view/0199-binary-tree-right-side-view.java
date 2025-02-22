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
        List<Integer> result = new ArrayList<>();
        populateRightView(root, result, 0);
        return result;
    }

    private void populateRightView(TreeNode root, List<Integer> result, int level) {
        if(root == null)
            return;

        if(result.size() < level+1){
            result.add(root.val);
        }
        
        populateRightView(root.right, result, level+1);
        populateRightView(root.left, result, level+1);
    }
}