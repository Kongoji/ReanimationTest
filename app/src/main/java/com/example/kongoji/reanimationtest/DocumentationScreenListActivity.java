package com.example.kongoji.reanimationtest;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;


/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link DocumentationScreenDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link DocumentationScreenListFragment} and the item details
 * (if present) is a {@link DocumentationScreenDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link DocumentationScreenListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class DocumentationScreenListActivity extends ReanimationScreen
        implements DocumentationScreenListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentationscreen_list);

        if (findViewById(R.id.documentationscreen_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((DocumentationScreenListFragment) getFragmentManager()
                    .findFragmentById(R.id.documentationscreen_list))
                    .setActivateOnItemClick(true);
        }

        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Callback method from {@link DocumentationScreenListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(DocumentationScreenDetailFragment.ARG_ITEM_ID, id);
            DocumentationScreenDetailFragment fragment = new DocumentationScreenDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .replace(R.id.documentationscreen_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, DocumentationScreenDetailActivity.class);
            detailIntent.putExtra(DocumentationScreenDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        MenuItem undo = menu.findItem(R.id.undo);
        undo.setVisible(false);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //perhaps use intent if needed but i'm sure there's a specific intent action for up you can use to handle
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
