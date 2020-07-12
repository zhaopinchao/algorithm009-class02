package sort;

/**
 * @author: zhaopc
 * @date: 2020-07-11 11:12
 * @description 插入排序. 未排序的数字,往已排序的数组里面插入. 默认array[0]是已经排好序的
 */
public class InsertionSort implements BaseSort {

//    public int[] sort(int[] array) {
//        if (array.length == 0) return array;
//        for (int i = 1; i < array.length; i++) {
//            int preIdx = i, curIdx = i, temp;
//            while (preIdx-- > 0 && array[curIdx] < array[preIdx]) {
//                temp = array[preIdx];
//                array[preIdx] = array[curIdx];
//                array[curIdx] = temp;
//                curIdx = preIdx;
//            }
//        }
//        return array;
//    }


    @Override
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int preIdx = i - 1, curr = array[i];
            while (preIdx >= 0 && curr < array[preIdx]) {
                array[preIdx + 1] = array[preIdx];
                preIdx--;
            }
            array[preIdx + 1] = curr;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 7, 0, 6, 7, 9, 2, 3, 5, 6, 6, 7};
        new InsertionSort().printSort(array);
    }
}
