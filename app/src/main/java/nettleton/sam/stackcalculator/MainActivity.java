package nettleton.sam.stackcalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;

public class MainActivity extends AppCompatActivity {

    public TextView numberField;
    public List<Double> doubleValues = new ArrayList<>();
    public Animation animFadein;
    public Animation animFadeinLong;
    private CoordinatorLayout coordinatorLayout;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);
        numberField = (TextView) findViewById(R.id.number_field);
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        animFadeinLong = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_long);

        final TextView signPlus = (TextView) findViewById(R.id.sign_plus);
        signPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (currentString.length() == 0) {
                    numberField.setText("+");
                }
                signPlus.startAnimation(animFadein);
            }
        });
        final TextView signMinus = (TextView) findViewById(R.id.sign_minus);
        signMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (currentString.length() == 0) {
                    numberField.setText("-");
                }
                signMinus.startAnimation(animFadein);
            }
        });
        final TextView signMult = (TextView) findViewById(R.id.sign_mult);
        signMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (currentString.length() == 0) {
                    numberField.setText("x");
                }
                signMult.startAnimation(animFadein);
            }
        });
        final TextView signDiv = (TextView) findViewById(R.id.sign_div);
        signDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (currentString.length() == 0) {
                    numberField.setText("÷");
                }
                signDiv.startAnimation(animFadein);
            }
        });
        final TextView signPi = (TextView) findViewById(R.id.sign_pi);
        signPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (currentString.length() == 0) {
                    numberField.setText("π");
                }
                signPi.startAnimation(animFadein);
            }
        });
        final TextView signE = (TextView) findViewById(R.id.sign_e);
        signE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (currentString.length() == 0) {
                    numberField.setText("e");
                }
                signE.startAnimation(animFadein);
            }
        });
        final TextView signExp = (TextView) findViewById(R.id.sign_exp);
        signExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (currentString.length() == 0) {
                    numberField.setText("^");
                }
                signExp.startAnimation(animFadein);
            }
        });
        final TextView signEnter = (TextView) findViewById(R.id.sign_enter);
        signEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                Snackbar smallStack = Snackbar.make(coordinatorLayout,
                        "Operations require at least two values on the stack!", Snackbar.LENGTH_LONG);
                //If screen has values in box
                if (currentString.length() != 0) {
                    //If the value is pi
                    if (currentString.equals("π")) {
                        doubleValues.add(Math.PI);
                        //If the value is e
                    } else if (currentString.equals("e")) {
                        doubleValues.add(Math.E);
                        //If the value is an operation
                    } else if (currentString.equals("+") || currentString.equals("x") || currentString.equals("-") ||
                            currentString.equals("÷") || currentString.equals("^")) {
                        //Do operation if there are values available
                        if (doubleValues.size() >= 2) {
                            operation(currentString);
                            //Else display error for invalid time for operation
                        } else {
                            smallStack.show();
                        }
                    } else {
                        doubleValues.add(Double.parseDouble(currentString));
                    }
                    signEnter.startAnimation(animFadein);
                    fillDisplay();
                    numberField.setText("");
                    //  }
                }

            }
        });
        final TextView num0 = (TextView) findViewById(R.id.num_0);
        num0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (!(currentString.equals("+") || currentString.equals("x") || currentString.equals("-") ||
                        currentString.equals("÷") || currentString.equals("^") ||
                        currentString.equals("e") || currentString.equals("π"))) {
                    numberField.append("0");
                }
                num0.startAnimation(animFadein);
            }
        });
        final TextView num1 = (TextView) findViewById(R.id.num_1);
        num1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (!(currentString.equals("+") || currentString.equals("x") || currentString.equals("-") ||
                        currentString.equals("÷") || currentString.equals("^") ||
                        currentString.equals("e") || currentString.equals("π"))) {
                    numberField.append("1");
                }
                num1.startAnimation(animFadein);
            }
        });
        final TextView num2 = (TextView) findViewById(R.id.num_2);
        num2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (!(currentString.equals("+") || currentString.equals("x") || currentString.equals("-") ||
                        currentString.equals("÷") || currentString.equals("^") ||
                        currentString.equals("e") || currentString.equals("π"))) {
                    numberField.append("2");
                }
                num2.startAnimation(animFadein);
            }
        });
        final TextView num3 = (TextView) findViewById(R.id.num_3);
        num3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (!(currentString.equals("+") || currentString.equals("x") || currentString.equals("-") ||
                        currentString.equals("÷") || currentString.equals("^") ||
                        currentString.equals("e") || currentString.equals("π"))) {
                    numberField.append("3");
                }
                num3.startAnimation(animFadein);
            }
        });
        final TextView num4 = (TextView) findViewById(R.id.num_4);
        num4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (!(currentString.equals("+") || currentString.equals("x") || currentString.equals("-") ||
                        currentString.equals("÷") || currentString.equals("^") ||
                        currentString.equals("e") || currentString.equals("π"))) {
                    numberField.append("4");
                }
                num4.startAnimation(animFadein);
            }
        });
        final TextView num5 = (TextView) findViewById(R.id.num_5);
        num5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (!(currentString.equals("+") || currentString.equals("x") || currentString.equals("-") ||
                        currentString.equals("÷") || currentString.equals("^") ||
                        currentString.equals("e") || currentString.equals("π"))) {
                    numberField.append("5");
                }
                num5.startAnimation(animFadein);
            }
        });
        final TextView num6 = (TextView) findViewById(R.id.num_6);
        num6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (!(currentString.equals("+") || currentString.equals("x") || currentString.equals("-") ||
                        currentString.equals("÷") || currentString.equals("^") ||
                        currentString.equals("e") || currentString.equals("π"))) {
                    numberField.append("6");
                }
                num6.startAnimation(animFadein);
            }
        });
        final TextView num7 = (TextView) findViewById(R.id.num_7);
        num7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (!(currentString.equals("+") || currentString.equals("x") || currentString.equals("-") ||
                        currentString.equals("÷") || currentString.equals("^") ||
                        currentString.equals("e") || currentString.equals("π"))) {
                    numberField.append("7");
                }
                num7.startAnimation(animFadein);
            }
        });
        final TextView num8 = (TextView) findViewById(R.id.num_8);
        num8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (!(currentString.equals("+") || currentString.equals("x") || currentString.equals("-") ||
                        currentString.equals("÷") || currentString.equals("^") ||
                        currentString.equals("e") || currentString.equals("π"))) {
                    numberField.append("8");
                }
                num8.startAnimation(animFadein);
            }
        });
        final TextView num9 = (TextView) findViewById(R.id.num_9);
        num9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                if (!(currentString.equals("+") || currentString.equals("x") || currentString.equals("-") ||
                        currentString.equals("÷") || currentString.equals("^") ||
                        currentString.equals("e") || currentString.equals("π"))) {
                    numberField.append("9");
                }
                num9.startAnimation(animFadein);
            }
        });
        final TextView signDec = (TextView) findViewById(R.id.sign_dec);
        signDec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String currentString = numberField.getText().toString();
                Boolean decInString = Boolean.FALSE;
                for (int i = 0; i < currentString.length(); i++) {
                    if (String.valueOf(currentString.charAt(i)).equals(".")) {
                        decInString = Boolean.TRUE;
                    }
                }
                if ((!(currentString.equals("+") || currentString.equals("x") || currentString.equals("-") ||
                        currentString.equals("÷") || currentString.equals("^") ||
                        currentString.equals("e") || currentString.equals("π"))) && (!decInString)) {
                    numberField.append(".");
                }
                signDec.startAnimation(animFadein);
            }
        });
        final TextView signClr = (TextView) findViewById(R.id.sign_clr);
        signClr.setOnClickListener(new View.OnClickListener() {
             public void onClick(View view) {
                 String currentString = numberField.getText().toString();
                 if (currentString.length() != 0) {
                     numberField.setText(currentString.substring(0, currentString.length() - 1));
                 } else if ((currentString.length() == 0) && (doubleValues.size() >= 1)) {
                     doubleValues = doubleValues.subList(0, (doubleValues.size() - 1));
                     fillDisplay();
                 }
                 signClr.startAnimation(animFadein);
             }
         });
        signClr.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                doubleValues = doubleValues.subList(0, 0);
                fillDisplay();
                numberField.setText("");
                signClr.startAnimation(animFadeinLong);
                return true;
            }
        });
    }

    public void fillDisplay() {
        TextView stack1 = (TextView) findViewById(R.id.stack_1);
        TextView stack2 = (TextView) findViewById(R.id.stack_2);
        TextView stack3 = (TextView) findViewById(R.id.stack_3);
        TextView stack4 = (TextView) findViewById(R.id.stack_4);
        TextView stack5 = (TextView) findViewById(R.id.stack_5);
        TextView stack6 = (TextView) findViewById(R.id.stack_6);
        stack1.setText("");
        stack2.setText("");
        stack3.setText("");
        stack4.setText("");
        stack5.setText("");
        stack6.setText("");
        if (doubleValues.size() == 1) {
            stack1.setText(String.valueOf(doubleValues.get(0)));
        } else if (doubleValues.size() == 2) {
            stack1.setText(String.valueOf(doubleValues.get(1)));
            stack2.setText(String.valueOf(doubleValues.get(0)));
        } else if (doubleValues.size() == 3) {
            stack1.setText(String.valueOf(doubleValues.get(2)));
            stack2.setText(String.valueOf(doubleValues.get(1)));
            stack3.setText(String.valueOf(doubleValues.get(0)));
        } else if (doubleValues.size() == 4) {
            stack1.setText(String.valueOf(doubleValues.get(3)));
            stack2.setText(String.valueOf(doubleValues.get(2)));
            stack3.setText(String.valueOf(doubleValues.get(1)));
            stack4.setText(String.valueOf(doubleValues.get(0)));
        } else if (doubleValues.size() == 5) {
            stack1.setText(String.valueOf(doubleValues.get(4)));
            stack2.setText(String.valueOf(doubleValues.get(3)));
            stack3.setText(String.valueOf(doubleValues.get(2)));
            stack4.setText(String.valueOf(doubleValues.get(1)));
            stack5.setText(String.valueOf(doubleValues.get(0)));
        } else if (doubleValues.size() >= 6) {
            stack1.setText(String.valueOf(doubleValues.get(doubleValues.size() - 1)));
            stack2.setText(String.valueOf(doubleValues.get(doubleValues.size() - 2)));
            stack3.setText(String.valueOf(doubleValues.get(doubleValues.size() - 3)));
            stack4.setText(String.valueOf(doubleValues.get(doubleValues.size() - 4)));
            stack5.setText(String.valueOf(doubleValues.get(doubleValues.size() - 5)));
            stack6.setText(String.valueOf(doubleValues.get(doubleValues.size() - 6)));
        }
    }

    public void operation(String currentString) {
        double num1 = doubleValues.get(doubleValues.size() - 2);
        double num2 = doubleValues.get(doubleValues.size() - 1);
        doubleValues = doubleValues.subList(0, (doubleValues.size()-2));
        if (currentString.equals("+")) {
            doubleValues.add(num1 + num2);
        } else if (currentString.equals("x")) {
            doubleValues.add(num1 * num2);
        } else if (currentString.equals("-")) {
            doubleValues.add(num1 - num2);
        } else if (currentString.equals("÷")) {
            doubleValues.add(num1 / num2);
        } else if (currentString.equals("^")) {
            doubleValues.add(Math.pow(num1, num2));
        }
    }

}

