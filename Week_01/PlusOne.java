/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-23 07:59
 * <p>
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [4,3,2,9]
 * 输出: [4,3,3,0]
 * 解释: 输入数组表示数字 4329。
 */
public class PlusOne {

    /**
     * 1.首先判断末尾+1是不是=10, 如果等于10, 那么末尾设置为0,然后倒数第二个数+1, 一次类推, 如果数组所有数字+1都=10, 那么新建len+1的数组,第0个地址设置为1即可
     * 2.如果末尾+1 != 10 , 那么直接末尾+1 返回数组即可
     * 3.空数组, 需要新建一个len为1的数组,第0个值设置为1
     * time: O(n) , space: O(1)
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0) {
            int[] res = new int[len + 1];
            res[0] = 1;
            return res;
        }
        int i = len - 1;
        while (i >= 0) {
            if (digits[i] + 1 == 10) {
                digits[i] = 0;
                if (i == 0) {
                    int[] res = new int[len + 1];
                    res[0] = 1;
                    return res;
                }
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
            i--;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = new int[]{9, 9};
        int[] res = plusOne.plusOne(digits);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + "  ");
        }
    }
}
