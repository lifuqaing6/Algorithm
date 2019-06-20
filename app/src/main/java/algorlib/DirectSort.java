package algorlib;

import android.widget.AdapterView;

import javax.xml.datatype.Duration;

/**
 * Created by lzzy_gxy on 2019/6/13.
 * Description:
 */
public class DirectSort <T extends Comparable<? super T>> extends BaseSort<T> {

    public DirectSort(T[] itmes) {
        super(itmes);
    }
    void swap(int a,int b){
        T temp=items[a];
        items[a]=items[b];
        items[b]=temp;
        compareSwop++;

}
    @Override
    public void sort() {
        for (int i = 0; i < items.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < items.length; j++) {
                if (comare(items(minPos),(items[j]))) {
                    minPos = j;
                }
            }
            swap(minPos, i);
        }


    }

    private T items(int minPos) {
        return null;
    }
}




    // private Integer[] items;
    //  private long duration;
    //  private int compaereCount;
    //  private int swapCount;
    // private int moveSetep;
    // private int cswdwa2;
    //endregion


    // public Integer[]



  //  boolean bigger(Integer a, Integer b) {
  //      compaereCount++;
//        return a.compareTo(b) > 0;
  //  }



 //   public String getResult() {
 //       String display = "";
   //     for (Integer i : items) {
  //          display = display.concat(i + ",");
 //       }
  //      return display.substring(0, display.length() - 1);
    //}


 //   private void sawp(int i,int j){
 //       int tmp=items[i];
  //      items[i]=items[i];
 //       items[j]=tmp;
  //      swapCount++;

 //   }


  //  public long getDuration() {
  //      return duration;

 //   }


//    public int getCompaereCount(){
  //      return compaereCount;
 //   }






