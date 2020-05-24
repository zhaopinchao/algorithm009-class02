import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-23 08:33
 * @description
 */
public class TwoSum {

    /**
     * 暴力解法, 双层遍历
     * time: O(n^2) , space: O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] res = new int[]{i, j};
                    return res;
                }
            }
        }
        return new int[0];
    }

    /**
     * hash表
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
