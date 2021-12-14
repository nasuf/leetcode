//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 100] 
// 0 <= Node.val <= 105 
// 
//
// 
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bs
//t/ 相同 
// 
// Ø
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 
// 👍 209 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int minDiffInBST(TreeNode root) {
            int min = Integer.MAX_VALUE;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (prev != null) {
                    min = Math.min(min, Math.abs(prev.val - root.val));
                }
                prev = root;
                root = root.right;
            }
            return min;
        }

        /*List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
            return list;
        }*/
    }
    //leetcode submit region end(Prohibit modification and deletion)

}