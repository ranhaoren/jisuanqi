package com.example.user.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button bt_加;
    private Button bt_减;
    private Button bt_乘;
    private Button bt_除;
    private Button bt_等;
    private Button bt_点;
    private Button bt_百分号;
    private Button bt_后退;
    private Button bt_清除;
    private EditText et_input;
    private String existedText = "";
    private boolean isCounted = false;
    private boolean startWithOperator = false;
    private boolean startWithSubtract = false;
    private boolean noStartWithOperator = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();

    }
    private void initView() {
        num0 = (Button) findViewById(R.id.bt_0);
        num1 = (Button) findViewById(R.id.bt_1);
        num2 = (Button) findViewById(R.id.bt_2);
        num3 = (Button) findViewById(R.id.bt_3);
        num4 = (Button) findViewById(R.id.bt_4);
        num5 = (Button) findViewById(R.id.bt_5);
        num6 = (Button) findViewById(R.id.bt_6);
        num7 = (Button) findViewById(R.id.bt_7);
        num8 = (Button) findViewById(R.id.bt_8);
        num9 = (Button) findViewById(R.id.bt_9);
        bt_加 = (Button) findViewById(R.id.bt_加);
        bt_减 = (Button) findViewById(R.id.bt_减);
        bt_乘 = (Button) findViewById(R.id.bt_乘);
        bt_除 = (Button) findViewById(R.id.bt_除);
        bt_等 = (Button) findViewById(R.id.bt_等);
        bt_点 = (Button) findViewById(R.id.bt_点);
        bt_百分号 = (Button) findViewById(R.id.bt_百分号);
        bt_后退 = (Button) findViewById(R.id.bt_后退);
        bt_清除 = (Button) findViewById(R.id.bt_清除);
        et_input = (EditText) findViewById(R.id.et_input);
        existedText = et_input.getText().toString();

    }
    private void initEvent() {
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);

        bt_加.setOnClickListener(this);
        bt_减.setOnClickListener(this);
        bt_乘.setOnClickListener(this);
        bt_除.setOnClickListener(this);
        bt_等.setOnClickListener(this);

        bt_点.setOnClickListener(this);
        bt_百分号.setOnClickListener(this);
        bt_后退.setOnClickListener(this);
        bt_清除.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_0:
                existedText = isOverRange(existedText, "0");
                break;
            case R.id.bt_1:
                existedText = isOverRange(existedText, "1");
                break;
            case R.id.bt_2:
                existedText = isOverRange(existedText, "2");
                break;
            case R.id.bt_3:
                existedText = isOverRange(existedText, "3");
                break;
            case R.id.bt_4:
                existedText = isOverRange(existedText, "4");
                break;
            case R.id.bt_5:
                existedText = isOverRange(existedText, "5");
                break;
            case R.id.bt_6:
                existedText = isOverRange(existedText, "6");
                break;
            case R.id.bt_7:
                existedText = isOverRange(existedText, "7");
                break;
            case R.id.bt_8:
                existedText = isOverRange(existedText, "8");
                break;
            case R.id.bt_9:
                existedText = isOverRange(existedText, "9");
                break;

            //运算符

            case R.id.bt_加:
                if (!existedText.contains("e")) {

                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")) {

                        } else {
                            existedText += "+";
                        }
                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "+");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText = existedText.replace("×", "+");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText = existedText.replace("÷", "+");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("+")) {
                            existedText += "+";
                        }
                    }
                } else {
                    existedText = "0";
                }

                break;
            case R.id.bt_减:

                if (!existedText.contains("e")) {
                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")) {

                        } else {
                            existedText += "-";
                        }
                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
//                    Log.d("Anonymous", "onClick: " + "进入减法方法");
                            existedText = existedText.replace("+", "-");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText = existedText.replace("×", "-");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText = existedText.replace("÷", "-");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText += "-";
                        }
                    }
                } else {
                    existedText = "0";
                }
                break;
            case R.id.bt_乘:

                if (!existedText.contains("e")) {
                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")) {

                        } else {
                            existedText += "×";
                        }

                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
                            existedText = existedText.replace("+", "×");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "×");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText = existedText.replace("÷", "×");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText += "×";
                        }
                    }
                } else {
                    existedText = "0";
                }
                break;
            case R.id.bt_除:

                if (!existedText.contains("e")) {
                    if (judgeExpression()) {
                        existedText = getResult();
                        if (existedText.equals("error")) {

                        } else {
                            existedText += "÷";
                        }

                    } else {

                        if (isCounted) {
                            isCounted = false;
                        }

                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
                            existedText = existedText.replace("+", "÷");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "÷");
                        } else if ((existedText.substring(existedText.length() - 1)).equals("×")) {
                            existedText = existedText.replace("×", "÷");
                        } else if (!(existedText.substring(existedText.length() - 1)).equals("÷")) {
                            existedText += "÷";
                        }
                    }
                } else {
                    existedText = "0";
                }
                break;
            case R.id.bt_等:
                existedText = getResult();
                isCounted = true;
                break;
            case R.id.bt_点:
                if (!isCounted) {

                    if (existedText.contains("+") || existedText.contains("-") ||
                            existedText.contains("×") || existedText.contains("÷")) {

                        String param1 = null;
                        String param2 = null;

                        if (existedText.contains("+")) {
                            param1 = existedText.substring(0, existedText.indexOf("+"));
                            param2 = existedText.substring(existedText.indexOf("+") + 1);
                        } else if (existedText.contains("-")) {
                            param1 = existedText.substring(0, existedText.indexOf("-"));
                            param2 = existedText.substring(existedText.indexOf("-") + 1);
                        } else if (existedText.contains("×")) {
                            param1 = existedText.substring(0, existedText.indexOf("×"));
                            param2 = existedText.substring(existedText.indexOf("×") + 1);
                        } else if (existedText.contains("÷")) {
                            param1 = existedText.substring(0, existedText.indexOf("÷"));
                            param2 = existedText.substring(existedText.indexOf("÷") + 1);
                        }
                        Log.d("Anonymous param1", param1);
                        Log.d("Anonymous param2", param2);

                        boolean isContainedDot = param2.contains(".");
                        if (param2.length() >= 9) {

                        } else if (!isContainedDot) {
                            if (param2.equals("")) {
                                existedText += "0.";
                            } else {
                                existedText += ".";
                            }
                        } else {
                            return;
                        }
                    } else {
                        boolean isContainedDot = existedText.contains(".");
                        if (existedText.length() >= 9) {

                        } else if (!isContainedDot) {
                            existedText += ".";
                        } else {
                            return;
                        }
                    }
                    isCounted = false;

                } else {
                    existedText = "0.";
                    isCounted = false;
                }


                break;
            case R.id.bt_百分号:
                if (existedText.equals("error")) {

                } else {

                    getCondition();

                    if (startWithOperator || startWithSubtract || noStartWithOperator) {

                    } else {
                        if (existedText.equals("0")) {
                            return;
                        } else {
                            double temp = Double.parseDouble(existedText);
                            temp = temp / 100;
                            existedText = String.valueOf(temp);
                        }
                    }
                }
                break;
            case R.id.bt_后退:
                if (existedText.equals("error")) {
                    existedText = "0";
                } else if (existedText.length() > 0) {
                    if (existedText.length() == 1) {
                        existedText = "0";
                    } else {
                        existedText = existedText.substring(0, existedText.length() - 1);
                    }
                }
                break;
            case R.id.bt_清除:
                existedText = "0";
                break;
        }
        et_input.setText(existedText);
    }

    private String getResult() {
        String tempResult = null;
        String param1 = null;
        String param2 = null;
        double arg1 = 0;
        double arg2 = 0;
        double result = 0;

        getCondition();
        if (startWithOperator || noStartWithOperator || startWithSubtract) {

            if (existedText.contains("+")) {
                param1 = existedText.substring(0, existedText.indexOf("+"));
                param2 = existedText.substring(existedText.indexOf("+") + 1);
                if (param2.equals("")) {
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 + arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }


            } else if (existedText.contains("×")) {

                param1 = existedText.substring(0, existedText.indexOf("×"));
                param2 = existedText.substring(existedText.indexOf("×") + 1);

                if (param2.equals("")) {
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 * arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }

            } else if (existedText.contains("÷")) {

                param1 = existedText.substring(0, existedText.indexOf("÷"));
                param2 = existedText.substring(existedText.indexOf("÷") + 1);

                if (param2.equals("0")) {
                    tempResult = "error";
                } else if (param2.equals("")) {
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 / arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }

            } else if (existedText.contains("-")) {
                param1 = existedText.substring(0, existedText.lastIndexOf("-"));
                param2 = existedText.substring(existedText.lastIndexOf("-") + 1);

                if (param2.equals("")) {
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 - arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }

            }
            if (tempResult.length() >= 10) {
                tempResult = String.format("%e", Double.parseDouble(tempResult));
            } else if (tempResult.contains(".")) {
                if (tempResult.substring(0, tempResult.indexOf(".")).length() >= 10) {
                    tempResult = String.format("%e", Double.parseDouble(tempResult));
                }
            }
        } else {
            tempResult = existedText;
        }

        return tempResult;
    }

    private String isOverRange(String existedText, String s) {
        if (!isCounted) {
            if (existedText.contains("e")) {
                existedText = "0";
            }
            if (existedText.equals("0")) {
                existedText = "";
            }
            if (existedText.contains("+") || existedText.contains("-") ||
                    existedText.contains("×") || existedText.contains("÷")) {
                String param2 = null;
                if (existedText.contains("+")) {
                    param2 = existedText.substring(existedText.indexOf("+") + 1);
                } else if (existedText.contains("-")) {
                    param2 = existedText.substring(existedText.indexOf("-") + 1);
                } else if (existedText.contains("×")) {
                    param2 = existedText.substring(existedText.indexOf("×") + 1);
                } else if (existedText.contains("÷")) {
                    param2 = existedText.substring(existedText.indexOf("÷") + 1);
                }

//            Log.d("Anonymous param1",param1);
//            Log.d("Anonymous param2",param2);
                if (existedText.substring(existedText.length() - 1).equals("+") ||
                        existedText.substring(existedText.length() - 1).equals("-") ||
                        existedText.substring(existedText.length() - 1).equals("×") ||
                        existedText.substring(existedText.length() - 1).equals("÷")) {
                    existedText += s;
                } else {
                    if (param2.contains(".")) {
                        if (param2.length() >= 10) {

                        } else {
                            existedText += s;
                        }
                    } else {
                        if (param2.length() >= 9) {

                        } else {
                            existedText += s;
                        }
                    }
                }
            } else {

                if (existedText.contains(".")) {
                    if (existedText.length() >= 10) {

                    } else {
                        existedText += s;
                    }
                } else {
                    if (existedText.length() >= 9) {

                    } else {
                        existedText += s;
                    }
                }
            }

            isCounted = false;

        } else {

            existedText = s;
            isCounted = false;

        }


        return existedText;
    }

    public static String subZeroAndDot(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    private boolean judgeExpression() {

        getCondition();

        String tempParam2 = null;

        if (startWithOperator || noStartWithOperator || startWithSubtract) {

            if (existedText.contains("+")) {
                tempParam2 = existedText.substring(existedText.indexOf("+") + 1);
                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }
            } else if (existedText.contains("×")) {

                tempParam2 = existedText.substring(existedText.indexOf("×") + 1);

                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }

            } else if (existedText.contains("÷")) {

                tempParam2 = existedText.substring(existedText.indexOf("÷") + 1);

                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }

            } else if (existedText.contains("-")) {
                tempParam2 = existedText.substring(existedText.lastIndexOf("-") + 1);

                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }

            }
        }
        return false;
    }
    private void getCondition() {
        startWithOperator = existedText.startsWith("-") && (existedText.contains("+") ||
                existedText.contains("×") || existedText.contains("÷"));
        startWithSubtract = existedText.startsWith("-") && (existedText.lastIndexOf("-") != 0);
        noStartWithOperator = !existedText.startsWith("-") && (existedText.contains("+") ||
                existedText.contains("-") || existedText.contains("×") || existedText.contains("÷"));
    }
}

