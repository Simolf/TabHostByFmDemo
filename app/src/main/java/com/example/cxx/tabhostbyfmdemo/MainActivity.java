/*
fragment比Activity更轻量级，在同一个程序里面进行内部切换页面能够提高切换速度，减少内存占用
 */
package com.example.cxx.tabhostbyfmdemo;

import android.graphics.Color;
//v4兼容1.6以下版本，android.app.fragment仅支持1.6以上版本
//主Activity中的fragment要与定义的fragment引用的包相同
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    //自定义的fragment
    private MainFragment mainfragment;
    private messageFragment msgfragment;
    private SettingFragment settingfragment;
    //定义的布局
    private View main_layout;
    private View msg_layout;
    private View setting_layout;
    //自定义布局中的内容
    private TextView main_text;
    private TextView msg_text;
    private TextView setting_text;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化布局元素
        init();
        fragmentManager = getSupportFragmentManager();
        //定义启动时显示的fragment
        setTabSelection(1);

    }

    private void init(){
        main_layout = findViewById(R.id.main_layout);
        msg_layout=findViewById(R.id.message_layout);
        setting_layout = findViewById(R.id.setting_layout);
        main_text = (TextView) findViewById(R.id.main_text);
        msg_text = (TextView) findViewById(R.id.message_text);
        setting_text = (TextView) findViewById(R.id.setting_text);
        main_layout.setOnClickListener(this);
        msg_layout.setOnClickListener(this);
        setting_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.message_layout:
                setTabSelection(0);
                break;
            case R.id.main_layout:
                setTabSelection(1);
                break;
            case R.id.setting_layout:
                setTabSelection(2);
                break;
        }
    }
   /*
   设置选中的fragment，以index为参数，0表示消息，1表示主页，2表示设置
   每次设置前先清除上一次选中的tab，即还原选中颜色
   隐藏Fragment时防止多个fragment同时显示
   进行transaction操作add(),show(),replace()后要进行commit（）操作
    */
    private void setTabSelection(int index){
        cleanSelection();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (index){
            case 0:
                msg_text.setTextColor(Color.WHITE);
                if(msgfragment == null){
                    msgfragment = new messageFragment();
                   transaction.add(R.id.content, msgfragment);
                }else {
                    transaction.show(msgfragment);
                }
                break;
            case 1:
                main_text.setTextColor(Color.WHITE);
                if(mainfragment==null){
                    mainfragment = new MainFragment();
                    transaction.add(R.id.content,mainfragment);
                }else{
                    transaction.show(mainfragment);
                }
                break;
            default:
                setting_text.setTextColor(Color.WHITE);
                if(settingfragment==null){
                    settingfragment = new SettingFragment();
                    transaction.add(R.id.content,settingfragment);
                }else{
                    transaction.show(settingfragment);
                }
        }
        transaction.commit();


    }
    //清除选中状态
    private void cleanSelection(){
        main_text.setTextColor(Color.parseColor("#82858b"));
        msg_text.setTextColor(Color.parseColor("#82858b"));
        setting_text.setTextColor(Color.parseColor("#82858b"));
    }
    //隐藏全部的fragment，避免造成混乱
    private void hideFragment(FragmentTransaction transaction){
        if(msgfragment!=null){
            transaction.hide(msgfragment);
        }
        if(mainfragment!=null){
            transaction.hide(mainfragment);
        }
        if(settingfragment!=null){
            transaction.hide(settingfragment);
        }
    }
}
