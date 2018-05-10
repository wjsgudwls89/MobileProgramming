package com.example.hj.lab4_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView vw = new MyView(this);
        setContentView(vw);
    }

    protected class MyView extends View {
        private int x;
        private int y;
        Paint pnt = new Paint();
        Path path = new Path();

        public MyView(Context context) {
            super(context);
            pnt.setStyle(Paint.Style.STROKE);
            pnt.setStrokeWidth(10f); //set width
            pnt.setColor(Color.BLUE); //set color
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawPath(path, pnt);

        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = (int) event.getX(); //get x
            y = (int) event.getY(); //get y

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: //if touch
                    path.moveTo(x, y); //move
                    break;
                case MotionEvent.ACTION_MOVE: //move with touch
                    path.lineTo(x, y); //draw line
                    break;
                case MotionEvent.ACTION_UP: //touch finish
                    break;
            }

            invalidate(); //renewal view
            return true;
        }
    }

}