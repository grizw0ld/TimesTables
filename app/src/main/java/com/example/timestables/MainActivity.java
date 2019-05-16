package com.example.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar numSelect;
    TextView numView;
    ListView ttListView;
    MyAdapter arrayAdapter;
    int clickCntr;
    int num;

    public ArrayList<String> timeser(int x){
        ArrayList<String> rtn = new ArrayList<String>();
        for(int i = 1; i < 21; i++ ){
            rtn.add(String.valueOf(num*i));
        }
        return rtn;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numSelect = findViewById(R.id.numberSeekBar);
        numView = findViewById(R.id.numberTextView);
        ttListView = findViewById(R.id.ttListView);



        numSelect.setMax(20);

        numSelect.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Log", "Progress" + progress);
                num = progress;
                numView.setText("" + num);

                 arrayAdapter =
                         new MyAdapter(getApplicationContext(),android.R.layout.simple_list_item_1, timeser(progress));
                 ttListView.setAdapter(arrayAdapter);
                 clickCntr = 0;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ttListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                arrayAdapter.toggleItem(position);
                String tempStr = ((TextView)view).getText().toString();
                ((TextView)view).setText(""+num+" * "+(position+1)+" = " + tempStr);

            }
            
        });


    }
}
