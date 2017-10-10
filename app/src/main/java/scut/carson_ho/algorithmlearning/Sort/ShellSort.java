package scut.carson_ho.algorithmlearning.Sort;

/**
 * Created by Carson_Ho on 17/10/10.
 */

public class ShellSort {
    /**
     * 希尔排序
     */
    public static void shellSort(int[] srcArray) {

        int j = 0;
        int temp = 0;

        // 增量序列值 计算公式 = 前1个增量序列值 / 2，直到增量序列值 = 1为止
        // 第1个值 = 初始值 = 序列长度 / 2
        for (int increment = srcArray.length / 2; increment > 0; increment /= 2) {

            // 根据增量值选取子序列
            for (int i = increment; i < srcArray.length; i++) {

                temp = srcArray[i];

                // 对子序列执行直接插入排序，即 循环两两比较子序列的值
                for (j = i - increment; j >= 0; j -= increment) {

                    if (temp < srcArray[j]) {

                        // 将小的元素放到前面、大的元素放到后面
                        srcArray[j + increment] = srcArray[j];
                    } else {
                        break;
                    }
                }
                srcArray[j + increment] = temp;
            }


            // 输出 根据增量值排序后的序列
            System.out.println("增量值为:" + increment + "，排序结果如下：");
            for (int a = 0; a < srcArray.length; a++) {
                System.out.println(srcArray[a]);
            }
        }
    }

    /**
     * 执行 希尔排序
     */
    public static void main(String[] args) {

        // 定义待排序数列
        int[] src = new int[]{ 4, 3, 6, 2, 7, 1, 5, 8 };

        // 输出结果
        shellSort(src);

    }

}
