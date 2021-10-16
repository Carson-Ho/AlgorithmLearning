# 简介

![示意图](http://upload-images.jianshu.io/upload_images/944365-8aa61f338c644d3f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

# 算法示意图


![示意图](http://upload-images.jianshu.io/upload_images/944365-87c6d20d393d39a1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


# 具体流程

![示意图](http://upload-images.jianshu.io/upload_images/944365-922c177e1bfff89b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



>注：`G` 比 `I` 先访问的原因 = 用数组存储顶点时，`G`的下标 比 `I`的下标小（按`ABCDEFGHI`顺序存储）

# 具体实现
>非递归：采用队列

```
import java.util.LinkedList;
import java.util.Queue;
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
     * 广度优先搜索 算法实现
     * 原理：非递归（采用队列）
     */
    public void BFS(){

        // 1. 初始化所有顶点的访问标记
        // 即，设置为未访问状态
        for (int i = 0; i < vexnum; i++) {
            visited[i] = false;
        }

        // 2. 创建队列
        Queue<Integer> q=new LinkedList<Integer>();

        // 3. 对所有顶点做遍历循环（从第1个顶点开始）
        // 若遍历完毕，则结束整个层序遍历
        for(int i=0;i < vexnum;i++){

            // 4. 若当前顶点未被访问，就进行处理
            // 若当前顶点已被访问，则回到3进行判断
            if( visited[i]==false ) {

                // 5. （输出）访问当前顶点
                visit(i);

                // 6. 标记当前顶点已被访问
                visited[i] = true;

                // 7. 入队当前顶点
                q.add(i);

                // 8.判断当前队列是否为空
                // 若为空则跳出循环，回到3进行判断
                while(!q.isEmpty()) {

                    // 9. 出队队首元素 & 将出队的元素 赋值为 当前顶点
                    i =  q.poll();

                    // 10. 遍历当前顶点的所有邻接点
                    // 若遍历完毕，则回到8判断
                    for(int j=0; j< vexnum ; j++){

                        // 11. 若当前顶点的邻接顶点存在 & 未被访问，则执行处理
                        // 否则回到10判断
                        if(arcs[i][j]==1 && visited[j]==false){

                            // 12. （输出）访问当前顶点的邻接顶点
                            visit(j);

                            // 13. 标记当前顶点的邻接顶点已被访问
                            visited[j] = true;

                            // 14. 入队当前顶点的邻接顶点
                            q.add(j);

                        }
                    }

                }

            }
        }
    }

  /**
    * 辅助算法1：访问该顶点
    */
    public void visit(int i){
        System.out.print(vertices[i] + " ");
    }

  /** 
    * 测试算法
    */
    public static void main(String[] args) {
        // 1. 初始化图的结构（顶点数量 = 9
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

        // 4. 执行 图的广度优先遍历（非递归）
        System.out.print("广度优先遍历（非递归）：");
        g.BFS();
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

# 执行结果

```
广度优先遍历（非递归）：A B F C G I E D H
```