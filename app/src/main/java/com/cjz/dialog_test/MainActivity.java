package com.cjz.dialog_test;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button bt_alertDialog;
    private Button bt_multipeAlertDialog;
    private Button bt_singleAlertDialog;
    private Button bt_DatePickerAlertDialog;
    private Button bt_timePickerAlerDialog;
    private Button bt_progressAlertDialog;
    private Button bt_waitingAlertDialog;
    private Mylistener mylistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mylistener = new Mylistener();
        bt_alertDialog = (Button) findViewById(R.id.bt_alertDialog);
        bt_alertDialog.setOnClickListener(mylistener);
        bt_multipeAlertDialog = (Button) findViewById(R.id.bt_multipleAlerDialog);
        bt_multipeAlertDialog.setOnClickListener(mylistener);
        bt_singleAlertDialog = (Button) findViewById(R.id.bt_singleAlertDialog);
        bt_singleAlertDialog.setOnClickListener(mylistener);
        bt_DatePickerAlertDialog = (Button) findViewById(R.id.bt_DataPickerAlertDialog);
        bt_DatePickerAlertDialog.setOnClickListener(mylistener);
        bt_timePickerAlerDialog = (Button) findViewById(R.id.bt_timeAlerDialog);
        bt_timePickerAlerDialog.setOnClickListener(mylistener);
        bt_progressAlertDialog = (Button) findViewById(R.id.bt_progressAlertDialog);
        bt_progressAlertDialog.setOnClickListener(mylistener);
        bt_waitingAlertDialog = (Button) findViewById(R.id.bt_WaitingAlertDialog);
        bt_waitingAlertDialog.setOnClickListener(mylistener);
    }


    class Mylistener implements OnClickListener {

        @Override
        public void onClick(View view) {
            int bt_int = view.getId();
            switch (bt_int){
                case R.id.bt_alertDialog:{
                    CreateAlertDialogWin();
                    break;
                }
                case R.id.bt_multipleAlerDialog:{
                    CreateMultipeAlertDialog();
                    break;
                }
                case R.id.bt_singleAlertDialog:{
                    CreateSingleAlertDialog();
                    break;
                }
                case R.id.bt_DataPickerAlertDialog:{
                    CreateDatePickerAlertDialog();
                    break;
                }
                case R.id.bt_timeAlerDialog:{
                    CreateTimePickerAlertDialog();
                    break;
                }
                case R.id.bt_progressAlertDialog:{
                    CreateProgressAlertDialog();
                    break;
                }
                case R.id.bt_WaitingAlertDialog:{
                    CreateWaitingAlertDialog();
                    break;
                }
                default:
                    break;
            }
        }
    }

    /**
     * 简单对话框
     */
    private void CreateAlertDialogWin(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("AlertDialog 测试");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("内容填充");
        builder.setNegativeButton("取消", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"已经取消",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确认", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"已经确认",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    /**
     * 多选对话框 注意：不要在添加setMessage方法，否则覆盖多选
     */
    private void CreateMultipeAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("AlertDialog 测试");
        builder.setIcon(R.mipmap.ic_launcher);
        final String[] items = new String[]{"上网","聊天","打游戏"};
        builder.setMultiChoiceItems(items,new boolean[]{true,false,true},
        new AlertDialog.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this,"选中："+items[i],Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("取消", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"已经取消",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确认", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"已经确认",Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    /**
     * 单选对话框 注意：不要在添加setMessage方法，否则覆盖多选
     */
    private void CreateSingleAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("AlertDialog 测试");
        builder.setIcon(R.mipmap.ic_launcher);
        final String[] items = new String[]{"上网","聊天","打游戏"};
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"只选："+items[i],Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"已经取消",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确认", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"已经确认",Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    /**
     * 日期对话框
     */
    private void CreateDatePickerAlertDialog(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int mon = Calendar.getInstance().get(Calendar.MONTH);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this,"选择的日期:"+i+":"+i1+":"+i2,Toast.LENGTH_SHORT).show();
            }
        },year,mon,day);

        datePickerDialog.show();

    }

    /**
     * 时间对话框
     */
    private void CreateTimePickerAlertDialog() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int min = Calendar.getInstance().get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                Toast.makeText(MainActivity.this,"时间："+i+":"+i1,Toast.LENGTH_SHORT).show();
            }
        },hour,min,true);//最后面的布尔值：代表是否24小时制
        timePickerDialog.show();
    }

    /**
     * 进度条对话框
     */
    private void CreateProgressAlertDialog(){
        ProgressDialog progreesdialog = new ProgressDialog(MainActivity.this);
        progreesdialog.setTitle("标题");
        progreesdialog.setIcon(R.mipmap.ic_launcher);
        progreesdialog.setMessage("正在下载，请稍后..............");
        progreesdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progreesdialog.setMax(100);
        progreesdialog.setProgress(10);
        progreesdialog.setSecondaryProgress(50);//第二进度条
        progreesdialog.show();
//        progreesdialog.dismiss();
    }

    /**
     * 圆形等待框
     */
    private void CreateWaitingAlertDialog(){
        ProgressDialog progreesdialog = new ProgressDialog(MainActivity.this);
        progreesdialog.setTitle("标题");
        progreesdialog.setIcon(R.mipmap.ic_launcher);
        progreesdialog.setMessage("正在下载，请稍后..............");
//        默认是圆形
//        progreesdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progreesdialog.show();
    }

}


