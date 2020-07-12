package sort;

/**
 * @author: zhaopc
 * @date: 2020-07-11 10:14
 * @description 选择排序, 每次从未排序的数组中找出最小值, 移动到前面
 */
public class SelectionSort implements BaseSort{

    @Override
    public int[] sort(int[] array) {
        if (array.length == 0) return array;
        int minIndex, temp;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 7, 0, 6, 7, 9, 2, 3, 5, 6, 6, 7};
        new SelectionSort().printSort(array);
    }
}
