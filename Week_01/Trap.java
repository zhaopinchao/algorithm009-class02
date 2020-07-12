/**
 * @author: zhaopc
 * @date: 2020-05-23 22:22
 * @description 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {

    /**
     * 暴力
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            //Search the left part for max bar size
            for (int j = i; j >= 0; j--) {
                max_left = max(max_left, height[j]);
            }
            //Search the right part for max bar size
            for (int j = i; j < size; j++) {
                max_right = max(max_right, height[j]);
            }
            ans += min(max_left, max_right) - height[i];
        }
        return ans;
    }

    /**
     * 双指针
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            //如果左边的柱子比右边高, 那么右边移动
            if (height[left] > height[right]) {
                //如果当前柱子比右边最大的柱子小,那么形成低洼积水,计算该柱子的存水值,反之更新右边最大值
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            } else {
                //如果当前柱子比左边最大的柱子小, \那么形成低洼积水,计算存水值,反之更新左边最大值
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            }
        }
        return res;
    }

    private int min(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }


    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] nums = new int[]{2, 1, 0, 2};
        System.out.println(trap.trap1(nums));
        int[] nums1 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap.trap1(nums1));
        int[] nums2 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap.trap1(nums2));
        int[] nums3 = new int[]{1, 4, 1, 3, 4, 6, 1, 32, 54, 7, 23, 45};
        System.out.println(trap.trap1(nums3));
        int[] nums4 = new int[]{1, 4, 1, 3, 4, 6, 1, 32, 54, 7, 23, 45, 90};
        System.out.println(trap.trap1(nums4));
    }
}


