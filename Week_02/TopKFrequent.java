import java.util.*;

/**
 * @author: zhaopc
 * @date: 2020-05-31 10:30
 * @description
 */
public class TopKFrequent {

    /**
     * hash表 + 堆
     * 先用hash表,将数组中的数字和频次存起来
     * 然后放入优先级队列(二叉堆)中
     * 最后依次从优先级队列中poll k个元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Help> queue = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Help help = new Help();
            help.key = entry.getKey();
            help.frequent = entry.getValue();
            queue.add(help);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(queue.poll()).key;
        }
        return result;
    }


    private static class Help implements Comparable<Help> {
        private int key;
        private int frequent;

        @Override
        public int compareTo(Help o) {
            return (this.frequent > o.frequent) ? -1 : ((this.frequent == o.frequent) ? 0 : 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] result = topKFrequent.topKFrequent(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "  ");
        }
    }
}
