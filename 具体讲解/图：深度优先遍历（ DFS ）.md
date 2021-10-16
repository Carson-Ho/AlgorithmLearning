# 简介

![示意图](http://upload-images.jianshu.io/upload_images/944365-cbe8c5eb257fe5d1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)





# 算法示意图

![示意图](http://upload-images.jianshu.io/upload_images/944365-f174872ab750825b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

# 具体实现：递归 & 非递归
>此处图的存储结构 = 邻接矩阵

```
import java.util.Stack;

public class MyGraph {

    /**
     * 准备工作1：设置变量
     */
    private int vexnum;  // 存放图中顶点数量
    private char[] vertices;  // 存放结点数据
    private int [][] arcs;  // 存放图的所有边
    private boolean[] visited;// 记录节点是否已被遍历

    /**
     * 准备工作2：初始化图的顶点数量、数据 & 边
     */
    public MyGraph(int n){
        vexnum = n;
        vertices = new char[n];
        visited = new boolean[n];
        arcs = new int[n][n];
    }

    /**
     * 图的深度优先遍历算法实现：递归
     * 类似 前序遍历
     */
    public void DFSTraverse(){
        // 1. 初始化所有顶点的访问标记
        // 即，都是未访问状态
        for (int i = 0; i < vexnum; i++) {
            visited[i] = false;
        }

        // 2. 深度优先遍历顶点（从未被访问的顶点开始）
        for(int i=0;i < vexnum;i++){

            if(visited[i]==false){

                // 若是连通图，只会执行一次
                traverse(i); // ->>看关注1
            }
        }
    }

    /**
     * 关注1：邻接矩阵的深度优先搜索递归算法
     * 即，从第i个顶点开始深度优先遍历
     */
    private void traverse(int i){

        // 1. 标记第i个顶点已遍历
        visited[i] = true;

        // 2. （输出）访问当前遍历的顶点
        visit(i);

        // 3. 遍历邻接矩阵中第i个顶点的所有邻接顶点
        for(int j=0;j<vexnum;j++){

            // a. 若当前顶点的邻接顶点存在 & 未被访问，则递归 深度优先搜索 算法

            if(arcs[i][j]==1 && visited[j]==false){
                // b. 将当前顶点的邻接顶点作为当前顶点，递归 深度优先搜索 算法
                traverse(j);
            }
        }
    }
    
    /**
     * 辅助算法1：访问顶点值
     */
    public void visit(int i){
        System.out.print(vertices[i] + " ");
    }

    
    
    /**
     * 图的深度优先遍历算法实现：非递归
     * 原理：采用 栈实现
     */
    public void DFSTraverse2(){
        // 1. 初始化顶点访问标记
        // 全部标记为：未访问
        for (int i = 0; i < vexnum; i++) {
            visited[i] = false;
        }

        // 2. 创建栈
        Stack<Integer> s = new Stack<Integer>();


        for(int i=0 ; i<vexnum; i++){

            // 3. 若该顶点未被访问
            if(!visited[i]){
                // 4. 入栈该顶点

                s.add(i);

                do{
                    // 出栈
                    int curr = s.pop();

                    // 如果该节点还没有被遍历，则遍历该节点并将子节点入栈
                    if(visited[curr]==false){
                        // 遍历并打印
                        visit(curr);
                        visited[curr] = true;

                        // 没遍历的子节点入栈
                        for(int j=vexnum-1; j>=0 ; j-- ){
                            if(arcs[curr][j]==1 && visited[j]==false){
                                s.add(j);
                            }
                        }
                    }
                }while(!s.isEmpty());
            }
        }
    }

    
    /**
     * 测试（递归 & 非递归）
     */
    public static void main(String[] args) {

        // 1. 初始化图的结构（顶点数量 = 9）
        MyGraph g = new MyGraph(9);

        // 2. 设置顶点数据
        char[] vertices = {'A','B','C','D','E','F','G','H','I'};
        g.setVertices(vertices);

        // 3. 设置边
        g.addEdge(0, 1);
        g.addEdge(0, 5);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(1, 6);
        g.addEdge(1, 8);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 8);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        g.addEdge(3, 8);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(4, 7);
        g.addEdge(5, 0);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 1);
        g.addEdge(6, 3);
        g.addEdge(6, 5);
        g.addEdge(6, 7);
        g.addEdge(7, 3);
        g.addEdge(7, 4);
        g.addEdge(7, 6);
        g.addEdge(8, 1);
        g.addEdge(8, 2);
        g.addEdge(8, 3);

        // 4. 执行 图的深度优先遍历：（递归 & 非递归）
        System.out.println("深度优先遍历（递归）");
        g.DFSTraverse();
        System.out.println("深度优先遍历（非递归）");
        g.DFSTraverse2();

    }

    /**
     * 辅助算法1：添加边(无向图)
     */
    public void addEdge(int i, int j) {
        // 边的头尾不能为同一节点
        if (i == j) return;

        // 将邻接矩阵的第i行第j列的元素值置为1；
        arcs[i][j] = 1;
        // 将邻接矩阵的第j行第i列的元素值置为1；
        arcs[j][i] = 1;
        // 设置为1代表2顶点之间存在 边 （设置相等原因 = 邻接矩阵 是对称的）
    }

    /**
     * 辅助算法2：设置顶点数据
     */
    public void setVertices(char[] vertices) {
        this.vertices = vertices;
    }
}
```

# 测试结果

```
深度优先遍历（递归）
A B C D E F G H I 
深度优先遍历（非递归）
A B C D E F G H I
```


# 特别注意
对于图的存储结构 = **邻接表**实现，只需要**将 存储边  的2维数组 改成链表即可。**

# 图的存储结构 = 邻接矩阵 / 邻接表 的性能对比

![示意图](http://upload-images.jianshu.io/upload_images/944365-6ca03f07868dda2b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)