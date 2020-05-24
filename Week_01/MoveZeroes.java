/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-23 08:26
 * @description 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {
    /**
     * 1. 遍历数组
     * 2. 记录不为0的数字下标,每读一个非0数字, 将当前读的非0数字复制到下标中,然后下标+1
     * 3. 如果当前读下标和非0下标不相等(说明当前值已经被移动到非下标去了),那么当前下标值设置为0
     * <p>
     * time: O(n) , space: O(1)
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
