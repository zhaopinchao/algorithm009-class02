/**
 * @author: zhaopc
 * @date: 2020-07-10 22:35
 * @description
 */
public class IsPowerOfTwo {
    /**
     * 2的幂次, 判断这个数字是否为2的幂次, 那么这个数字的二进制只有1个1,其余都是0
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
        System.out.println(isPowerOfTwo.isPowerOfTwo(10));
        System.out.println(isPowerOfTwo.isPowerOfTwo(9));
        System.out.println(isPowerOfTwo.isPowerOfTwo(8));
        System.out.println(isPowerOfTwo.isPowerOfTwo(16));
        System.out.println(isPowerOfTwo.isPowerOfTwo(32));
        System.out.println(isPowerOfTwo.isPowerOfTwo(-4));
    }
}
