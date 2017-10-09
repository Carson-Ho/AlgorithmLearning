package scut.carson_ho.algorithmlearning.Sort;

/**
 * Created by Carson_Ho on 17/10/9.
 */

public class BubbleSort {

    /**
     * 基本的 冒泡排序
     */
    public static void bubbleSort(int[] srcArray) {

        int i,j; // 用于存放数组下标
        int temp = 0; // 用于交换数值时临时存放值

        for(i=0;i<srcArray.length-1;i++){

            // j 从后往前循环
            for(j=srcArray.length-2;j>=i;j--){

                // 若前者＞后者，则交换位置
                if(srcArray[j]>srcArray[j+1]){

                    temp=srcArray[j];
                    srcArray[j]=srcArray[j+1];
                    srcArray[j+1]=temp;
                }
            }
        }

        // 输出排序后的序列
        for(int a =0;a<srcArray.length;a++)
            System.out.println(srcArray[a]);
    }


    /**
     * 优化的 冒泡排序
     */
    public static void bubbleSortOpti(int[] srcArray) {

        int i,j; // 用于存放数组下标
        int temp = 0; // 用于交换数值时临时存放值

        // 标记位
        // flag = true：代表存在数据交换，即序列仍需排序，需继续循环
        // flag = false：代表不存在数据交换，即序列不需排序，已经是有序序列了，可停止循环
        Boolean flag = true;

        // 若flag = false时退出循环
        for(i=0;i<srcArray.length-1 && flag;i++){

            flag = false; // 初始化为false

            // j 从后往前循环
            for(j=srcArray.length-2;j>=i;j--){

                // 若前者＞后者，则交换位置
                if(srcArray[j]>srcArray[j+1]){

                    temp=srcArray[j];
                    srcArray[j]=srcArray[j+1];
                    srcArray[j+1]=temp;
                    flag = true; // 若有数据交换，则说明序列仍未无序
                }
            }
        }

        // 输出排序后的序列
        for(int a =0;a<srcArray.length;a++)
            System.out.println(srcArray[a]);
    }



    /**
     * 执行 冒泡排序
     */
    public static void main(String[] args) {

//        // 定义待排序数列
//        int[] src = new int[]{9, 1, 5, 8, 3, 7, 4, 2, 6};

        // 定义待排序数列
        int[] src = new int[]{2, 1, 3, 4, 5, 6, 7, 8, 9};

        // 输出结果
        bubbleSortOpti(src);

    }

}
