package com.example.mvryan.appmenuandwidget;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mvryan on 20/10/17.
 */

public class ContextualActionModeMenu extends Activity implements View.OnLongClickListener {
    private ActionMode.Callback mActionModeCallBack;
    private ActionMode mActionMode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpel_layout);
        mActionModeCallBack = new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                actionMode.setTitle("Setting");
                MenuInflater inflater = actionMode.getMenuInflater();
                inflater.inflate(R.menu.action_context, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_share:
                        Toast.makeText(getApplicationContext(), "Options share clicked", Toast.LENGTH_SHORT).show();
                        actionMode.finish();
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
                mActionMode = null;
            }
        };
        TextView tv = (TextView) findViewById(R.id.txt1);
        tv.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        if (mActionMode != null) {
            return false;
        }
        mActionMode = this.startActionMode(mActionModeCallBack);
        view.setSelected(true);
        return true;
    }
}
