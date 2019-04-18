package com.example.prajwal.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView tables;

    public void generateTables(int number){

        ArrayList<String> tableList = new ArrayList<String>(10);
        for(int i=0; i<=10; i++){
            tableList.add((Integer.toString(number*i)));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tableList);
        tables.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar = (SeekBar) findViewById(R.id.timesTableSeekBar);
        tables = (ListView) findViewById(R.id.listView);

        timesTableSeekBar.setMax(20);
        timesTableSeekBar.setProgress(10);

        generateTables(10);


        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min=1;
                if(i<min){
                    i=min;
                    timesTableSeekBar.setProgress(min);
                }
                generateTables(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
