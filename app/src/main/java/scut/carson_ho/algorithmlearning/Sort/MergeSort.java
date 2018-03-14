package scut.carson_ho.algorithmlearning.Sort;

/**
 * Created by Carson_Ho on 17/10/12.
 */

public class MergeSort {

    /**
     * 归并排序算法实现：非递归
     * 参数说明：
     * @param arr = 需排序的数组序列
     */

    public static void mergeSort1(int[] arr) {

        int len = arr.length;
        int k = 1;

        while(k < len)
        {
            MergePass(arr, k, len);
            k *= 2; // 一组组归并：1、2、4、8、16
        }

    }

    /**
     * 辅助算法
     * 作用：归并 数组中的相邻长度 = k的元素
     */

    private static void MergePass(int[] arr, int k, int n)
    {
        int i = 0;
        int j;

        // 从前->后,将2个长度为k的子序列合并为1个
        while(i < n - 2*k + 1)
        {
            merge(arr, i, i + k-1, i + 2*k - 1);
            // 参数2 = 距离长度
            // 参数3、4 = 合并的位置，如合并第1个 & 第2个位置的元素到新建的数组中
            i += 2*k;
        }

        // 该代码的作用：保证将最后“落单”的、长度不足两两合并的部分 和 前面的合并起来
        if(i < n - k )
        {
            merge(arr, i, i+k-1, n-1);
        }

    }

    /**
     * 归并排序算法实现：递归
     * 参数说明：
     * @param arr = 需排序的数组序列
     * @param low = 数组第1个元素下标
     * @param high = 数组最后1个元素下标
     */

    public static void mergeSort(int[] arr, int low, int high) {
        // 1. 计算出序列中间元素下标
        int mid = (low + high) / 2;

        if (low < high) {
            // 2. （分治思想） 将初始序列 逐步对半划分成半子表，直到初始序列 = n个子序列
            // 通过 递归 实现
              // a. 左一半（第1个元素 - 中间元素）
              mergeSort(arr, low, mid);
              // b. 右一半（ 中间元素后1位 - 最后1个元素）
              mergeSort(arr, mid + 1, high);

            // 3. 将划分的子序列 有序的两两合并,最终合并成1个长度 = n 的有序序列
            merge(arr, low, mid, high);


        }

    }

    /**
     * 归并排序算法中的有序合并序列 实现
     * 参数说明：
     * @param arr = 需排序的数组序列
     * @param low = 数组第1个元素 下标
     * @param mid = 数组中间元素 下标
     * @param high = 数组最后1个元素 下标
     */

    public static void merge(int[] arr, int low, int mid, int high) {

        // 辅助数组 = 暂存合并的结果
        int[] temp = new int[high - low + 1];

        int i = low; // 左指针
        int j = mid + 1; // 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 把右边剩余的数移入数组
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + low] = temp[k2];
        }
    }

    /**
     * 执行 归并排序算法

     */
    public static void main(String[] args) {
        // 待排序序列
        int arr[] = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };

        // 执行 归并排序序列
        mergeSort(arr, 0, arr.length - 1);

        // 输出排序后的序列
        for(int a =0;a<arr.length;a++)
            System.out.println(arr[a]);

    }


}
