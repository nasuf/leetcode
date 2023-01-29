package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Calculator {
    public static void main(String[] args) {
        System.out.println(new Calculator().distinctIntegers(3));
    }
    public int distinctIntegers(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 1) {
                    set.add(j);
                }
            }
        }
        return set.size();
    }
}
