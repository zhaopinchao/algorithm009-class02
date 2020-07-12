/**
 * @author: zhaopc
 * @date: 2020-07-10 22:29
 * @description
 */
public class NumberOf1Bits {

    /**
     * 每次打掉最后的0
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int result = 0;
        while (n > 0) {
            n &= (n - 1);
            result++;
        }
        return result;
    }
}
