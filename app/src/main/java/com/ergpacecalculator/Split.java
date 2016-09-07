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

import java.text.DecimalFormat;


public class Split extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split);
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    public void calculate(View v)
    {
        EditText distanceInputET = (EditText) findViewById(R.id.distanceInput);
        EditText mTimeInputET = (EditText) findViewById(R.id.mTimeInput);
        EditText sTimeInputET = (EditText) findViewById(R.id.sTimeInput);

        if(!isEmpty(distanceInputET) && !isEmpty(mTimeInputET) && !isEmpty(sTimeInputET)) {
            int distanceInput = Integer.parseInt(distanceInputET.getText().toString());
            int mTimeInput = Integer.parseInt(mTimeInputET.getText().toString());
            int sTimeInput = Integer.parseInt(sTimeInputET.getText().toString());
            calculateSplit(distanceInput, mTimeInput, sTimeInput);
        }
        else {
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Please fill in both Distance and Time")
                    .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .show();
        }
    }
    public void calculateSplit(int distance, int mTime, int sTime)
    {
        int time = mTime * 60 + sTime;
        double split = 500 * ((double)time/distance);
        TextView outputSplit = (TextView) findViewById(R.id.splitOutput);

        DecimalFormat minuteDf = new DecimalFormat("00");
        String minute = minuteDf.format((int)split%60);
        outputSplit.setText((int) split / 60 + ":" + minute);
    }
}
