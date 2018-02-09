package scut.carson_ho.algorithmlearning.BinaryTree;

/**
 * Created by Carson_Ho on 17/9/25.
 * 内容：二叉树 节点
 */

public class Node {

    private String data; // 二叉树的结点数据
    private Node leftNode; // 二叉树的左子树（左孩子）
    private Node rightNode; // 二叉树的右子树（右孩子）

    // 构造函数中传入结点的数据、左子树、右子树
    public Node(String data, Node leftNode, Node rightNode){
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    // 获得 & 设置二叉树的结点数据
    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data = data;
    }

    // 获得 & 设置二叉树的左子树（左孩子）
    public Node getLeftNode(){
        return leftNode;
    }

    public void setLeftNode(Node leftNode){
        this.leftNode = leftNode;
    }

    // 获得 & 设置二叉树的右子树（右孩子）
    public Node getRightNode(){
        return rightNode;
    }
    public void setRightNode(Node rightNode){
        this.rightNode = rightNode;
    }

}


///**
// * 设置结点结构
// */
//public static class TreeNode<T> {
//    T val; // 二叉树的结点数据
//    TreeNode<T> leftNode; // 二叉树的左子树（左孩子）
//    TreeNode<T> rightNode; // 二叉树的右子树（右孩子）
//
//    public TreeNode(T data,TreeNode<T> left,TreeNode<T> right) {
//        this.val = data;
//        this.leftNode = left;
//        this.rightNode = right;
//    }
//
//
//    // 获得 & 设置二叉树的结点数据
//    public T getData(){
//        return val;
//    }
//
//    public void setData(T data){
//        this.val = data;
//    }
//
//    // 获得 & 设置二叉树的左子树（左孩子）
//    public TreeNode getLeftNode(){
//        return leftNode;
//    }
//
//    public void setLeftNode(TreeNode leftNode){
//        this.leftNode = leftNode;
//    }
//
//    // 获得 & 设置二叉树的右子树（右孩子）
//    public TreeNode getRightNode(){
//        return rightNode;
//    }
//    public void setRightNode(TreeNode rightNode){
//        this.rightNode = rightNode;
//    }
//}
