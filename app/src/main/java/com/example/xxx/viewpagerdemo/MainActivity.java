package com.example.xxx.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private List<View> viewList = new ArrayList<View>();
    private LinearLayout llfeng, llyu, lllei, lldian;
    private ImageButton ibfeng, ibyu, iblei, ibdian;
    private TextView tvfeng, tvyu, tvlei, tvdian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpage);

        llfeng = (LinearLayout) findViewById(R.id.llfeng);
        llyu = (LinearLayout) findViewById(R.id.llyu);
        lllei = (LinearLayout) findViewById(R.id.lllei);
        lldian = (LinearLayout) findViewById(R.id.lldian);

        ibfeng = (ImageButton) findViewById(R.id.ibfeng);
        ibyu = (ImageButton) findViewById(R.id.ibyu);
        iblei = (ImageButton) findViewById(R.id.iblei);
        ibdian = (ImageButton) findViewById(R.id.ibdian);

        tvfeng = (TextView) findViewById(R.id.tvfeng);
        tvfeng.setText(getString(R.string.feng, "风"));

        tvyu = (TextView) findViewById(R.id.tvyu);
        tvyu.setText(getString(R.string.yu, "雨"));

        tvlei = (TextView) findViewById(R.id.tvlei);
        tvlei.setText(getString(R.string.lei, "雷"));

        tvdian = (TextView) findViewById(R.id.tvdian);
        tvdian.setText(getString(R.string.dian, "电"));

        LayoutInflater inflater = LayoutInflater.from(this);
        View tab_feng = inflater.inflate(R.layout.tab_feng, null);
        View tab_yu = inflater.inflate(R.layout.tab_yu, null);
        View tab_lei = inflater.inflate(R.layout.tab_lei, null);
        View tab_dian = inflater.inflate(R.layout.tab_dian, null);
        viewList.add(tab_feng);
        viewList.add(tab_yu);
        viewList.add(tab_lei);
        viewList.add(tab_dian);

        pagerAdapter = new PagerAdapter() {
            //初始化item
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = viewList.get(position);
                container.addView(view);
                return view;
            }

            //销毁item
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };

        viewPager.setAdapter(pagerAdapter);
    }

    private void initEvent() {
        llfeng.setOnClickListener(this);
        llyu.setOnClickListener(this);
        lllei.setOnClickListener(this);
        lldian.setOnClickListener(this);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = viewPager.getCurrentItem();
                resettingBg();
                resettingTextBg();
                switch (currentItem) {
                    case 0:
                        ibfeng.setImageResource(R.drawable.select_feng);
                        tvfeng.setTextColor(getResources().getColor(R.color.lanse));
                        break;
                    case 1:
                        ibyu.setImageResource(R.drawable.select_yu);
                        tvyu.setTextColor(getResources().getColor(R.color.lanse));
                        break;
                    case 2:
                        iblei.setImageResource(R.drawable.select_lei);
                        tvlei.setTextColor(getResources().getColor(R.color.lanse));
                        break;
                    case 3:
                        ibdian.setImageResource(R.drawable.select_dian);
                        tvdian.setTextColor(getResources().getColor(R.color.lanse));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        resettingBg();
        resettingTextBg();
        switch (view.getId()) {
            case R.id.llfeng:
                viewPager.setCurrentItem(0);
                ibfeng.setImageResource(R.drawable.select_feng);
                tvfeng.setTextColor(getResources().getColor(R.color.lanse));
                break;
            case R.id.llyu:
                viewPager.setCurrentItem(1);
                ibyu.setImageResource(R.drawable.select_yu);
                tvyu.setTextColor(getResources().getColor(R.color.lanse));
                break;
            case R.id.lllei:
                viewPager.setCurrentItem(2);
                iblei.setImageResource(R.drawable.select_lei);
                tvlei.setTextColor(getResources().getColor(R.color.lanse));
                break;
            case R.id.lldian:
                viewPager.setCurrentItem(3);
                ibdian.setImageResource(R.drawable.select_dian);
                tvdian.setTextColor(getResources().getColor(R.color.lanse));
                break;
        }
    }

    //重置背景
    private void resettingBg() {
        ibfeng.setImageResource(R.drawable.unselect_feng);
        ibyu.setImageResource(R.drawable.unselect_yu);
        iblei.setImageResource(R.drawable.unselect_lei);
        ibdian.setImageResource(R.drawable.unselect_dian);
    }

    //重置字体背景
    private void resettingTextBg() {
        tvfeng.setTextColor(getResources().getColor(R.color.huise));
        tvyu.setTextColor(getResources().getColor(R.color.huise));
        tvlei.setTextColor(getResources().getColor(R.color.huise));
        tvdian.setTextColor(getResources().getColor(R.color.huise));
    }
}
