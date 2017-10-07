package scut.carson_ho.algorithmlearning.Search;

/**
 * Created by Carson_Ho on 17/10/7.
 */

public class BinarySearch {

    /**
     * 二分查找方法
     *  @param srcArray：有序数组
     * @param des：需要查找的元素
     */
    public static int binarySearch(int[] srcArray, int des){

        int low = 0; // 比较区间第1位
        int high = srcArray.length-1; // 比较区间最后1位
        int middle ; // 区间的中间位置


        while(low <= high) {

            // 1. 通过折半，求出区间的中间位置
            middle = (low + high)/2;

            // 2. 比较给定值和中间值
                // 2.1 若给定值 = 中间记录，则查找成功，返回该位置
            if(des == srcArray[middle]) {
                return middle;

                // 2.2 若给定值 ＜ 中间记录，则 在中间记录的左半区 继续查找
                // 即 将比较区间的最后1位 设置为 原中间位置的前1位
            }else if(des <srcArray[middle]) {
                high = middle - 1;

                // 2.3 若给定值 ＞ 中间记录，则 在中间记录的右半区 继续查找
                // 即 将比较区间的首位 设置为原中间位置的后1位
            }else {
                low = middle + 1;
            }
        }
        // 若比较区间的第1位 ≥ 最后1位，则表示查找失败，返回-1
        return -1;
    }


    /**
     * 执行 二分查找方法
     */
    public static void main(String[] args) {

        // 定义1个有序表数组
        int[] src = new int[]{1, 4, 5, 7, 8, 13,20,28};
        // 输出结果
        System.out.println("需要查找数据的数组下标 = " + binarySearch(src,8));

    }

}
