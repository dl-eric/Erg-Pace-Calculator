package com.ergpacecalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class PaceCalculator extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);
    }

    public void onClickSplit(View view)
    {
        Intent i = new Intent(this, Split.class);
        startActivity(i);
    }

    public void onClickDistance(View view)
    {
        Intent i = new Intent(this, Distance.class);
        startActivity(i);
    }

    public void onClickTime(View view)
    {
        Intent i = new Intent(this, Time.class);
        startActivity(i);
    }
}
