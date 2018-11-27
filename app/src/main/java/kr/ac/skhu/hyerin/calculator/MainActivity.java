package kr.ac.skhu.hyerin.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    String s = "";
    

    Button.OnClickListener t;

    {
        t = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e = findViewById(R.id.e);
                TextView textView = findViewById(R.id.textview);
                String buttonStr = ((Button) v).getText().toString();


                switch (buttonStr) {
                    case "AC":  //AC 누르면 (이전 결과 창 제외) 전부 삭제
                        s = "";
                        e.setText(s);
                        break;
                    case "=":
                        Stack<String> stack = new Stack<>();
                        String[] expression = s.split(" ");
                        String[] expression2 = new String[expression.length];
                        int i = 0;
                        for (String s1 : expression)
                            switch (s1) {
                                case "+":
                                case "-":
                                    if (stack.isEmpty()) {
                                        stack.push(s1);
                                        break;
                                    }
                                    while (!stack.isEmpty()) {
                                        expression2[i] = stack.pop();
                                        i++;
                                    }
                                    stack.push(s1);
                                    break;
                                case "×":
                                case "/":
                                    if (stack.isEmpty()) {
                                        stack.push(s1);
                                        break;
                                    }
                                    String operator = stack.peek();
                                    if (operator.compareTo("×") == 0 || operator.compareTo("/") == 0) {
                                        while (!stack.isEmpty()) {
                                            expression2[i] = stack.pop();
                                            i++;
                                        }
                                    } else {
                                        stack.push(s1);
                                        break;
                                    }
                                default:
                                    expression2[i] = s1;
                                    i++;
                            }
                        while (!stack.isEmpty()) {
                            expression2[i] = stack.pop();
                            i++;
                        }
                        int num1, num2;
                        int result;
                        Stack<Integer> stack2 = new Stack<>();
                        for (i = 0; i < expression2.length; i++) {
                            switch (expression2[i]) {
                                case "+":
                                    num1 = stack2.pop();
                                    num2 = stack2.pop();
                                    result = num1 + num2;
                                    stack2.push(result);
                                    break;
                                case "-":
                                    num1 = stack2.pop();
                                    num2 = stack2.pop();
                                    result = num2 - num1;
                                    stack2.push(result);
                                    break;
                                case "×":
                                    num1 = stack2.pop();
                                    num2 = stack2.pop();
                                    result = num1 * num2;
                                    stack2.push(result);
                                    break;
                                case "/":
                                    num1 = stack2.pop();
                                    num2 = stack2.pop();
                                    result = num2 / num1;
                                    stack2.push(result);
                                    break;
                                default:
                                    stack2.push(Integer.parseInt(expression2[i]));
                                    break;
                            }
                        }
                        result = stack2.pop();
                        textView.setText(result);

                        break;
                    default:
                        s += buttonStr + " ";
                        e.setText(s);
                        break;
                }
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(t);
        findViewById(R.id.button2).setOnClickListener(t);
        findViewById(R.id.button3).setOnClickListener(t);
        findViewById(R.id.button4).setOnClickListener(t);
        findViewById(R.id.button5).setOnClickListener(t);
        findViewById(R.id.button6).setOnClickListener(t);
        findViewById(R.id.button7).setOnClickListener(t);
        findViewById(R.id.button8).setOnClickListener(t);
        findViewById(R.id.button9).setOnClickListener(t);
        findViewById(R.id.button0).setOnClickListener(t);
        findViewById(R.id.buttonAC).setOnClickListener(t);
        findViewById(R.id.buttonmul).setOnClickListener(t);
        findViewById(R.id.buttonsub).setOnClickListener(t);
        findViewById(R.id.buttonPlus).setOnClickListener(t);
        findViewById(R.id.buttondiv).setOnClickListener(t);
        findViewById(R.id.buttonR).setOnClickListener(t);

    }
}
