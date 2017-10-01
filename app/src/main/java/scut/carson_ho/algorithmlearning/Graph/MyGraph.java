package scut.carson_ho.algorithmlearning.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Carson_Ho on 17/9/30.
 * 作用：创建图的存储方式：邻接矩阵
 */

public class MyGraph {

    private static final String TAG = "图遍历的顶点是：";

    /**
     * 设置变量
     */
    private int vexnum;  // 存放图中顶点数量
    private char[] vertices;  // 存放结点数据
    private int [][] arcs;  // 存放图的所有边
    private boolean[] visited;// 记录节点是否已被遍历

    /**
     * 初始化图的顶点数量、数据 & 边
     */
    public MyGraph(int n){
        vexnum = n;
        vertices = new char[n];
        visited = new boolean[n];
        arcs = new int[n][n];
    }

    /**
     * 添加边(无向图)
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
     * 设置顶点数据
     */
    public void setVertices(char[] vertices) {
        this.vertices = vertices;
    }

    /**
     * 访问该顶点
     */
    public void visit(int i){
        System.out.print(vertices[i] + " ");
    }

    /**
     * 邻接矩阵的深度优先搜索递归算法
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
     * 图的深度优先遍历（递归）
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
                traverse(i);
            }
        }
    }

    /**
     * 图的深度优先遍历（非递归）
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
     * 内容：层序遍历
     * 方式：非递归（采用队列）
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

}
