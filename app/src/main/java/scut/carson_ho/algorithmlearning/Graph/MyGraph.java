package scut.carson_ho.algorithmlearning.Graph;

import android.util.Log;

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

        arcs[i][j] = 1;
        arcs[j][i] = 1;
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
        Log.d(TAG,  vertices[i] + " ");
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

}
