package scut.carson_ho.algorithmlearning.Sort;

/**
 * Created by Carson_Ho on 17/10/12.
 */

public class HeapSort {


    /**
     * 执行 堆排序 算法
     */
    public static void main(String[] args) {

        // 定义待排序数列
        int[] src = new int[]{ 50, 10, 90, 30, 70, 40, 80, 60, 20 };

        // 输出结果
        heapSort(src);

    }


    /**
     * 堆排序算法
     */
    private static void heapSort(int[] arr) {
        // 步骤1：将待排序的序列构建成一个大顶堆
        for (int i = arr.length / 2; i >= 0; i--){
            // i = i / 2 ：求出非终端结点（即，具备孩子的结点）
            // 逐渐递减： i = 4-3-2-1
            heapAdjust(arr, i, arr.length);
        }


        for (int i = arr.length - 1; i > 0; i--) {
            // 步骤2：交换 根节点 与 末尾元素
            swap(arr, 0, i);
            // 步骤3：将序列剩余的（n-1）个记录重新构造成大顶堆
            heapAdjust(arr, 0, i);

            // 循环步骤2 、3，直到整个序列有序
        }

        // 输出排序后的序列
        for(int a =0;a<arr.length;a++)
            System.out.println(arr[a]);

    }

    /**
     * 构建堆的过程
     * 参数说明：
     * @param arr = 需排序的数组
     * @param i = 需要构建堆的根节点的序号
     * @param n = 数组的长度
     */
    private static void heapAdjust(int[] arr, int i, int n) {
        int child;
        int father;
        for (father = arr[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);

            // 找出子树中的最大值
            // 即比较左、右子树
            if (child != n - 1 && arr[child] < arr[child + 1]) {
                // 使得child = 子树中最大的下标
                child++; // 若右子树较大，则将左子树的下标+1，指向右子树
            }

            // 若父节点＜最大的孩子结点，则需要交换
            if (father < arr[child]) {
                arr[i] = arr[child];
            } else {

                // 大顶堆结构未被破坏，不需要调整
                break;
            }
        }
        arr[i] = father;
    }

    // 获取左孩子结点 位置
    private static int leftChild(int i) {
        return 2 * i ;
        // 2 * i = 左子树下标
        // 2 * i +1 = 右子树下标
    }


    // 交换元素位置
    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }



}
