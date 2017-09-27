package scut.carson_ho.algorithmlearning.BinaryTree;

import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Carson_Ho on 17/9/25.
 */

public class BinaryTree_Recursion {

    private static final String TAG = "二叉树：";

    /**
     * 作用：构造二叉树
     * 注：必须逆序建立，即：先建立子节点，再逆序往上建立
     * 原因：非叶子节点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
     */ 
    public Node init(){
        // 结构如下：(由下往上建立)
        //            A
        //       B         C
        //    D         E     F
        //  G   H         I
        Node I = new Node("I", null, null);
        Node H = new Node("H", null, null);
        Node G = new Node("G", null, null);
        Node F = new Node("F", null, null);
        Node E = new Node("E", null, I);
        Node D = new Node("D", G, H);
        Node C = new Node("C", E, F);
        Node B = new Node("B", D, null);
        Node A = new Node("A", B, C);
        return A;  // 返回根节点
    }

    // 打印节点数值
    public static void printNode(Node node){
        System.out.print(node.getData());
        Log.d(TAG,  "结点 = "+ node.getData());
    }

    /**
     * 内容：前序遍历
     * 方式：递归
     */
    public void preOrder(Node root){
        // 1. 判断二叉树结点是否为空；若是，则返回空操作
        if(root ==null)
            return;

        // 2. 访问根节点（显示根结点）
        printNode(root);

        // 3. 遍历左子树
        preOrder(root.getLeftNode());

        // 4. 遍历右子树
        preOrder(root.getRightNode());

    }

    /**
     * 内容：前序遍历
     * 方式：非递归
     */
    public static void preOrder_stack(Node root){

        Stack<Node> stack = new Stack<Node>();

        // 步骤1：直到当前结点为空 & 栈空时，循环结束
        while(root != null || stack.size()>0){

            // 步骤2：判断当前结点是否为空
              // a. 若不为空，执行3
              // b. 若为空，执行5
              if(root != null){

                // 步骤3：输出当前节点，并将其入栈
                printNode(root);
                stack.push(root);

                // 步骤4：置当前结点的左孩子为当前节点
                // 返回步骤1
                root = root.getLeftNode();

            }else{

                // 步骤5：出栈栈顶结点
                root = stack.pop();
                // 步骤6：置当前结点的右孩子为当前节点
                root = root.getRightNode();
                  // 返回步骤1
            }
        }
    }

    /**
     * 内容：中序遍历
     * 方式：递归
     */
    public void InOrder(Node root){
        // 1. 判断二叉树结点是否为空；若是，则返回空操作
        if(root ==null)
            return;

        // 2. 遍历左子树
        InOrder(root.getLeftNode());

        // 3. 访问根节点（显示根结点）
        printNode(root);

        // 4. 遍历右子树
        InOrder(root.getRightNode());

    }


    /**
     * 内容：中序遍历
     * 方式：非递归
     */
    public static void InOrder_stack(Node root){

        Stack<Node> stack = new Stack<Node>();

        // 步骤1：直到当前结点为空 & 栈空时，循环结束
        while(root != null || stack.size()>0){

            // 步骤2：判断当前结点是否为空
            // a. 若不为空，执行3、4
            // b. 若为空，执行5、6
            if(root != null){

                // 步骤3：入栈当前结点
                stack.push(root);

                // 步骤4：置当前结点的左孩子为当前节点
                // 返回步骤1
                root = root.getLeftNode();

            }else{

                // 步骤5：出栈栈顶结点
                root = stack.pop();
                // 步骤6：输出当前节点
                printNode(root);
                // 步骤7：置当前结点的右孩子为当前节点
                root = root.getRightNode();
                // 返回步骤1
            }
        }
    }


    /**
     * 内容：后序遍历
     * 方式：递归
     */
    public void PostOrder(Node root){
        // 1. 判断二叉树结点是否为空；若是，则返回空操作
        if(root ==null)
            return;

        // 2. 遍历左子树
        PostOrder(root.getLeftNode());

        // 3. 遍历右子树
        PostOrder(root.getRightNode());

        // 4. 访问根节点（显示根结点）
        printNode(root);

    }

    /**
     * 内容：后序遍历
     * 方式：非递归
     */
    public void PostOrder_stack(Node root){

        Stack<Node> stack = new Stack<Node>();

        // 构造1中间栈
        Stack<Node> output = new Stack<Node>();

        // 步骤1：直到当前结点为空 & 栈空时，循环结束——> 步骤8
        while(root != null || stack.size()>0){

            // 步骤2：判断当前结点是否为空
            // a. 若不为空，执行3、4、5
            // b. 若为空，执行6、7
            if(root != null){

                // 步骤3：入栈当前结点到中间栈
                output.push(root);

                // 步骤4：入栈当前结点到普通栈
                stack.push(root);

                // 步骤5：置当前结点的右孩子为当前节点
                // 返回步骤1
                root = root.getRightNode();

            }else{

                // 步骤6：出栈栈顶结点
                root = stack.pop();
                // 步骤7：置当前结点的左孩子为当前节点
                root = root.getLeftNode();
                // 返回步骤1
            }
        }

        // 步骤8：输出中间栈的结点
        while(output.size()>0){
            printNode(output.pop());

        }


    }

    /**
     * 内容：层序遍历
     * 方式：非递归（采用队列）
     */
    public void levelTravel(Node root){
        // 创建队列
        Queue<Node> q=new LinkedList<Node>();

        // 步骤1：判断当前结点是否为空；若是，则返回空操作
        if(root==null)
            return;
        // 步骤2：入队当前结点
        q.add(root);

        // 步骤3：判断当前队列是否为空，若为空则跳出循环
        while(!q.isEmpty()){

            // 步骤4：出队队首元素
            root =  q.poll();

            // 步骤5：输出 出队元素
            printNode(root);

            // 步骤5：若出队元素有左孩子，则入队其左孩子
            if(root.getLeftNode()!=null) q.add(root.getLeftNode());

            // 步骤6：若出队元素有右孩子，则入队其右孩子
            if(root.getRightNode()!=null) q.add(root.getRightNode());
        }
    }
}



