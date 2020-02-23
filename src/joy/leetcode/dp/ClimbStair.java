package joy.leetcode.dp;
/*
* https://leetcode.com/problems/climbing-stairs/
* 解说：https://blog.csdn.net/My_Jobs/article/details/43535179
* 把问题转化为了斐波那契数列的问题
* */
public class ClimbStair {
    public static int climbStairs1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    public static int climbStair2(int n) {
        // 很明显，演变成斐波那契数列了， 最终结果只依赖与最后的两个值，所以没必要把整个数组记下来。
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] r = new int[n + 1];
        r[1] = 1;
        r[2] = 2;
        for (int i = 3; i <= n; i++) {
            r[i] = r[i - 1] + r[i - 2];
        }
        return r[n];
    }
}
