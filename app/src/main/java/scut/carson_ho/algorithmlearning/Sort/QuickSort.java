package scut.carson_ho.algorithmlearning.Sort;

/**
 * Created by Carson_Ho on 17/10/12.
 */

public class QuickSort {

    /**
     * 快速排序算法实现
     * 参数说明：
     * @param srcArray = 需排序的数组序列
     * @param low = 数组第1个元素下标
     * @param high = 数组最后1个元素下标
     */
    public static void quickSort(int[] srcArray, int low, int high) {

        if (low < high) {

            // 1. 将待排序列 分割成独立的2个子序列
            // 主要是找出中间元素的下标
            int middle = getMiddle(srcArray, low, high);

            // 2. 分别对这2个子序列 进行排序
             // a. 通过递归 对低字表进行排序
            quickSort(srcArray, low, middle - 1);
             // b. 通过递归 对高字表进行排序
            quickSort(srcArray, middle + 1, high);
        }


    }

    /**
     * 快速排序算法中寻找中间元素 实现
     * 参数说明：
     * @param srcArray = 需排序的数组序列
     * @param low = 数组第1个元素下标
     * @param high = 数组最后1个元素下标
     */
    public static int getMiddle(int[] srcArray, int low, int high) {

        // 1. 将子表的第1个个记录作为枢纽
        int tmp = srcArray[low];

        while (low < high) {

            // 2. 将高位元素与中间元素对比
             // 若高位元素<中间元素，则将高位元素交换到低位；否则，则不需交换位置
            while (low < high && srcArray[high] >= tmp) {
                high--;
            }
            srcArray[low] = srcArray[high];

            // 3. 将低位元素与中间元素对比
            // 若低位元素>中间元素，则将低位元素交换到高位；否则，则不需交换位置
            while (low < high && srcArray[low] <= tmp) {
                low++;
            }
            srcArray[high] = srcArray[low];
        }
        srcArray[low] = tmp;

        // 最终返回枢纽位置
        return low;
    }


    /**
     * 执行 快速排序
     */
    public static void main(String[] args) {

        // 定义待排序数列
        int[] src = new int[]{ 4, 3, 6, 2, 7, 1, 5, 8 };

        // 输出结果
        quickSort(src,0,src.length-1);

        // 输出 排序后的序列
        for (int a = 0; a < src.length; a++) {
            System.out.println(src[a]);
        }

    }


}

