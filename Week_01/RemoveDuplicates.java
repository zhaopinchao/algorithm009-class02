/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-22 20:47
 * <p>
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {

    /**
     * 1.数组已经是排好顺序的,重复的数字都是连续出现的
     * 2.记录上一次读的非常重复数字
     * 3.记录非重复数字的下标
     * 4.数组的长度就是非重复数字的下标+1
     * time: O(n) , space: O(1)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int value = nums[0];
        int index = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > value) {
                nums[index++] = nums[i];
                value = nums[i];
            }
        }
        return index;
    }

    /**
     * time: O(n) , space: O(1)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int index = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    /**
     * time: O(n) , space: O(1)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates3(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }

    /**
     * time: O(n) , space: O(1)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates4(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i == 0 || n > nums[i - 1]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicates r = new RemoveDuplicates();
        int[] nums = new int[]{0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = r.removeDuplicates4(nums);
        System.out.println("无重复长度: " + len);

        int[] nums1 = new int[]{};
        int len1 = r.removeDuplicates4(nums1);
        System.out.println("无重复长度: " + len1);
    }
}
