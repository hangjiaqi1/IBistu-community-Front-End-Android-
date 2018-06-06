package com.example.yrw.myapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Main1Activity extends AppCompatActivity {
    Viewpageradapter pagerAdapter;

    private FenFragment Fragment1, Fragment2, Fragment3;
    private ViewPager viewPager;  //对应的viewPager
    private List<Fragment> mFragmentList;  //view数组
    private BottomNavigationView navigation;  //底部导航栏
    //创建底部导航栏监听器
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.versioninfo:
                    //false参数，去除view切换时的滑动效果
                    viewPager.setCurrentItem(0,false);
                    return true;
                case R.id.home:
                    viewPager.setCurrentItem(1,false);
                    return true;
                case R.id.userinfo:
                    viewPager.setCurrentItem(2,false);
                    return true;
            }
            return false;
        }

    };
    //创建监听viewpager的变化的监听器，并改变选中的底部菜单项
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
        @Override
        public void onPageSelected(int position) {
            navigation.getMenu().getItem(position).setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


        viewPager = (ViewPager) findViewById(R.id.vp);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //初始化view
        initFragment();

        //将原本的主标题隐藏
        getSupportActionBar().hide();

        //设置底部导航栏初始默认菜单项
        navigation.getMenu().getItem(1).setChecked(true);
        //设置底部导航栏监听器
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //设置监听viewpager的变化，并改变选中的底部菜单项
        viewPager.addOnPageChangeListener(mOnPageChangeListener);

        pagerAdapter=new Viewpageradapter(getSupportFragmentManager(),mFragmentList);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(1);

    }

    //初始化Fragment函数
    private void initFragment(){

        Fragment1 = new FenFragment(R.layout.layout1);
        Fragment2 = new FenFragment(R.layout.layout2);
        Fragment3 = new FenFragment(R.layout.layout3);

        mFragmentList = new ArrayList<>();
        // 将要分页显示的Fragment装入数组中
        mFragmentList.add(Fragment1);
        mFragmentList.add(Fragment2);
        mFragmentList.add(Fragment3);
    }



    //校园商城
    public void click_xysc(View view){
        Intent intent = new Intent(Main1Activity.this, shopping.class);
        startActivity(intent);
    }
    //二手书
    public void click_ess(View view){
        Intent intent = new Intent(Main1Activity.this,Main2Activity.class);
        startActivity(intent);
    }
    //邮件服务
    public void click_swzl(View view){
        Intent intent = new Intent(Main1Activity.this, SendEmail.class);
        startActivity(intent);
    }
    //签到
    public void click_qd(View view){
        Intent intent = new Intent(Main1Activity.this, Main2Activity.class);
        startActivity(intent);
    }
    //请假
    public void click_qj(View view){
        Intent intent = new Intent(Main1Activity.this, Main2Activity.class);
        startActivity(intent);
    }
    //通知
    public void click_tz(View view){
        Intent intent = new Intent(Main1Activity.this, Main2Activity.class);
        startActivity(intent);
    }
    //个人课表
    public void click_grkb(View view){
        Intent intent = new Intent(Main1Activity.this, Main2Activity.class);
        startActivity(intent);
    }
    //办公通讯录
    public void click_bgtxl(View view){
        Intent intent = new Intent(Main1Activity.this, Main2Activity.class);
        startActivity(intent);
    }
    //创建团队
    public void click_cjtd(View view){
        Intent intent = new Intent(Main1Activity.this, Main2Activity.class);
        startActivity(intent);
    }
    //团队沟通
    public void click_tdgt(View view){
        Intent intent = new Intent(Main1Activity.this, Main2Activity.class);
        startActivity(intent);
    }
    //待迁移
    public void click_dqy(View view){
        Intent intent = new Intent(Main1Activity.this, Main2Activity.class);
        startActivity(intent);
    }


}
