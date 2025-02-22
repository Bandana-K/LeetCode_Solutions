//COPIED

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
    int idx = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        return recoverFromPreorder(traversal, -1);
    }

    private TreeNode recoverFromPreorder(String traversal, int parentDepth) {
        if(idx == traversal.length()) return null;

        var dn = getDepthNum(traversal, idx);
        int depth = dn[0], num = dn[1];
        if(parentDepth >= depth) return null;

        idx = dn[2];
        var node = new TreeNode(num);
        node.left = recoverFromPreorder(traversal, depth);
        node.right = recoverFromPreorder(traversal, depth);
        return node;
    }

    private int[] getDepthNum(String traversal, int idx){
        var depth = 0;
        while(idx + depth < traversal.length() && traversal.charAt(idx + depth) == '-')
            depth++;

        int numStart = idx + depth, numEnd = numStart;
        while(numEnd < traversal.length() && traversal.charAt(numEnd) != '-')
            numEnd++;

        var num = Integer.parseInt(traversal.substring(numStart, numEnd));
        return new int[] { depth, num, numEnd };
    }
}


// class Solution {
//     public TreeNode recoverFromPreorder(String traversal) {
//         if(traversal == null)  return null;
        
//         Map<Integer, List<TreeNode>> sameLevelNodes = new HashMap<>();
//         StringBuilder currentNum = new StringBuilder();
//         currentNum.append(traversal.charAt(0));
//         int level = 0;

//         for(int i = 1; i < traversal.length(); i++){
//             if(traversal.charAt(i) == '-'){
//                 if(traversal.charAt(i-1) == '-') {
//                     level++;
//                 }
//                 else{
//                     sameLevelNodes.putIfAbsent(level, new ArrayList<>());
//                     sameLevelNodes.get(level).add(new TreeNode(Integer.parseInt(currentNum.toString())));
//                     currentNum = new StringBuilder(); 
//                     level = 1;
//                 }
//             } else {
//                     currentNum.append(traversal.charAt(i));
//             }
//         }

//         sameLevelNodes.putIfAbsent(level, new ArrayList<>());
//         sameLevelNodes.get(level).add(new TreeNode(Integer.parseInt(currentNum.toString())));

//         for(Map.Entry<Integer, List<TreeNode>> entry : sameLevelNodes.entrySet()){
//             System.out.print("For level = " + entry.getKey() + " Nodes are = ");
//             for(var node: entry.getValue()){
//                 System.out.print(node.val + " , ");
//             }
//             System.out.println();
//         }

//         return null;
//     }
// }