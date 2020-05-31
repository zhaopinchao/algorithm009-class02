/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-30 22:40
 * @description
 */
public class NthUglyNumber {


    /**
     * 动态规划问题
     * 1.我们将前面求得的丑数记录下来，后面的丑数就是前面的丑数*2，*3，*5
     * 2.但是问题来了，我怎么确定已知前面k-1个丑数，我怎么确定第k个丑数呢
     * 3.采取用三个指针的方法，p2,p3,p5
     * 4.index2指向的数字下一次永远*2，p3指向的数字下一次永远*3，p5指向的数字永远*5
     * 5.我们从2*p2 3*p3 5*p5选取最小的一个数字，作为第k个丑数
     * 6.如果第K个丑数==2*p2，也就是说前面0-p2个丑数*2不可能产生比第K个丑数更大的丑数了，所以p2++
     * 7.p3,p5同理
     * 8.返回第n个丑数
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
