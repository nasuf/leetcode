////We are playing the Guess Game. The game is as follows: 
////
//// I pick a number from 1 to n. You have to guess which number I picked. 
////
//// Every time you guess wrong, I will tell you whether the number I picked is 
////higher or lower than your guess. 
////
//// You call a pre-defined API int guess(int num), which returns three possible 
////results: 
////
//// 
//// -1: Your guess is higher than the number I picked (i.e. num > pick). 
//// 1: Your guess is lower than the number I picked (i.e. num < pick). 
//// 0: your guess is equal to the number I picked (i.e. num == pick). 
//// 
////
//// Return the number that I picked. 
////
//// 
//// Example 1: 
////
//// 
////Input: n = 10, pick = 6
////Output: 6
//// 
////
//// Example 2: 
////
//// 
////Input: n = 1, pick = 1
////Output: 1
//// 
////
//// Example 3: 
////
//// 
////Input: n = 2, pick = 1
////Output: 1
//// 
////
//// 
//// Constraints: 
////
//// 
//// 1 <= n <= 2³¹ - 1 
//// 1 <= pick <= n 
//// 
//// Related Topics 二分查找 交互 👍 189 👎 0
//
package leetcode.editor.cn;

public class GuessNumberHigherOrLower {
    public static void main(String[] args) {
        Solution solution = new GuessNumberHigherOrLower().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Forward declaration of guess API.
     *
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     * int guess(int num);
     */

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int low = 1, high = n;
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (guess(mid) <= 0) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

class GuessGame {
    int guess(int a) {
        return 0;
    }
}