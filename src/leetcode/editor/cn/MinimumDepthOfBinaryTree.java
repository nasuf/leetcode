//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树


package leetcode.editor.cn;

import com.sun.org.apache.xerces.internal.dom.DeepNodeListImpl;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        solution.minDepth(root);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * DFS算法
         */
        /*public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            if (root.left == null)
                return minDepth(root.right) + 1;
            if (root.right == null)
                return minDepth(root.left) + 1;
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }*/

        /**
         * BFS算法
         *
         *        3
         *      9  20
         *        15 7
         */
        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int depth = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left == null && node.right == null) {
                        return depth;
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                depth++;
            }
            return depth;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}