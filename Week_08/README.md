学习笔记

### 位运算

#### 1、位运算符

| 含义                           | 运算符 | 示例                   |
| ------------------------------ | ------ | ---------------------- |
| 左移                           | <<     | 0011 << 1    => 0110   |
| 右移                           | >>     | 0110 >> 1    => 0011   |
| 按位或                         | \|     | 0011 \| 1011    =>1011 |
| 按位与                         | &      | 0011 & 1011    => 0011 |
| 按位取反                       | ~      | 1011 ~    => 0100      |
| 按位异或（相同取0，不相同取1） | ^      | 0011 ^ 1011    => 1000 |

##### XOR-异或

异或：相同为0， 不同为1.也可用”不仅为加法“来理解。

异或操作的一些特点：

X ^ 0 = x

X ^ 1s = ~x // 1s 表示全部是1， 1s = ~0

X ^ (~X) = 1s

X ^ X = 0

c = a ^ b => a ^ c = b, b ^ c = a //交换两个数

a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c //associative

##### 指定位置的位运算

1. 将x最右边的n位清零：x & (~0 << n)

2. 获取x的第n位值(0或者1): (x >> n) & 1

3. 获取x的第n位的幂值: x & (1 << n)

4. 仅将第n位置为1: x | (1 << n)

5. 仅将第n位置为0： x & (~(1 << nx))

6. 将x最高位至第n位(含)清零: x & ((1 << n) -1)

##### 实战位运算要点

- 判断奇偶：x % 2 == 1   =>  (x & 1) == 1   x % 2 == 0  => (x & 1) == 0

- x >> 1 =>  x/2

  即： x = x / 2  =>  x = x >> 1;

  ​		 mid = (left + right) / 2; => mid = (left + right) >> 1   => mid = left + (right - left) >> 1

- x = x & (x -1) 清零最低位的1

- x & -x => 得到最低位的 1  （最低位置的1， 不是最后一位数）

- x & ~x => 0

### 排序

#### 冒泡排序

```
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
```

#### 选择排序

```
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
```

#### 插入排序

```
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
```

#### 归并排序

```
public void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}

public void merge(int[] arr, int left, int mid, int right) {
		int[] temp = new int[right - left + 1]; // 中间数组
		int i = left, j = mid + 1, k = 0;

		while (i <= mid && j <= right) {
				temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}

		while (i <= mid)   temp[k++] = arr[i++];
		while (j <= right) temp[k++] = arr[j++];

		for (int p = 0; p < temp.length; p++) {
				arr[left + p] = temp[p];
    }
}
```

#### 快速排序

```
public void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);
}
private int partition(int[] a, int begin, int end) {
    // pivot: 标杆位置，counter: 小于pivot的元素的个数
    int pivot = end, counter = begin;
    for (int i = begin; i < end; i++) {
        if (a[i] < a[pivot]) {
            int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
            counter++;
        }
    }
    int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
    return counter;
}
```

#### 堆排序

```
private void heapify(int[] array, int length, int i) {
    int left = 2 * i + 1, right = 2 * i + 2；
    int largest = i;
    if (left < length && array[left] > array[largest]) {
        largest = left;
    }
    if (right < length && array[right] > array[largest]) {
        largest = right;
    }
    if (largest != i) {
        int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
        heapify(array, length, largest);
    }
}
public void heapSort(int[] array) {
    if (array.length == 0) return;
    int length = array.length;
    for (int i = length / 2-1; i >= 0; i-) 
        heapify(array, length, i);
    for (int i = length - 1; i >= 0; i--) {
        int temp = array[0]; array[0] = array[i]; array[i] = temp;
        heapify(array, i, 0);
    }
}
```

