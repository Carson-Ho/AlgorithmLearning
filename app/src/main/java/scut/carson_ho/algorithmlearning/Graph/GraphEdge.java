package scut.carson_ho.algorithmlearning.Graph;

/**
 * Created by Carson_Ho on 17/9/30.
 * 作用：图的边
 */

public class GraphEdge {

    // 边的左端位置（下面会添加顶点）
    private GraphNode nodeLeft;

    // 边的右端位置（下面会添加顶点）
    private GraphNode nodeRight;


    // 设置边的左、右端顶点
    public GraphEdge(GraphNode nodeLeft, GraphNode nodeRight) {
        this.nodeLeft = nodeLeft;
        this.nodeRight = nodeRight;
    }

    // 获得顶点的左、右边
    public GraphNode getNodeLeft() {
        return nodeLeft;
    }
    public GraphNode getNodeRight() {
        return nodeRight;
    }

}
