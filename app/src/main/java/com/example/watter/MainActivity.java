package com.example.watter;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edNext;
    private EditText edMonthly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        edMonthly = findViewById(R.id.month);
        edNext = findViewById(R.id.next);
    }

    public void fee(View view) {
        String monthString = edMonthly.getText().toString();
        if (!TextUtils.isEmpty(monthString)) {
            float degree = Float.parseFloat(monthString);
            float fee = 0;
            if (degree >= 1 && degree <=10) {
                fee = degree*7.35f;
            } else if (degree >= 11 && degree <=30) {
                fee = degree * 9.45f - 21;
            } else if (degree >= 31 && degree <=50) {
                fee = degree * 11.55f - 84;
            } else {
                fee = degree * 12.075f - 110.5f;
            }
            new AlertDialog.Builder(this)
                    .setTitle("month")
                    .setMessage("Fee: " + fee)
                    .setPositiveButton("OK", null)
                    .show();
        } else {
            String nextString = edNext.getText().toString();
            if (!TextUtils.isEmpty(nextString)) {
                float degree = Float.parseFloat(nextString);
                float fee = 0;
                if (degree >= 1 && degree <=10) {
                    fee = degree*7.35f;
                } else if (degree >= 21 && degree <=60) {
                    fee = degree * 9.45f - 42;
                } else if (degree >= 61 && degree <=100) {
                    fee = degree * 11.55f - 168;
                } else {
                    fee = degree * 12.075f - 220.5f;
                }
                new AlertDialog.Builder(this)
                        .setTitle("next")
                        .setMessage("Fee: " + fee)
                        .setPositiveButton("OK", null)
                        .show();

            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
