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
//
//        Log.d(TAG,  "先序遍历（递归）如下：");
//        tree.preOrder(root);
        Log.d(TAG,  "先序遍历（非递归）如下：");
        tree.preOrder_stack(root);

    }
}
