package com.example.kongoji.reanimationtest;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;

/**
 * Created by Kongoji on 28.10.14.
 */
public class DocumentationActivity extends ReanimationScreen implements ActionBar.OnNavigationListener {

    TestFragmentAdapter mAdapter;
    ViewPager mPager;
    PageIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentation);

        // Show the Up button in the action bar.
        getActionBar().setDisplayHomeAsUpEnabled(true);

        mAdapter = new TestFragmentAdapter(getSupportFragmentManager());

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);


        mIndicator = (TitlePageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);

        final ActionBar actionbar = getActionBar();
        //actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        ArrayList<String> itemList = new ArrayList<String>();
        itemList.add("Erstbefund");
        itemList.add("Maßnahmen");
        itemList.add("Verlauf");
        itemList.add("Übergabe");
        itemList.add("Einsatzdaten");
        ArrayAdapter<String> aAdpt = new ArrayAdapter<String>(actionbar.getThemedContext(), android.R.layout.simple_list_item_1, android.R.id.text1, itemList);


        actionbar.setListNavigationCallbacks(aAdpt, this);


    }

    @Override
    public boolean onNavigationItemSelected(int i, long l) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, DocumentationActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        MenuItem undo = menu.findItem(R.id.undo);
        undo.setVisible(false);


        return true;
    }
}
