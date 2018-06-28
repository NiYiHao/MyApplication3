package com.example.administrator.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout background;
    private EditText edred,edgreen,edblue;
    private SeekBar seekred,seekgreen,seekblue;
    private int pos1,pos2,pos3;
    private int redvalue,greenvalue,bluevalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        background = findViewById(R.id.background);
        edred = findViewById(R.id.edRed);
        edgreen = findViewById(R.id.edGreen);
        edblue = findViewById(R.id.edBlue);
        seekred = findViewById(R.id.seekRed);
        seekgreen = findViewById(R.id.seekGreen);
        seekblue = findViewById(R.id.seekBlue);
        edred.setSelection( edred.getText().toString().length());
        edgreen.setSelection( edgreen.getText().toString().length() );
        edblue.setSelection( edblue.getText().toString().length() );

        pos1 = 255;
        pos2=255;
        pos3=255;

        seekred.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            //拖移的立即反應
            public void onProgressChanged(SeekBar seekBar, int r, boolean fromUser) {
            background.setBackgroundColor(Color.rgb(r,pos2,pos3));
            edred.setText(String.valueOf(r));
            pos1=r;
            }
            //點擊seekbar時的反應
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            //拖移結束seekbar才會反應
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekgreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int g, boolean fromUser) {
            background.setBackgroundColor(Color.rgb(pos1,g,pos3));
            edgreen.setText(String.valueOf(g));
            pos2=g;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekblue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int b, boolean fromUser) {
            background.setBackgroundColor(Color.rgb(pos1,pos2,b));
            edblue.setText(String.valueOf(b));
            pos3=b;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//        edred.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                String progress=edred.getText().toString();
//                int progressvalue = Integer.parseInt(progress);
//                seekred.setProgress(progressvalue);
//                return false;
//            }
//        });
//        edgreen.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                String progress=edgreen.getText().toString();
//                int progressvalue = Integer.parseInt(progress);
//                seekgreen.setProgress(progressvalue);
//                return false;
//            }
//        });
//        edblue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                String progress=edblue.getText().toString();
//                int progressvalue = Integer.parseInt(progress);
//                seekblue.setProgress(progressvalue);
//                return false;
//            }
//        });
    edred.addTextChangedListener( new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try{
                pos1=Integer.parseInt( s.toString() );
            }catch(Exception e){
                pos1=0;
            }
            seekred.setProgress( pos1 );
            background.setBackgroundColor( Color.rgb( pos1,pos2,pos3 ));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    } );
    edgreen.addTextChangedListener( new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try{
                pos2=Integer.parseInt( s.toString() );
            }catch(Exception e){
                pos2=0;
            }
            seekgreen.setProgress( pos2 );
            background.setBackgroundColor( Color.rgb( pos1,pos2,pos3 ));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    } );
    edblue.addTextChangedListener( new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try{
                pos3=Integer.parseInt( s.toString() );
            }catch(Exception e){
                pos3=0;
            }
            seekblue.setProgress( pos3 );
            background.setBackgroundColor( Color.rgb( pos1,pos2,pos3 ));
        }


        @Override
        public void afterTextChanged(Editable s) {

        }
    } );
    }
}
