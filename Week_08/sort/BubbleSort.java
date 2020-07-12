package sort;
/**
 * @author: zhaopc
 * @date: 2020-07-11 10:00
 * @description 冒泡排序, 双层for循环, array[i] > array[i-1], swap
 */
public class BubbleSort implements BaseSort {

    @Override
    public int[] sort(int[] array) {
        if(array.length == 0) return array;
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0, 9, 2, 3, 5, 6};
        new BubbleSort().printSort(array);
    }
}
