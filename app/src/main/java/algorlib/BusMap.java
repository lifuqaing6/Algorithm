package algorlib;

import android.util.SparseArray;

import java.util.List;

/**
 * Created by lzzy_gxy on 2019/7/8.
 * Description:
 */
public class BusMap  extends  SimpleMap {
    private SparseArray<String> vetexes;
    private double minDistance;
    private  int start,target;

    public BusMap(int v) {
        super(v);
        vetexes=new SparseArray <>();
        for (int i=00;i<v;i++){
            vetexes.append(i,String.valueOf(i));
        }
    }
    public void setStart(int start){
        this.start=start;
    }
    public void setTarget(int target){
        this.target=target;
    }
    public void rename(int i,String name){
        vetexes.setValueAt(i,name);
    }
    private void tryWay(int curVetex,double distance){
        if (minDistance>0 && distance>minDistance){
            return;
        }
        if (curVetex==target){
            if (minDistance==0 || minDistance>distance){
                minDistance=distance;
            }
            return;
        }
        List<Edge> vEdges=getConnectedEdges(curVetex);
        for (Edge edge:vEdges){
            if (vEdges.contains((edge.getTarget()))){
                continue;
            }
            visited.add(edge.getTarget());
            tryWay(edge.getTarget(),distance+edge.getDistance());
            visited.remove(edge.getTarget());
        }
    }
//    private double[][] floyd() {
//        double[][] doubles = new double[vertexCount][vertexCount];
//      for (int i=0;i<vertexCount;i++){
//          for (int j=0;j<vertexCount;i++){
//              doubles[i][j]=999999;
//          }
//      }
//      for (Edge edge:edges){
//          doubles[edge.getSource()][edge]
//      }
//    }
}
