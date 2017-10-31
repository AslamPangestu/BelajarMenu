package com.example.mvryan.appmenuandwidget;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by mvryan on 20/10/17.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opt1:
                Log.i("Status", "Option One Selected");
                return true;
            case R.id.opt2:
                Log.i("Status", "Option Two Selected");
                return true;
            case R.id.opt3:
                Log.i("Status", "Option Three Selected");
                return true;
            case R.id.sub1:
                Log.i("Status", "SubOption One Selected");
                return true;
            case R.id.sub2:
                Log.i("Status", "subOption Two Selected");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
