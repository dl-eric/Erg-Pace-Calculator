package com.ergpacecalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Distance extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    public void calculate(View v)
    {
        EditText mTimeInputET = (EditText) findViewById(R.id.mTimeInput);
        EditText sTimeInputET = (EditText) findViewById(R.id.sTimeInput);
        EditText mSplitInputET = (EditText) findViewById(R.id.mSplitInput);
        EditText sSplitInputET = (EditText) findViewById(R.id.sSplitInput);

        if(!isEmpty(mTimeInputET) && !isEmpty(sTimeInputET)&& !isEmpty(mSplitInputET) && !isEmpty(sSplitInputET) && Integer.parseInt(mSplitInputET.getText().toString()) + Integer.parseInt(sSplitInputET.getText().toString()) != 0) {
            int mSplitInput = Integer.parseInt(mSplitInputET.getText().toString());
            int sSplitInput = Integer.parseInt(sSplitInputET.getText().toString());
            int mTimeInput = Integer.parseInt(mTimeInputET.getText().toString());
            int sTimeInput = Integer.parseInt(sTimeInputET.getText().toString());
            calculateDistance(mTimeInput, sTimeInput, mSplitInput, sSplitInput);
        }
        else {
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Please fill in both Split(mm:ss) and Time(mm:ss). Make sure that the Split is not 0:00.")
                    .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .show();
        }
    }

    public void calculateDistance(int mTimeInput, int sTimeInput, int mSplitInput, int sSplitInput)
    {
        int time = mTimeInput * 60 + sTimeInput;
        int split = mSplitInput * 60 + sSplitInput;
        double distance = (double)time/split * 500;
        TextView outputDistance = (TextView) findViewById(R.id.distanceOutput);

        outputDistance.setText((int) distance + "");

    }
}
