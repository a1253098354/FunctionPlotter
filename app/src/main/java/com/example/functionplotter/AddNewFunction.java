package com.example.functionplotter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddNewFunction extends AppCompatActivity {
    TextView tv_newfunction;
    Button btn_ok;
    Button tv_0,tv_1,tv_2,tv_3,tv_4,tv_5,tv_6,tv_7,tv_8,tv_9,tv_plus,tv_minus,tv_multiply,tv_divide,tv_pi,tv_e,tv_left_bracket,tv_right_bracket,tv_delete,tv_dot,tv_mod,tv_comma,tv_exponential,tv_x,tv_ac,tv_sin,tv_cos,tv_tan,tv_ln,tv_abs;
    String inner_expression="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_function);
        tv_newfunction=findViewById(R.id.tv_newfunction);
        btn_ok=findViewById(R.id.btn_ok);
        (tv_0=findViewById(R.id.tv_0)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_1=findViewById(R.id.tv_1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_2=findViewById(R.id.tv_2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_3=findViewById(R.id.tv_3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_4=findViewById(R.id.tv_4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_5=findViewById(R.id.tv_5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_6=findViewById(R.id.tv_6)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_7=findViewById(R.id.tv_7)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_8=findViewById(R.id.tv_8)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_9=findViewById(R.id.tv_9)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_plus=findViewById(R.id.tv_plus)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_minus=findViewById(R.id.tv_minus)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_multiply=findViewById(R.id.tv_multiply)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_divide=findViewById(R.id.tv_divide)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_left_bracket=findViewById(R.id.tv_left_bracket)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_right_bracket=findViewById(R.id.tv_right_bracket)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_dot=findViewById(R.id.tv_dot)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_pi=findViewById(R.id.tv_pi)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_e=findViewById(R.id.tv_e)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_mod=findViewById(R.id.tv_mod)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_comma=findViewById(R.id.tv_comma)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_exponential=findViewById(R.id.tv_exponential)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_x=findViewById(R.id.tv_x)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_ac=findViewById(R.id.tv_ac)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_sin=findViewById(R.id.tv_sin)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_cos=findViewById(R.id.tv_cos)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_tan=findViewById(R.id.tv_tan)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_ln=findViewById(R.id.tv_ln)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        (tv_abs=findViewById(R.id.tv_abs)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_clicked(v);
            }
        });
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle =new Bundle();
                bundle.putString("newfunction",inner_expression);
                Intent intent=new Intent();
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK,intent);

                finish();
            }
        });
    }
    public void tv_clicked(View v)
    {
        TextView tv=(TextView)v;
        if(tv.getText().toString().equals("pi"))
        {
            inner_expression+="Math.PI";
            tv_newfunction.setText(tv_newfunction.getText().toString()+"pi");
        }
        else if(tv.getText().toString().equals("e"))
        {
            inner_expression+="Math.E";
            tv_newfunction.setText(tv_newfunction.getText().toString()+"e");
        }
        else if(tv.getText().toString().equals("/"))
        {
            inner_expression+="/(double)";
            tv_newfunction.setText(tv_newfunction.getText().toString()+"/");
        }
        else if(tv.getText().toString().equals("AC"))
        {
            inner_expression="";
            tv_newfunction.setText("");
        }
        else if(tv.getText().toString().equals("a^b"))
        {
            inner_expression+="Math.pow(";
            tv_newfunction.setText(tv_newfunction.getText().toString()+"pow(");
        }
        else if(tv.getText().toString().equals("sin"))
        {
            inner_expression+="Math.sin(";
            tv_newfunction.setText(tv_newfunction.getText().toString()+"sin(");
        }else if(tv.getText().toString().equals("cos"))
        {
            inner_expression+="Math.cos(";
            tv_newfunction.setText(tv_newfunction.getText().toString()+"cos(");
        }else if(tv.getText().toString().equals("tan"))
        {
            inner_expression+="Math.tan(";
            tv_newfunction.setText(tv_newfunction.getText().toString()+"tan(");
        }else if(tv.getText().toString().equals("ln"))
        {
            inner_expression+="Math.log(";
            tv_newfunction.setText(tv_newfunction.getText().toString()+"ln(");
        }else if(tv.getText().toString().equals("abs"))
        {
            inner_expression+="Math.abs(";
            tv_newfunction.setText(tv_newfunction.getText().toString()+"abs(");
        }
        else{
            tv_newfunction.setText(tv_newfunction.getText().toString()+tv.getText().toString());
            inner_expression+=tv.getText().toString();
        }

    }
}
