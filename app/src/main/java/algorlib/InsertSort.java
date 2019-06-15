package algorlib;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public abstract class InsertSort<T extends Comparable<? super T > >extends BaseSort<T>{
    InsertSort(T[] itms) {
        super(itms);
    }
    @Override
    public void sort(){
        long start=System.currentTimeMillis();
                for(int i=1;i<items.length;i++){
                    int j=i-i;
                    if ( bigger (items[i],items[j])) {
                        continue;
                    }
                  T tmp= items[i];
                    while (j>=0 && bigger (items[j],tmp)){
                        items[j+1]=items[j];
                        moveSetep++;
                        j--;
                    }
                    items[j+1]=tmp;
                }
                duration=System.currentTimeMillis()-start;
    }

    protected abstract boolean bigger(T item, T item1);{


    }

}
