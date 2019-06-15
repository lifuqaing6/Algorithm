package algorlib;

import java.util.List;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public abstract class BaseSort<T extends Comparable<? super T>> {



    T[] items;
     long duration;
    private int compaereCount;
    private int swapCount;
     int moveSetep;


     BaseSort(T[] itms) {
        this.items = itms;
        compaereCount = 0;
        swapCount = 0;
        moveSetep = 0;
    }
    boolean bigger(Integer a, Integer b) {
        compaereCount++;
        return a.compareTo(b) > 0;
    }
    private void sawp(int  i,int j) {
        T tmp = items[i];
       items[i] = items[j];
        items[j] = tmp;
        swapCount++;
    }

        public String getResult() {
        String display = "";
        for (T i : items) {
            display = display.concat(i + ",");
        }
        return display.substring(0, display.length() - 1);
    }

    public void sortWithTime(){
         long start= System.currentTimeMillis();
         sort();
         duration=System.currentTimeMillis()-start;
    }

    public abstract void sort();

    public long getDuration(){return duration;}

    public int getCompareCount(){return compaereCount;}

    public int getSwapCount(){return swapCount;}

    public int getMoveSetep(){return moveSetep;}


}
