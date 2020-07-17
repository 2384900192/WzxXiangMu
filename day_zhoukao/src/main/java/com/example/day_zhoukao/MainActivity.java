package com.example.day_zhoukao;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.day_zhoukao.fragment.GuangFragment;
import com.example.day_zhoukao.fragment.SanFragment;
import com.example.day_zhoukao.fragment.SiFragment;
import com.example.day_zhoukao.fragment.WuFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private FrameLayout mFragmentlayout;
    private TabLayout mTablayout;
    private GuangFragment guangFragment;
    private WuFragment wuFragment;
    private SanFragment sanFragment;
    private SiFragment siFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mFragmentlayout = (FrameLayout) findViewById(R.id.fragmentlayout);
        mTablayout = (TabLayout) findViewById(R.id.tablayout);

        mToolbar.setTitle("玩Androd");
        setSupportActionBar(mToolbar);
        TextView childAt = (TextView) mToolbar.getChildAt(0);
        childAt.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
        childAt.setGravity(Gravity.CENTER_HORIZONTAL);

        guangFragment = new GuangFragment();
        wuFragment = new WuFragment();
        sanFragment = new SanFragment();
        siFragment = new SiFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentlayout, guangFragment)
                .add(R.id.fragmentlayout, wuFragment)
                .add(R.id.fragmentlayout, sanFragment)
                .add(R.id.fragmentlayout, siFragment)
                .hide(guangFragment)
                .hide(sanFragment)
                .hide(siFragment)
                .commit();

        mTablayout.addTab(mTablayout.newTab().setText("首页").setIcon(R.drawable.one));
        mTablayout.addTab(mTablayout.newTab().setText("广场").setIcon(R.drawable.tew));
        mTablayout.addTab(mTablayout.newTab().setText("公众号").setIcon(R.drawable.too));
        mTablayout.addTab(mTablayout.newTab().setText("体系").setIcon(R.drawable.poo));

        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .show(wuFragment)
                                .hide(guangFragment)
                                .hide(sanFragment)
                                .hide(siFragment)
                                .commit();

                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .show(guangFragment)
                                .hide(wuFragment)
                                .hide(sanFragment)
                                .hide(siFragment)
                                .commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .show(sanFragment)
                                .hide(guangFragment)
                                .hide(wuFragment)
                                .hide(siFragment)
                                .commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction()
                                .show(siFragment)
                                .hide(guangFragment)
                                .hide(wuFragment)
                                .hide(sanFragment)
                                .commit();

                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
