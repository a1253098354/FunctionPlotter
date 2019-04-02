package com.example.functionplotter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import bsh.EvalError;
import bsh.Interpreter;

public class MainActivity extends AppCompatActivity{
    drawview drawView;
    Button addFunc,deleteFunc,larger,smaller,help;
    int count=0;

    private class ChoiceOnClickListener implements DialogInterface.OnClickListener {

        private int which = 0;
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            this.which = which;
        }

        public int getWhich() {
            return which;
        }
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog = null;

        AlertDialog.Builder builder = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        builder.setTitle("delete:");
        final ChoiceOnClickListener choiceListener = new ChoiceOnClickListener();
        builder.setSingleChoiceItems(R.array.functions, 0, choiceListener);
        DialogInterface.OnClickListener btnListener = new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                drawView.expression[choiceListener.getWhich()]="";
                                drawView.Invalidate();
                            }
                        };
                builder.setPositiveButton("ok", btnListener);

                dialog = builder.create();
                if(dialog!=null) {
                    Window window = dialog.getWindow();
                    WindowManager.LayoutParams lp = window.getAttributes();
                    lp.alpha = 0.9f;
                    window.setAttributes(lp);
                }
        return dialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawView=findViewById(R.id.mydrawview);
        addFunc=findViewById(R.id.addfunction);
        deleteFunc=findViewById(R.id.deletefunction);
        help=findViewById(R.id.help);
        larger=findViewById(R.id.larger);
        smaller=findViewById(R.id.smaller);

        addFunc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddNewFunction.class);
                startActivityForResult(intent,0);
            }
        });
        deleteFunc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            showDialog(0);
            }
        });
        larger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawView.scale*=2;
                drawView.offsetX*=2;
                drawView.offsetY*=2;
                drawView.Invalidate();
            }
        });
        smaller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawView.scale /= 2;
                drawView.offsetX/=2;
                drawView.offsetY/=2;

                drawView.Invalidate();
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Help.class));
            }
        });
    }

    private void CreateDialog() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            String newfunction = data.getExtras().getString("newfunction");
            if(!newfunction.isEmpty()) {
                Interpreter in=new Interpreter();
                try {
                    in.eval((drawview.omitMultiplicationSign(newfunction)).replace("x","1"));
                } catch (Exception e) {
                    if(e.getClass().toString().indexOf("ParseException")!=-1){
                        {
                            Toast.makeText(getApplicationContext(), "invalid expression!", Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                }
                drawView.update_expression(count, newfunction);
                count = (count + 1) % 7;
            }
        }
        catch (Exception e){}
    }
}
