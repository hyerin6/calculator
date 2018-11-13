package kr.ac.skhu.hyerin.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // final EditText e = (EditText)findViewById(R.id.e);
        final TextView textView = (TextView)findViewById(R.id.textview);

        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = (Button)findViewById(R.id.button6);
        Button button7 = (Button)findViewById(R.id.button7);
        Button button8 = (Button)findViewById(R.id.button8);
        Button button9 = (Button)findViewById(R.id.button9);
        Button button10 = (Button)findViewById(R.id.buttonC);
        Button button11 = (Button)findViewById(R.id.buttonD);
        Button button12 = (Button)findViewById(R.id.buttonM);
        Button button13 = (Button)findViewById(R.id.buttonP);
        Button button14 = (Button)findViewById(R.id.buttonR);
        Button button15 = (Button)findViewById(R.id.buttonX);
        Button button16 = (Button)findViewById(R.id.button0);

        MyListener listener = new MyListener();

        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        button10.setOnClickListener(listener);
        button11.setOnClickListener(listener);
        button12.setOnClickListener(listener);
        button13.setOnClickListener(listener);
        button14.setOnClickListener(listener);
        button15.setOnClickListener(listener);
        button16.setOnClickListener(listener);
    }


    class MyListener implements View.OnClickListener{
        public void onClick(View v){
            EditText e = (EditText)findViewById(R.id.e);
            String buttonStr = ((Button)v).getText().toString();

            if(buttonStr.equals("AC")) { //AC 누르면 전부 삭제
                e.setText("");
                s = "";
            }
            else {
                s += buttonStr;
                e.setText(s);
            }
        }
    }
}

