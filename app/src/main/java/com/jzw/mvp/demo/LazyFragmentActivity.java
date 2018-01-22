package com.jzw.mvp.demo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.jzw.mvp.base.BaseActivity;
import com.jzw.mvp.demo.fragmeng.Fragment1;
import com.jzw.mvp.demo.fragmeng.Fragment2;
import com.jzw.mvp.demo.fragmeng.Fragment3;

import java.util.ArrayList;
import java.util.List;

/**
 * @anthor created by jzw
 * @date 2017/11/24 0024
 * @change
 * @describe describe
 **/
public class LazyFragmentActivity extends BaseActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public int getLayoutId() {
        return R.layout.act_fragment;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        tabLayout = findViewById(R.id.tb);
        viewPager = findViewById(R.id.vp);

        String[] titles = new String[]{"fragmeng1", "fragmeng2", "fragmeng3"};
        List<Fragment> fragments = new ArrayList<>();


        Fragment1 fragment1 = new Fragment1();
        fragment1.openLazyLoad(true);


        Fragment2 fragment2 = new Fragment2();
        fragment2.openLazyLoad(true);
        Fragment3 fragment3 = new Fragment3();
        fragment3.openLazyLoad(true);


        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), titles, fragments);

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setCurrentItem(0);
        tabLayout.setupWithViewPager(viewPager);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        private String[] titles;
        private List<Fragment> fragments;

        public MyPagerAdapter(FragmentManager fm, String[] titles, List<Fragment> fragmentList) {
            super(fm);
            this.titles = titles;
            this.fragments = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position % titles.length];
        }
    }

}
