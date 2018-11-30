package kr.ac.skhu.hyerin.calculator;

package kr.ac.skhu.kimparkjang.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    TextView textView;
    String s = "";
    String buttonStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.e);
        textView = findViewById(R.id.textview);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button0 = findViewById(R.id.button0);
        Button buttonp = findViewById(R.id.buttonPlus);
        Button buttond = findViewById(R.id.buttondiv);
        Button buttonm = findViewById(R.id.buttonmul);
        Button buttonre = findViewById(R.id.buttonR);
        Button buttonac = findViewById(R.id.buttonAC);
        Button buttons = findViewById(R.id.buttonsub);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonp.setOnClickListener(this);
        buttonm.setOnClickListener(this);
        buttond.setOnClickListener(this);
        buttons.setOnClickListener(this);
        buttonre.setOnClickListener(this);
        buttonac.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        buttonStr = ((Button) v).getText().toString();

        switch (buttonStr) {
            case "AC":
                editText.setText("");
                s = "";
                break;
            case "=":
                Stack<String> stack = new Stack<>();
                String[] expression = s.split(" ");
                String[] expression2 = new String[expression.length];

                int num1, num2;
                int result;
                Stack<Integer> stack2 = new Stack<>();



                int i=0;
                for (String s1 : expression) {
                    switch(s1) {
                        case "+":
                        case "-":
                            if(stack.isEmpty()) {
                                stack.push(s1);
                                break;
                            }
                            while(!stack.isEmpty()) {
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
                            if (operator == "×" || operator == "/" ) {
                                while(!stack.isEmpty()) {
                                    expression2[i] = stack.pop();
                                    i++;
                                }
                            }
                            else {
                                stack.push(s1);
                                break;
                            }
                        default:
                            expression2[i] = s1;
                            i++;
                    }
                }
                while(!stack.isEmpty()) {
                    expression2[i] = stack.pop();
                    i++;
                }

                for(i = 0; i<expression2.length; i++) {
                    if(expression2[i].equals("+")) {
                        num1 = stack2.pop();
                        num2 = stack2.pop();
                        result = num1 + num2;
                        stack2.push(result);
                    }
                    else if(expression2[i].equals("-")) {
                        num1 = stack2.pop();
                        num2 = stack2.pop();
                        result = num2 - num1;
                        stack2.push(result);
                    }
                    else if(expression2[i].equals("×")) {
                        num1 = stack2.pop();
                        num2 = stack2.pop();
                        result = num1 * num2;
                        stack2.push(result);
                    }
                    else if(expression2[i].equals("/")) {
                        num1 = stack2.pop();
                        num2 = stack2.pop();
                        result = num2 / num1;
                        stack2.push(result);
                    }
                    else
                        stack2.push(Integer.parseInt(expression2[i]));
                }

                result = stack2.pop();
                textView.setText(String.valueOf(result));
                break;

            default:
                s += buttonStr + " ";
                editText.setText(s);
                break;
        }
    }
}
