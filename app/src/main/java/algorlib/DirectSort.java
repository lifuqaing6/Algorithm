package algorlib;

import android.widget.AdapterView;

import javax.xml.datatype.Duration;

/**
 * Created by lzzy_gxy on 2019/6/13.
 * Description:
 */
public class DirectSort {

    private Integer[] items;
    private long duration;
    private int compaereCount;
    private int swapCount;
    private int moveSetep;
    // private int cswdwa2;
    //endregion


   // public Integer[]

    public DirectSort(Integer[] itms) {
        this.items = itms;
        compaereCount = 0;
        swapCount = 0;
        moveSetep = 0;
    }

    boolean bigger(Integer a, Integer b) {
        compaereCount++;
        return a.compareTo(b) > 0;
    }

    void swap(int i, int j) {
        int tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
        swapCount++;
    }

    public String getResult() {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        return display.substring(0, display.length() - 1);
    }

    public void sort() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < items.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < items.length; j++) {
                if (bigger(items[minPos],i)) {
                    minPos = j;
                }
            }
            swap(minPos, i);
        }
        duration=System.currentTimeMillis()-start;

    }
    private void sawp(int i,int j){
        int tmp=items[i];
        items[i]=items[i];
        items[j]=tmp;
        swapCount++;

    }


    public long getDuration() {
        return duration;

    }


    public int getCompaereCount(){
        return compaereCount;
    }



}


