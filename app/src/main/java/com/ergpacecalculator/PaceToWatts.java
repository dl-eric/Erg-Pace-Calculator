package com.ergpacecalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class PaceToWatts extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_to_watts);
    }

    public void calculate(View v)
    {
        EditText mSplitET = (EditText)findViewById(R.id.mSplitInput);
        EditText sSplitET = (EditText)findViewById(R.id.sSplitInput);
        EditText msSplitET = (EditText)findViewById(R.id.msSplitInput);

        int mSplit = Integer.parseInt(mSplitET.getText().toString());
        int sSplit = Integer.parseInt(sSplitET.getText().toString());
        int msSplit = Integer.parseInt(msSplitET.getText().toString());

        double pace = mSplit * 600 + sSplit * 10 + msSplit;

        pace = pace / 5000;

        TextView outputWatts = (TextView)findViewById(R.id.wattsOutput);
        DecimalFormat df = new DecimalFormat("#.#");
        outputWatts.setText(df.format((2.80/(Math.pow(pace, 3)))) + "");
    }
}
