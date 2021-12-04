//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 844 👎 0


package leetcode.editor.cn;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(solution.diameterOfBinaryTree(root));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        int maxLength = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int length = maxDepth(root.left) + maxDepth(root.right);
                maxLength = Math.max(maxLength, length);
                diameterOfBinaryTree(root.left);
                diameterOfBinaryTree(root.right);
            }
            return maxLength;
        }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int leftDepth = maxDepth(root.left);
                int rightDepth = maxDepth(root.right);
                return Math.max(leftDepth, rightDepth) + 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}