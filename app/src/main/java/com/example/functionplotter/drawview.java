package com.example.functionplotter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import bsh.EvalError;
import bsh.Interpreter;

public class drawview extends View {
    private Paint paint=new Paint();
    private Paint paint_text=new Paint();
    private Paint[] paint_func={new Paint(),new Paint(),new Paint(),new Paint(),new Paint(),new Paint(),new Paint()};
    Interpreter interpreter=new Interpreter();
    String expression[]={"","","","","","",""};
    int color[]={Color.rgb(0,255,0),Color.rgb(255,0,0),Color.rgb(0,0,255),Color.rgb(221,24,221),Color.rgb(162,107,94),Color.rgb(66,71,99),Color.rgb(255,231,00)};
    public int height_view=2026;
    public int width_view=1080;
    public int offsetX=0;
    public int offsetY=0;
    public double scale=1;
    double step=0;
    int lastX,lastY=0;
    Path path=new Path();
    private Path path_func[]={new Path(),new Path(),new Path(),new Path(),new Path(),new Path(),new Path()};

    public drawview(Context context, AttributeSet set)
    {
        super(context,set);
        init();
    }
    public drawview(Context c)
    {
        super(c);
        init();
    }
    public  drawview(Context c, AttributeSet set,int defs)
    {
        super(c,set,defs);
        init();
    }


    public static String omitMultiplicationSign(String s)
    {
        String tmp=s;
        tmp=tmp.replace("/(double)","/1.0/");
        tmp=tmp.replace("0x","0*x");
        tmp=tmp.replace("1x","1*x");
        tmp=tmp.replace("2x","2*x");
        tmp=tmp.replace("3x","3*x");
        tmp=tmp.replace("4x","4*x");
        tmp=tmp.replace("5x","5*x");
        tmp=tmp.replace("6x","6*x");
        tmp=tmp.replace("7x","7*x");
        tmp=tmp.replace("8x","8*x");
        tmp=tmp.replace("9x","9*x");

        tmp=tmp.replace("x0","x*0");
        tmp=tmp.replace("x1","x*1");
        tmp=tmp.replace("x2","x*2");
        tmp=tmp.replace("x3","x*3");
        tmp=tmp.replace("x4","x*4");
        tmp=tmp.replace("x5","x*5");
        tmp=tmp.replace("x6","x*6");
        tmp=tmp.replace("x7","x*7");
        tmp=tmp.replace("x8","x*8");
        tmp=tmp.replace("x9","x*9");

        tmp=tmp.replace(")x",")*x");
        tmp=tmp.replace(")Math",")*Math");

        tmp=tmp.replace(")0",")*0");
        tmp=tmp.replace(")1",")*1");
        tmp=tmp.replace(")2",")*2");
        tmp=tmp.replace(")3",")*3");
        tmp=tmp.replace(")4",")*4");
        tmp=tmp.replace(")5",")*5");
        tmp=tmp.replace(")6",")*6");
        tmp=tmp.replace(")7",")*7");
        tmp=tmp.replace(")8",")*8");
        tmp=tmp.replace(")9",")*9");

        tmp=tmp.replace("xMath","x*Math");
        tmp=tmp.replace("PIx","PI*x");
        tmp=tmp.replace("Ex","E*x");

        tmp=tmp.replace("0Math","0*Math");
        tmp=tmp.replace("1Math","1*Math");
        tmp=tmp.replace("2Math","2*Math");
        tmp=tmp.replace("3Math","3*Math");
        tmp=tmp.replace("4Math","4*Math");
        tmp=tmp.replace("5Math","5*Math");
        tmp=tmp.replace("6Math","6*Math");
        tmp=tmp.replace("7Math","7*Math");
        tmp=tmp.replace("8Math","8*Math");
        tmp=tmp.replace("9Math","9*Math");

        tmp=tmp.replace("x","(x)");
        return tmp;
    }
    public int adjust()
    {
        int k=0;
        for(int i=0;i<7;i++)
        {
            if(!expression[i].isEmpty())
            {
                k++;
            }
        }
        return k>=4?2:1;
    }
    public int transX(double x)
    {
        return (int)Math.round(width_view/2+100*x*scale+offsetX);
    }
    public int transY(double y)
    {
        int ret=(int)Math.round(height_view/2-100*y*scale-offsetY);

        if(Math.abs(ret)>2*height_view) {
            if(ret>0)
            ret = 2 * height_view;
            else
                ret=-height_view;
        }
        return ret;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                offsetX += 0.2*(x-lastX);
                offsetY += 0.2*(lastY-y);
                invalidate();
                break;
        }
        return true;
    }

    public void Invalidate(){
        invalidate();
    }


    private void init() {

        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        paint_text.setColor(Color.RED);
        paint_text.setStrokeWidth(10);
        paint_text.setTextSize(50);
        paint_text.setTextAlign(Paint.Align.CENTER);
        paint_text.setStyle(Paint.Style.FILL);

        for(int i=0;i<7;i++)
        {
            paint_func[i].setColor(color[i]);
            paint_func[i].setAntiAlias(true);
            paint_func[i].setStrokeWidth(5);
            paint_func[i].setStyle(Paint.Style.STROKE);
            paint_func[i].setTextAlign(Paint.Align.RIGHT);
            paint_func[i].setTextSize(60);

        }

    }
    public double getStep()
    {
        double ret;
        if((Math.log(scale))/(Math.log(2))<-0.001)
        {
            ret=(int)((Math.log(scale))/(Math.log(2)));
            ret=Math.pow(2,ret);
        }
        else
        {
            ret=(int)Math.pow(2,(int)((Math.log(scale))/(Math.log(2))));
        }
        return ret;
    }
    public String show_expression(String s)
    {
        return s.replace("Math.PI","pi").replace("Math.E","e").replace("Math.pow","pow").replace("(double)","").replace("Math.abs","abs").replace("Math.log","ln").replace("Math.sin","sin").replace("Math.cos","cos").replace("Math.tan","tan");
    }

    public void init_path()
    {
        step=getStep();

        path.reset();
        paint.setColor(Color.BLACK);
        for(double i=(int)(-1+(-height_view/2-offsetY)/100.0/scale);i<=(int)(1+height_view/2-offsetY)/100.0/scale;i+=(1.0/step))
        {
            path.moveTo(0,transY(i));
            path.lineTo(width_view,transY(i));
        }
        for(double i=(int)(-1+(-width_view/2-offsetX)/100.0/scale);i<=(int)(1+width_view/2-offsetX)/100.0/scale;i+=(1.0/step))
        {
            path.moveTo(transX(i),0);
            path.lineTo(transX(i),height_view);
        }
    }

    public void update_expression(int count,String newexpression)
    {
        expression[count]=newexpression;
    }
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        height_view=this.getHeight();
        width_view=this.getWidth();
        init_path();
        int adjust=adjust();
        for(int i=0;i<7;i++)
        {
            boolean flag=true;
            String tmp_expression=omitMultiplicationSign(expression[i]);
            path_func[i].reset();

            if(!tmp_expression.isEmpty()) {
                for(double j=(int)(-1+(-width_view/2-offsetX)/100.0/scale);j<=(int)(1+width_view/2-offsetX)/100.0/scale;j+=(1.0/step/(20/adjust)))
                {
                    try {
                        if(flag) {
                            path_func[i].moveTo(transX(j), transY(Double.parseDouble(interpreter.eval(tmp_expression.replace("x", "" + j)).toString())));
                            flag=false;
                        }
                        else {
                            path_func[i].lineTo(transX(j), transY(Double.parseDouble(interpreter.eval(tmp_expression.replace("x", "" + j)).toString())));
                        }
                    } catch (EvalError evalError) {
                        flag=true;
                    }
                }
            }
        }

        canvas.drawPath(path,paint);//draw the coordinate system.
        paint_text.setTextAlign(Paint.Align.LEFT);
        for(double i=(int)(-1+(-height_view/2-offsetY)/100.0/scale);i<=(int)(1+height_view/2-offsetY)/100.0/scale;i+=(1.0/step))
        {
            canvas.drawText(""+i,0,transY(i),paint_text);  //draw the values of y coordinates.
        }
        paint_text.setTextAlign(Paint.Align.CENTER);
        for(double i=(int)(-1+(-width_view/2-offsetX)/100.0/scale);i<=(int)(1+width_view/2-offsetX)/100.0/scale;i+=(1.0/step))
        {
            canvas.drawText(""+i,transX(i),height_view,paint_text);//draw the values of x coordinates.
        }
        for(int i=0;i<7;i++)
        {
            canvas.drawPath(path_func[i],paint_func[i]); //draw the curves corresponding to the function expressions.
        }
        for(int i=0;i<7;i++)
        {
            if(!expression[i].isEmpty()) {
                paint_func[i].setStyle(Paint.Style.FILL);
                canvas.drawText("f" + i + "=" + show_expression(expression[i]), width_view-100,100+150*i, paint_func[i]);//draw the function expressions.
                paint_func[i].setStyle(Paint.Style.STROKE);
            }
        }
    }
}
