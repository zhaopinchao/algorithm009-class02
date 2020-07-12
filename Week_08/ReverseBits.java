/**
 * @author: zhaopc
 * @date: 2020-07-10 22:51
 * @description
 */
public class ReverseBits {

    public int reverseBits(int n) {
        // int result = 0;
        // for (int i = 0; i < 32; i++) {
        //    result |= (((n >> i) & 1) << (31 - i));
        // }
        // return result;
        int result = 0, temp;
        for (int i = 31; i >= 0; i--) {
            temp = n & 1;
            n = n >> 1;
            result |= (temp << i);
        }
        return result;
    }
}
