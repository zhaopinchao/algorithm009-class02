package sort;

/**
 * @author: zhaopc
 * @date: 2020-07-11 11:42
 * @description
 */
public interface BaseSort {
    int[] sort(int[] array);

    default void printSort(int[] array) {
        int[] result = sort(array);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
