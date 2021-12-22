//给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值
//都不同。 
//
// 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [4,2,7,1,3], val = 5
//输出：[4,2,7,1,3,5]
//解释：另一个满足题目要求可以通过的树是：
//
// 
//
// 示例 2： 
//
// 
//输入：root = [40,20,60,10,30,50,70], val = 25
//输出：[40,20,60,10,30,50,70,null,null,25]
// 
//
// 示例 3： 
//
// 
//输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
//输出：[4,2,7,1,3,5]
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 给定的树上的节点数介于 0 和 10^4 之间 
// 每个节点都有一个唯一整数值，取值范围从 0 到 10^8 
// -10^8 <= val <= 10^8 
// 新值和原始二叉搜索树中的任意节点值都不同 
// 
// Related Topics 树 二叉搜索树 二叉树 
// 👍 246 👎 0


package leetcode.editor.cn;

public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new InsertIntoABinarySearchTree().new Solution();

        /**
         *      8
         *         55
         *       39
         *     11
         *       23
         */
        TreeNode root = new TreeNode(8);
        root.right = new TreeNode(55);
        root.right.left = new TreeNode(39);
        root.right.left.left = new TreeNode(11);
        root.right.left.left.right = new TreeNode(23);
        solution.insertIntoBST(root, 17);

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 迭代算法
         */
        /*public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            TreeNode pos = root;
            while (pos != null) {
                if (val < pos.val) {
                    if (pos.left == null) {
                        pos.left = new TreeNode(val);
                        break;
                    } else {
                        pos = pos.left;
                    }
                } else {
                    if (pos.right == null) {
                        pos.right = new TreeNode(val);
                        break;
                    } else {
                        pos = pos.right;
                    }
                }
            }
            return root;
        }*/

        /**
         * 递归算法
         */
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            if (val < root.val) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}