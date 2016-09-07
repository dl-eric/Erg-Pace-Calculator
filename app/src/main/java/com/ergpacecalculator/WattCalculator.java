package com.ergpacecalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class WattCalculator extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watt_calculator);
    }

    public void onClickPtW(View view)
    {
        Intent i = new Intent(this, PaceToWatts.class);
        startActivity(i);
    }

    public void onClickWtP(View view)
    {
        Intent i = new Intent(this, WattsToPace.class);
        startActivity(i);
    }
}
