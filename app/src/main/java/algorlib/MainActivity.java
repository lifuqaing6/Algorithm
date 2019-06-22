package algorlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.lzzy.algorithm.R;

import java.security.PrivateKey;
import java.util.Calendar;
import java.util.Objects;
import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;
    private Spinner spinner;
    private LinearLayout container;
    private Spinner spSearch;
    private Button  btnSort;
    private Object swap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initSpinner();
        initSearch();
    }

    private void initSearch() {
        Spinner spSearch=findViewById(R.id.activity_main_sp_search);
        spSearch.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,SearchFactory.getSeerchNames()));
        LinearLayout container=findViewById(R.id.activity_main_btn_container);
        findViewById(R.id.activity_main_sp_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetSearch();
            }
        });
    }

    private void resetSearch() {
    }


    private void initSpinner() {
        Spinner spinner=findViewById(R.id.xz);
       // String[] names={"选择排序","直接插入排序","希尔排序"};
       spinner.setAdapter(new ArrayAdapter<String>(this,
               android.R.layout.simple_spinner_dropdown_item,SortFactory.getsortNames()));
    }


    private void initViews() {
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                BaseSort<Integer> sort=SortFactory.getInstance(spinner.getSelectedItemPosition(),items);
               BaseSort<Integer> sortNotNull= Objects.requireNonNull(sort);
               sortNotNull.sortWithTime();
                String result = sort.getResult();
                tvResult.setText(result);
                Toast.makeText(this,"总共时长:"+sort.getDuration(),Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void displayItems(TextView tv) {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }

    private void directSort() {
        //todo:直接选择排序的具体实现
        //用一个变量i指向数组的第一个位置也就是9，此时将0赋给变量min。
        //用一个变量j指向i后一个位置，也就是1(j同i一样，仅仅是指向数组的第二个位置，所以j得值为1，但是a[j]=1)
        //然后1,与9比较，9大，所以把j的值赋给min,j++
        //然后j++重复步骤3，直到最后可以得到min=9，所以交换i和j的值然后i+++++12

        for (int i=0;i<items.length-1;i++){
            int minPos=i;
            for (int j=i+1;j<items.length;j++){
                if (items[minPos].compareTo(items[j])>0){
                    minPos=j;
                }
            }
            swap(minPos,i);
        }
    }

    private void swap(int m, int n) {
        int tmp=items[m];
        items[m]=items[n];
        items[n]=tmp;
    }


    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }

        //插入排序2
        public  void  insertSort(){
            for(int i=1;i<items.length;i++){
                int j=i-1;
                if(items[j].compareTo(items[i])<0){
                    continue;
                }
                Integer tmp=items[i];
                while (i>=0&&items[j].compareTo(tmp)>0){
                    items[j+1]=items[j];
                    j--;

                }
                items[j+1]=tmp;
            }
        }
        private View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseSearch<Integer>search=
                        SearchFactory.getInstance(spSearch.getSelectedItemPosition(),items);
                if (search !=null){
                    int pos=search.search(v.getId());
                    tvResult.setText("该元素位于数组第".concat((pos + 1)+"位"));
                }
            }
        };


    }


