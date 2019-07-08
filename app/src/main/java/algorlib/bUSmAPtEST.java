package algorlib;

import org.junit.Test;

/**
 * Created by lzzy_gxy on 2019/7/8.
 * Description:
 */
public class bUSmAPtEST {
    @Test
    public void testGetMinDistance() {
        BusMap map = new BusMap(5);
        map.setStart(0);
        map.setTarget(4);
        map.addTWayEdge(0, 4, 10);
        map.addTWayEdge(0, 1, 2);
        map.addTWayEdge(0, 2, 4);
        map.addTWayEdge(1, 4, 7);
        map.addTWayEdge(1, 2, 3);
        map.addTWayEdge(2, 3, 4);
        map.addTWayEdge(2, 4, 3);
        map.addTWayEdge(3, 4, 5);
        int expected = 7;
    }
}
