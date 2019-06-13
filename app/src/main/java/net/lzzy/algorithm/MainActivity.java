package net.lzzy.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                directSort();
                displayItems(tvResult);
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
        //然后j++重复步骤3，直到最后可以得到min=9，所以交换i和j的值然后i+++++1
    }

    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }

        //插入排序
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


    }


