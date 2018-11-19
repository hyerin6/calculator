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

        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = (Button)findViewById(R.id.button6);
        Button button7 = (Button)findViewById(R.id.button7);
        Button button8 = (Button)findViewById(R.id.button8);
        Button button9 = (Button)findViewById(R.id.button9);
        Button button0 = (Button)findViewById(R.id.button0);
        Button buttonAC = (Button)findViewById(R.id.buttonAC);
        Button buttonmul = (Button)findViewById(R.id.buttonmul);
        Button buttonsub = (Button)findViewById(R.id.buttonsub);
        Button buttonPlus = (Button)findViewById(R.id.buttonPlus);
        Button buttondiv = (Button)findViewById(R.id.buttondiv);
        Button buttonR = (Button)findViewById(R.id.buttonR);

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
        button0.setOnClickListener(listener);
        buttonAC.setOnClickListener(listener);
        buttondiv.setOnClickListener(listener);
        buttonmul.setOnClickListener(listener);
        buttonR.setOnClickListener(listener);
        buttonPlus.setOnClickListener(listener);
        buttonsub.setOnClickListener(listener);
    }


    class MyListener implements View.OnClickListener{
        public void onClick(View v) {
            EditText e = (EditText) findViewById(R.id.e);
            TextView textView = (TextView) findViewById(R.id.textview);
            String buttonStr = ((Button) v).getText().toString();

            if (buttonStr.equals("AC")) { //AC 누르면 (이전 결과 창 제외) 전부 삭제
                e.setText("");
                s = "";
            }

            else if (buttonStr.equals("=")) {
               /*
                Stack stack = new Stack();
                String[] expression = s.split(" ");
                String[] expression2 = new String[expression.length];

                int i = 0;
                for (String s1 : expression) {
                    switch (s1) {
                        case "+":
                        case "-":
                            if (stack.isEmpty()) {
                                stack.push(s1);
                                break;
                            }
                            while (!stack.isEmpty()) {
                                expression2[i] = (String) stack.pop();
                                i++;
                            }
                            stack.push(s1);
                            break;

                        case "*":
                        case "/":
                            if (stack.isEmpty()) {
                                stack.push(s1);
                                break;
                            }
                            String operator = (String) stack.peek();
                            if (operator == "*" || operator == "/") {
                                while (!stack.isEmpty()) {
                                    expression2[i] = (String) stack.pop();
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
                }
                while (!stack.isEmpty()) {
                    expression2[i] = (String) stack.pop();
                    i++;
                }

                int num1, num2;
                int result;

                Stack<Integer> stack2 = new Stack<Integer>();

                for (i = 0; i < expression2.length; i++) {
                    if (expression2[i].equals("+")) {
                        num1 = stack2.pop();
                        num2 = stack2.pop();
                        result = num1 + num2;
                        stack2.push(result);
                    } else if (expression2[i].equals("-")) {
                        num1 = stack2.pop();
                        num2 = stack2.pop();
                        result = num2 - num1;
                        stack2.push(result);
                    } else if (expression2[i].equals("*")) {
                        num1 = stack2.pop();
                        num2 = stack2.pop();
                        result = num1 * num2;
                        stack2.push(result);
                    } else if (expression2[i].equals("/")) {
                        num1 = stack2.pop();
                        num2 = stack2.pop();
                        result = num2 / num1;
                        stack2.push(result);
                    } else
                        stack2.push(Integer.parseInt(expression2[i]));
                }
		        textView.setText((stack2.pop()));
		        */
            }

            else {
                s += buttonStr+" ";
                e.setText(s);
            }
        }
    }
}