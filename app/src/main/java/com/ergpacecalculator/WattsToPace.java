package com.ergpacecalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class WattsToPace extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watts_to_pace);
    }

    public void calculate(View v)
    {
        EditText wattsET = (EditText)findViewById(R.id.wattsInput);

        double watts = Double.parseDouble(wattsET.getText().toString());

        double pace = Math.cbrt(2.80/watts) * 500;

        int mSplit = (int)pace / 60;
        int sSplit = (int)pace % 60;
        int msSplit = (int)(pace * 100) % 100 / 10;

        TextView outputSplit = (TextView)findViewById(R.id.splitOutput);
        outputSplit.setText(mSplit + ":" + sSplit + "." + msSplit);
    }
}
