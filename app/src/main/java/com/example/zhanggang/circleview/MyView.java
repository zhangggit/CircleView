package com.example.zhanggang.circleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * 类作用：
 * 时  间：  2017/8/4 - 20:43.
 * 创建人：张刚
 */

public class MyView extends View {

    float x;
    float y;
    float radius=100;
    private Paint paint;
    private boolean ball;

    public MyView(Context context) {
        super(context);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN: //按下
//                float downx = event.getX();
//                float downy = event.getY();
//                ball = onBall(downx, downy);
//                Toast.makeText(getContext(), ""+ ball, Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_MOVE: //移动
//                if (ball){
                    x = event.getX();
                    y = event.getY();
                    //刷新重绘的方法   onDraw
                    invalidate();
//                }
                break;
            case MotionEvent.ACTION_UP: //抬起
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x,y,radius,paint);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getWidth();
        int height = getHeight();
        x=width/2;
        y=height/2;
    }
    public boolean onBall(float downx,float downy){
        //利用勾股定理 判断当前点击的位置坐标
        double sqrt = Math.sqrt((downx - x) * (downx - x) + (downy - y) * (downy - y));
        if (sqrt<=radius){
            return true;
        }
        return false;
    }

}
