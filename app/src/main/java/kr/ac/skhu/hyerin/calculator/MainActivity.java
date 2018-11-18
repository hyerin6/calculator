package kr.ac.skhu.hyerin.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;
import java.util.StringTokenizer;

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


        public int operator(String s){
            if(s == "+" || s == "-") return 1;
            else return 2;
        }

        public void onClick(View v) {
            EditText e = (EditText) findViewById(R.id.e);
            TextView textView = (TextView) findViewById(R.id.textview);
            String buttonStr = ((Button) v).getText().toString();

            if (buttonStr.equals("AC")) { //AC 누르면 (이전 결과 창 제외) 전부 삭제
                e.setText("");
                s = "";
            }

            else if (buttonStr.equals("=")) {
                StringTokenizer st_num = new StringTokenizer(s, "+-/* ");
                StringTokenizer st_oper = new StringTokenizer(s, "1234567890 ");

                Integer[] numarr = new Integer[st_num.countTokens()];
                String[] strarr = new String[st_oper.countTokens()];
                Object[] expression = new Object[st_num.countTokens() + st_oper.countTokens()];
                Stack<String> stack = new Stack<String>();

                int i = 0;
                while (st_oper.hasMoreTokens()) {
                    String oper = st_oper.nextToken();
                    strarr[i] = oper;
                    i++;
                }

                i = 0;
                while(st_num.hasMoreTokens()) {
                    int num = Integer.parseInt(st_num.nextToken());
                    numarr[i] = num;
                    i++;
                }


                // 후위표기법으로 사칙연산
                /*
                int num1 = 0, num2 = 0;
		int a = 1;
		int result = 0;

		Stack<Integer> stack2 = new Stack<Integer>();


		for(l = 0; l<expression.length; l++) {
			if(expression[l].equals("+")) {
				num1 = stack2.pop();
				num2 = stack2.pop();
				result = num1 + num2;
				stack2.push(result);
			}
			else if(expression[l].equals("-")) {
				num1 = stack2.pop();
				num2 = stack2.pop();
				result = num2 - num1;
				stack2.push(result);
			}
			else if(expression[l].equals("*")) {
				num1 = stack2.pop();
				num2 = stack2.pop();
				result = num1 * num2;
				stack2.push(result);
			}
			else if(expression[l].equals("/")) {
				num1 = stack2.pop();
				num2 = stack2.pop();
				result = num2 / num1;
				stack2.push(result);
			}
			else{
				stack2.push((int)expression[l]);
			}
		}
		System.out.println("result = "+stack2.pop());
                 */

            }

            else {
                s += buttonStr;
                e.setText(s);
            }
        }
    }
}