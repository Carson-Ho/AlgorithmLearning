package scut.carson_ho.algorithmlearning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import scut.carson_ho.algorithmlearning.BinaryTree.BinaryTree_Recursion;
import scut.carson_ho.algorithmlearning.BinaryTree.Node;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "二叉树遍历算法：";

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
        Log.d(TAG,  "层序遍历（递归）");
        tree.levelTravel(root);

    }
}
