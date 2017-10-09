package scut.carson_ho.algorithmlearning.Sort;

/**
 * Created by Carson_Ho on 17/10/9.
 */

public class ChooseSort {

    /**
     * 简单选择排序
     */
    public static void chooseSort(int[] srcArray) {

        int i; // 用于存放当前数组下标
        int j; // 用于存放需要比较记录的下标

            for(i=0;i<srcArray.length;i++){

                // 将当前记录 与 后面记录进行比较
                for(j=i+1;j<srcArray.length;j++){

                    // 若 当前记录 < 后面记录，则交换位置
                    if(srcArray[i] > srcArray[j]){
                        int temp=srcArray [i];
                        srcArray[i] = srcArray[j];
                        srcArray[j] = temp;
                    }
                }
            }


        // 输出排序后的序列
        for(int a =0;a<srcArray.length;a++)
            System.out.println(srcArray[a]);
    }



    /**
     * 执行 简单选择排序
     */
    public static void main(String[] args) {

        // 定义待排序数列
        int[] src = new int[]{9, 1, 5, 8, 3, 7, 4, 2, 6};

        // 输出结果
        chooseSort(src);

    }

}
