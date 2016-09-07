package com.ergpacecalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void onClickPace(View view)
    {
        Intent i = new Intent(this, PaceCalculator.class);
        startActivity(i);
    }

    public void onClickWatt(View view)
    {
        Intent i = new Intent(this, WattCalculator.class);
        startActivity(i);
    }
}
