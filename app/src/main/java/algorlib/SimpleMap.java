package algorlib;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lzzy_gxy on 2019/6/27.
 * Description:
 */
public class SimpleMap {
    int vertexCount;
    List <Edge> edges = new ArrayList <>();
    List <Integer> visited;
    //List <>

    public SimpleMap(int v) {
        vertexCount = v;
    }

    public void addEdge(int source, int target, double distance) {
        edges.add(new Edge(source, target, distance));
    }

    public void addTWayEdge(int v1, int v2, double distance) {
        addEdge(v1, v2, distance);
        addEdge(v2, v1, distance);
    }

    List <Edge> getConnectedEdges(int source) {
        List <Edge> result = new ArrayList <>();
        for (Edge e : edges) {
            if (e.getSource() == source) {
                result.add(e);
            }
        }
        return result;
    }

    private void iterateDepth(int v) {
        if (!visited.contains(v)) {
            visited.add(v);
        }
        if (visited.size() == vertexCount) {
            return;
        }
        List <Edge> vEdges = getConnectedEdges(v);
        for (Edge edge : vEdges) {
            if (visited.contains(edge.getTarget())) {
                continue;
            }
            iterateDepth(edge.getTarget());
        }
    }

    public String iterateDepthFirst() {
        StringBuilder result=new StringBuilder();
        Queue<Integer> queue=new LinkedList <>();
        queue.offer(0);
        int head=0,tail=1;
        while (head<tail) {
        Integer cursor=queue.poll();
        if (cursor==null){
            break;
        }
        result.append(cursor).append(",");
        List<Edge>vEdges=getConnectedEdges(cursor);
        for (Edge edge: vEdges){
            if (!queue.contains(edge.getTarget())){
                queue.offer(edge.getTarget());
                tail++;
            }
            if (tail>vertexCount){
                break;
            }
        }
        head++;
        }
        while (queue.size()>0){
            result.append(queue.poll()).append(",");
        }
        return result.toString();
    }

    class Edge {
        public boolean getSource;

        public Edge(int source, int target, double distance) {
        }

        public int getTarget() {
            return 0;
        }

        public int getSource() {
            return 0;
        }

        public double getDistance() {
            return 0;
        }
    }
}
// 1   private void addEdge(int v2, int v1, double distance) {
//    }
//}
