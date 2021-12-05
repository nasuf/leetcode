//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 244 👎 0


package leetcode.editor.cn;

public class CousinsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new CousinsInBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        TreeNode parent1 = null;
        TreeNode parent2 = null;
        int floor1 = 0;
        int floor2 = 0;
        boolean find1 = false;
        boolean find2 = false;

        //深度遍历查找x
        public void dfs(TreeNode root, TreeNode parent, int floor, int x1, int x2) {
            if (null == root) return;
            if (root.val == x1) {
                parent1 = parent;
                floor1 = floor;
                find1 = true;
            }
            if (root.val == x2) {
                parent2 = parent;
                floor2 = floor;
                find2 = true;
            }
            if (find1 && find2) return;
            dfs(root.left, root, floor + 1, x1, x2);
            dfs(root.right, root, floor + 1, x1, x2);
        }

        public boolean isCousins(TreeNode root, int x, int y) {
            dfs(root, null, 0, x, y);
            return floor1 == floor2 && parent1 != parent2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}