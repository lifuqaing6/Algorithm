package algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class BaseSearch <T extends Comparable<? super T>> {


    T[] items;
    long duration;
    int compaereCount;
    int swapCount;
    int moveSetep;


    BaseSearch(T[] items) {
        this.items = items;
        compaereCount = 0;
        swapCount = 0;
        moveSetep = 0;
    }
boolean equal(T a ,T b) {
     compaereCount++;
     return  a.compareTo(b)==0;
}
    int compare(T a,T b){
        compaereCount++;
        return  a.compareTo(b);
    }

    int search(T key) {
        return 0;
    }

    public long getDuration(){
        return duration;
    }
    public void setDuration(long duration){
        this.duration=duration;
    }
    public int getCompaereCount(){
        return compaereCount;
    }
    public void setCompaereCount(int compaereCount){
        this.compaereCount=compaereCount;
    }
    public int getSwapCount(){
        return  swapCount;
    }
}

//public void  searchWithTime(T key){
//       long start=System.currentTimeMillis();

//}