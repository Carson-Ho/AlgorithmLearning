package scut.carson_ho.algorithmlearning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import scut.carson_ho.algorithmlearning.BinaryTree.BinaryTree_Recursion;
import scut.carson_ho.algorithmlearning.BinaryTree.Node;
import scut.carson_ho.algorithmlearning.Graph.MyGraph;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "图的遍历算法：";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BinaryTree_Recursion tree = new BinaryTree_Recursion();
        Node root = tree.init();

        /**
         * 前序遍历
         */
//        Log.d(TAG,  "前序遍历（递归）如下：");
//        tree.preOrder(root);
//        Log.d(TAG,  "前序遍历（非递归）如下：");
//        tree.preOrder_stack(root);

        /**
         * 中序遍历
         */
//        Log.d(TAG,  "中序遍历（非递归）");
//        tree.InOrder(root);
//        Log.d(TAG,  "中序遍历（递归）");
//        tree.InOrder_stack(root);

        /**
         * 后序遍历
         */
//        Log.d(TAG,  "后序遍历（递归）");
//        tree.PostOrder(root);
//        Log.d(TAG,  "后序遍历（非递归）");
//        tree.PostOrder_stack(root);

        /**
         * 层序遍历
         */
//        Log.d(TAG,  "层序遍历（递归）");
//        tree.levelTravel(root);

        /**
         * 执行深度优先遍历（DFS） - 递归
         */

        // 步骤1： 初始化图的结构（顶点数量 = 9
        MyGraph g = new MyGraph(9);
        // 步骤2： 设置顶点数据
        char[] vertices = {'A','B','C','D','E','F','G','H','I'};
        g.setVertices(vertices);

        // 步骤3： 设置边
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

//        // 步骤4： 执行 图的深度优先遍历（递归）
//        Log.d(TAG,  "深度优先遍历（递归）");
//        g.DFSTraverse();

        // 步骤4： 执行 图的深度优先遍历（递归）
        System.out.print("广度优先遍历（非递归）");
        System.out.print("广度优先遍历（非递归）");
        g.BFS();
        g.BFS();
        g.BFS();


    }
}
