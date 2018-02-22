package com.example.olenakolesnyk.wifinetworkapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by olena.kolesnyk on 17/02/2018.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ArrayList<String> wifiList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ListView mWifiListView = findViewById(R.id.wifi_list);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(this,
                R.layout.wifi_item,
                R.id.wifi_network_title,
                wifiList);
        mWifiListView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_wifi:

                final TextView textView = new TextView(this);
                final EditText editText = new EditText(this);
                final RelativeLayout.LayoutParams params
                        = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                editText.setLayoutParams(params);
                textView.setText(R.string.text_view_str);

                final LinearLayout layout = new LinearLayout(this);
                layout.addView(textView);
                layout.addView(editText);

                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setView(layout)
                        .setPositiveButton(
                                "Create WiFi network", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String wifiNetwork = String.valueOf(editText.getText());
                                        wifiList.add(wifiNetwork);
                                        Log.d(TAG, "WiFi to add: " + wifiNetwork);
                                    }
                                })
                        .create();

                dialog.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
