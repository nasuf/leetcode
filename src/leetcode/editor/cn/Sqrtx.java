//<p>Given a non-negative integer <code>x</code>,&nbsp;compute and return <em>the square root of</em> <code>x</code>.</p>
//
//<p>Since the return type&nbsp;is an integer, the decimal digits are <strong>truncated</strong>, and only <strong>the integer part</strong> of the result&nbsp;is returned.</p>
//
//<p><strong>Note:&nbsp;</strong>You are not allowed to use any built-in exponent function or operator, such as <code>pow(x, 0.5)</code> or&nbsp;<code>x ** 0.5</code>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> x = 4
//<strong>Output:</strong> 2
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> x = 8
//<strong>Output:</strong> 2
//<strong>Explanation:</strong> The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>0 &lt;= x &lt;= 2<sup>31</sup> - 1</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数学</li><li>二分查找</li></div></div><br><div><li>👍 956</li><li>👎 0</li></div>
package leetcode.editor.cn;

public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int low = 1, high = x;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                long square = (long) mid * mid;
                if (square == x) {
                    return mid;
                } else if (square > x) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // low > high now
            return (int) Math.floor(high);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}