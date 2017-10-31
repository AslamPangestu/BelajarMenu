package com.example.mvryan.appmenuandwidget;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by mvryan on 20/10/17.
 */

public class ContextualMultiple extends Activity{
    ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_multiple);
        lv = (ListView) findViewById(R.id.listActionMode);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                new String[]{"Satu","Dua","Tiga"});
        lv.setAdapter(aa);

        lv.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            private int nr = 0;
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
                if (b){
                    nr++;
                }else {
                    nr--;
                }
                actionMode.setTitle(nr + "Selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                nr = 0;
                actionMode.setTitle("Setting");
                MenuInflater inflater = actionMode.getMenuInflater();
                inflater.inflate(R.menu.action_context,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_share:
                        Toast.makeText(getApplicationContext(), "Option share Clicked", Toast.LENGTH_SHORT).show();
                        actionMode.finish();
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        });
    }
}
