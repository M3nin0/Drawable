package com.curso.youtube.canvasproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class AndroidCanvas extends View {

    Paint paint;
    Path path;

    public AndroidCanvas(Context context) {
        super(context);
        paint = new Paint();
        path = new Path();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xPos = event.getX();
        float yPos = event.getY();

        switch (event.getAction()) {
            // Touch
            case MotionEvent.ACTION_DOWN:
                path.moveTo(xPos, yPos);
                return true;
            // Move Dragged
            case MotionEvent.ACTION_MOVE:
                path.lineTo(xPos, yPos);
                break;
            // "Un Touch"
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

    /**
     * Método para limpar o canvas
     */
    public void clearCanvas() {
        path = new Path();
        invalidate();
    }

}
