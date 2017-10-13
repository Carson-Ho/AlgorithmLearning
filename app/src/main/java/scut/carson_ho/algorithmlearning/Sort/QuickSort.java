package scut.carson_ho.algorithmlearning.Sort;

/**
 * Created by Carson_Ho on 17/10/12.
 */

public class QuickSort {

    /**
     * 快速排序算法实现（基础实现）
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
     * 快速排序算法中寻找中间元素 实现(基础实现)
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
            int temp = srcArray[low];
            srcArray[low] = srcArray[high];
            srcArray[high] = temp;


            // 3. 将低位元素与中间元素对比
            // 若低位元素>中间元素，则将低位元素交换到高位；否则，则不需交换位置
            while (low < high && srcArray[low] <= tmp) {
                low++;
            }
            int temp1 = srcArray[high];
            srcArray[high] = srcArray[low];
            srcArray[low] = temp1;
        }

        // 最终返回枢纽位置
        return low;
    }


    /*************************************************/

    /**
     * 快速排序算法实现（优化 = 选取枢轴）
     * 参数说明：
     * @param srcArray = 需排序的数组序列
     * @param low = 数组第1个元素下标
     * @param high = 数组最后1个元素下标
     */
    public static void quickSort_MiddleOp(int[] srcArray, int low, int high) {

        if (low < high) {

            // 1. 将待排序列 分割成独立的2个子序列
            // 主要是找出中间元素的下标（主要优化在取中间值里）
            int middle = getMiddle_MiddleOp(srcArray, low, high);

            quickSort_MiddleOp(srcArray, low, middle - 1);
            quickSort_MiddleOp(srcArray, middle + 1, high);
        }


    }

    /**
     * 快速排序算法中寻找中间元素 实现（优化 = 选取枢轴）
     * 参数说明：
     * @param srcArray = 需排序的数组序列
     * @param low = 数组第1个元素下标
     * @param high = 数组最后1个元素下标
     */
    public static int getMiddle_MiddleOp(int[] srcArray, int low, int high) {

        // 计算序列中间元素的下标
        int m = low + (high - low) /2;

        // 比较左、右端数据元素，保证左端较小
        if(srcArray[low]>srcArray[high]) {

            // 若左>右，就交换位置
            int temp = srcArray[low];
            srcArray[low] = srcArray[high];
            srcArray[high] = temp;
        }

        // 比较中、右端数据元素，保证中端较小
        if(srcArray[m]>srcArray[high]) {
            // 若中>右，就交换位置
            int temp1 = srcArray[m];
            srcArray[m] = srcArray[high];
            srcArray[high] = temp1;
        }

        // 比较中、左端数据元素，保证左端较小
        if(srcArray[m]>srcArray[low]) {
            // 若中>左，就交换位置
            int temp2 = srcArray[m];
            srcArray[m] = srcArray[low];
            srcArray[low] = temp2;
        }

        // 此时，最低位 = srcArray[low] = 最低位、最高位 & 中间数中 的中间值
        // 将上述值作为枢纽
        int tmp = srcArray[low];
        System.out.println("枢轴位置 =" + srcArray[low]);

        // 其余类似未优化前（即，基础实现）
        while (low < high) {

            while (low < high && srcArray[high] >= tmp) {
                high--;
            }
            int temp = srcArray[low];
            srcArray[low] = srcArray[high];
            srcArray[high] = temp;

            while (low < high && srcArray[low] <= tmp) {
                low++;
            }
            int temp1 = srcArray[high];
            srcArray[high] = srcArray[low];
            srcArray[low] = temp1;
        }

        // 最终返回枢纽位置
        return low;
    }


    /*************************************************/


    /**
     * 快速排序算法实现（优化 = 减少不必要的交换）
     * 参数说明：
     * @param srcArray = 需排序的数组序列
     * @param low = 数组第1个元素下标
     * @param high = 数组最后1个元素下标
     */
    public static void quickSort_ChangeOp(int[] srcArray, int low, int high) {

        if (low < high) {

            // 1. 将待排序列 分割成独立的2个子序列
            // 主要是找出中间元素的下标（主要优化在取中间值里）
            int middle = getMiddle_ChangeOp(srcArray, low, high);

            quickSort_ChangeOp(srcArray, low, middle - 1);
            quickSort_ChangeOp(srcArray, middle + 1, high);
        }


    }

    /**
     * 快速排序算法中寻找中间元素 实现（优化 = 减少不必要的交换）
     * 参数说明：
     * @param srcArray = 需排序的数组序列
     * @param low = 数组第1个元素下标
     * @param high = 数组最后1个元素下标
     */
    public static int getMiddle_ChangeOp(int[] srcArray, int low, int high) {


        int tmp = srcArray[low];

        // 将枢轴元素备份
        int tmp1 = tmp;

        while (low < high) {

            while (low < high && srcArray[high] >= tmp) {
                high--;
            }
            // 采用 替换操作 换掉之前的 交换操作
            // int temp = srcArray[low];
            // srcArray[low] = srcArray[high];
            // srcArray[high] = temp;
            srcArray[low] = srcArray[high];


            while (low < high && srcArray[low] <= tmp) {
                low++;
            }

            // 采用 替换操作 换掉之前的 交换操作
            // int temp1 = srcArray[high];
            // srcArray[high] = srcArray[low];
            // srcArray[low] = temp1;
            srcArray[high] = srcArray[low];
        }
        // 将枢轴元素替换回中间位置
        srcArray[low] = tmp;

        // 最终返回枢纽位置
        return low;
    }

    /**
     * 执行 快速排序
     */
    public static void main(String[] args) {

        // 定义待排序数列
        int[] src = new int[]{ 50, 10, 90, 30, 70, 40, 80, 60, 20 };

        // 输出结果
        quickSort_MiddleOp(src,0,src.length-1);

        // 输出 排序后的序列
        for (int a = 0; a < src.length; a++) {
            System.out.println(src[a]);
        }

    }


}

