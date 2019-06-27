package algorlib;

/**
 * Created by lzzy_gxy on 2019/6/27.
 * Description:
 */
public class BubbleSor<T extends Comparable<? super T>>extends BaseSearch {
    BubbleSor(T[] items){
        super(items);
    }
  @Override
    void sort() {
      for (int i = 0; i < items.length - 1; i++) {
          boolean exchangge = false;
          for (int j = items.length - 2; j >= i; j--) {
              if (bigger(items[j],items[j+1])){
                  sawp(j,j+1);
                  exchangge=true;
              }
          }
          if (!exchangge){
              break;
          }
      }
  }
  boolean bigger (Comparable a, Comparable b) {
        compaereCount++;
        return a.compareTo(b) > 0;
    }
    private void sawp(int  i,int j) {
        T tmp = (T) items[i];
        items[i] = items[j];
        items[j] = tmp;
        swapCount++;
    }
}


//若有n个数值，需要n-1次排序。此例中有4个数值，进行了3次排序。
//在第m次排序中，需要进行n-m次数值比较。例如此例中第一个排序需要进行4-1=3次数值比较。



