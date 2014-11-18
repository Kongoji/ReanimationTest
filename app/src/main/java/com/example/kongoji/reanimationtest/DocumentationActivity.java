package com.example.kongoji.reanimationtest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;

import com.viewpagerindicator.TabPageIndicator;

/**
 * Created by Kongoji on 28.10.14.
 */
public class DocumentationActivity extends FragmentActivity {

    TestFragmentAdapter mAdapter;
    ViewPager mPager;
    TabPageIndicator mIndicator;
    Menu mMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentation);

        mAdapter = new TestFragmentAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        mIndicator = (TabPageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.documentation, menu);
        this.mMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
    }

}
