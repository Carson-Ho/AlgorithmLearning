package scut.carson_ho.algorithmlearning.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carson_Ho on 17/9/30.
 * 作用：图的顶点
 */

public class GraphNode {

    public List<GraphEdge> edgeList ;

    private String label = "";

    public GraphNode(String label) {
        this.label = label;
        edgeList = new ArrayList<GraphEdge>();

    }

    // 作用：给当前顶点添加1条边（参数 = edge = 添加的边）
    public void addEdgeList(GraphEdge edge) {
        edgeList.add(edge);
    }

    public String getLabel() {
        return label;
    }
}
