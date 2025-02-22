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
        List<Integer> leftNodes = new ArrayList<>();
        populateLeftNodes(root, leftNodes, 0);
        if(leftNodes.size() != 0)
            return leftNodes.get(leftNodes.size()-1);
        return -1;
    }

    private void populateLeftNodes(TreeNode root, List<Integer> leftNodes, int level){
        if(root == null)
            return;

        if(leftNodes.size() < level+1)
            leftNodes.add(root.val); 

        populateLeftNodes(root.left, leftNodes, level+1);
        populateLeftNodes(root.right, leftNodes, level+1);
    }
}