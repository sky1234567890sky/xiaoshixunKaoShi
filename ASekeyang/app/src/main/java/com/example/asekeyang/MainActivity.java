package com.example.asekeyang;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.asekeyang.adapter.MainPageAdapter;
import com.example.asekeyang.fragemtn.HomeFragment;
import com.example.asekeyang.fragemtn.SourchFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar mTol;
    private ViewPager mVp;
    private MainPageAdapter adapter;
    private TabLayout mTab;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mTol = (Toolbar) findViewById(R.id.tol);
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
        //toolbar设置
        mTol.setTitle("热门");
        setSupportActionBar(mTol);

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new HomeFragment());
        fragments.add(new SourchFragment());

        adapter = new MainPageAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(adapter);

        mTab.addTab(mTab.newTab().setText("首页"));
        mTab.addTab(mTab.newTab().setText("关注"));

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                mVp.setCurrentItem(position);
                switch (position) {
                    case 0:
                        mTol.setTitle("热门");
                        break;
                    case 1:
                        mTol.setTitle("关注");
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
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
    }
}
