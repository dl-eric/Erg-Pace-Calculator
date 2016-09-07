package com.ergpacecalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class Time extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
    }

    public void calculate(View v)
    {
        EditText distanceET = (EditText)findViewById(R.id.distanceInput);
        EditText mSplitET = (EditText)findViewById(R.id.mSplitInput);
        EditText sSplitET = (EditText)findViewById(R.id.sSplitInput);

        int distance = Integer.parseInt(distanceET.getText().toString());
        int mSplit = Integer.parseInt(mSplitET.getText().toString());
        int sSplit = Integer.parseInt(sSplitET.getText().toString());

        int split = mSplit * 60 + sSplit;
        double time = split * ((double)distance/500);

        TextView outputTime = (TextView)findViewById(R.id.timeOutput);
        DecimalFormat minuteDf = new DecimalFormat("00");
        String minute = minuteDf.format((int)time%60);
        outputTime.setText((int) time / 60 + ":" + minute);
    }
}
