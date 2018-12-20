package com.example.lv.showdatatest;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

//题目要求：编写一程序实现通过点击有日期显示的TextView、进入日期选择对话框、
//重新选择日期后返回、并将变化后的日期显示在该TextView上

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_view);

        //设置初始的text为系统时间
        final Calendar calendar = Calendar.getInstance();
        textView.setText((calendar.get(Calendar.YEAR)) + ":"
                + (calendar.get(Calendar.MONTH)+1) + ":"
                + (calendar.get(Calendar.DAY_OF_MONTH)));

        //注册textView的点击事件
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    //此方法用来弹出日期选择框并返回新的日期值
    private void showDatePickerDialog( ) {
        //设置默认的日期选择框的初始日期即为系统时间
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());

        int year = c.get(Calendar.YEAR);
        int monthOfYear = c.get(Calendar.MONTH);
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //当时间被设置后回调，在textView中显示新选择的时间
                textView.setText(year+":"+(monthOfYear+1)+":"+dayOfMonth);
                }
        }, year, monthOfYear,dayOfMonth);
        dpd.show();

    }

}
