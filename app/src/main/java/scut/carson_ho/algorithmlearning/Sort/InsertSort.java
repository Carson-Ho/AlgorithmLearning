package scut.carson_ho.algorithmlearning.Sort;

/**
 * Created by Carson_Ho on 17/10/9.
 */

public class InsertSort {
    /**
     * 简单选择排序
     */
    public static void insertSort(int[] srcArray) {

        int i; // 用于存放当前插入数据记录的数组下标
        int j; // 用于存放需要比较记录的下标
        int temp; // 用于交换数据

        // 从第1个数据记录 开始，该元素可以认为已经被排序
        for(i = 0 ; i < srcArray.length ; i++)
            {
                temp = srcArray[i];

                // 取出下一个数据记录，在已经排序的序列中从后向前扫描
                // 将 当前数据记录 与 前面排序好的值进行比较
                for(j = i ; j > 0 && temp < srcArray[j-1] ; j --)
                {
                    // 按照顺序小 -> 大 将 当前需要插入的数据记录插入到合适位置 = 后移已排序好的元素 + 插入新的数据记录
                     // a. 后移已排序好的元素
                    srcArray[j] = srcArray[j-1];
                }

                // 插入新的数据记录
                srcArray[j] = temp;
            }


        // 输出排序后的序列
        for(int a =0;a<srcArray.length;a++)
            System.out.println(srcArray[a]);
    }

    /**
     * 执行 直接插入排序
     */
    public static void main(String[] args) {

        // 定义待排序数列
        int[] src = new int[]{0, 5, 3, 4, 6, 2};

        // 输出结果
        insertSort(src);

    }

}
