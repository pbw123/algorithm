package main;

public class SortDemo {

    //快速排序
    static void quick_sort(int s[], int left, int right) {
        if (left < right) {
//            记录最初的左右指针
            int i = left, j = right;
            //把最左边的一个挖出来作为基准数，可以理解此时s[i]空出来了
            int pivot = s[left];
            while (i < j) {
                // 从右到左找到比基数小的数
                while (i < j && s[j] >= pivot) {
                    // 下标左移
                    j--;
                }
                if (i < j) {
                    // 走到这里说明找到小于基数的数，用s[j]把s[i]填上，s[j]就形成了一个新的坑
                    s[i] = s[j];
                    // 下次从左到右找到比基数大于或等于的数的时候从i的后一个开始找，因为此时s[i]已经小于基数了，不写就多比较了一次
                    i++;
                }
                // 从左到右找到比基数大于或等于的数
                while (i < j && s[i] < pivot) {
                    // 下标右移
                    i++;
                }
                if (i < j) {
                    // 走到这里说明找到大于或等于基数的数，用s[i]把s[j]填上，s[i]就形成了一个新的坑
                    s[j] = s[i];
                    //下次从右到左找到比基数小于的数的时候从j的前一个开始找，因为此时s[j]已经大于或等于基数了，不写就多比较了一次
                    j--;
                }

            }
//            走到这说明i=j，再用基准数把s[i]或s[j]填上
            s[i] = pivot;
//            对基准数的左右区间执行同样的操作
            quick_sort(s, left, i - 1);
            quick_sort(s, i + 1, right);
        }
    }

    //    冒泡排序
    public static void sort_m(int[] arr) {
//        N个数字要排序完成，总共进行N-1趟排序，第i趟的排序次数为(N-i)次
        int n = arr.length; // n个数字
        for (int i = 1; i < n; i++) { //或者写 i<=n-1 这样可能更好理解
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tem = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tem;
                }
            }
        }
    }

    //    插入排序
    public static void sort_insert(int[] arr) {

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {

            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }

        }

    }
    //    插入排序第二种写法
    public static void sort_insert2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tem = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tem;
                } else
                    break;
            }
        }
    }

    // 归并排序（Java-递归版）
    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }

    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, len - 1);
    }

    //选择排序
    public static void SelectionSort(int[] arr) {
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }

        }
    }
}

