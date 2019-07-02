package com.leecode1988;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/**
 * 描述：自定义Progress,text
 *
 * @author liguoqing
 * @date 2019-06-27
 */
public class MyProgress extends ProgressBar {
    String text;
    Paint mPaint;

    public MyProgress(Context context) {
        super(context);
        initText();
    }

    public MyProgress(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initText();
    }


    public MyProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        initText();
    }

    @Override
    public synchronized void setProgress(int progress) {
        setText(progress);
        super.setProgress(progress);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //this.setText();
        Rect rect = new Rect();
        this.mPaint.getTextBounds(this.text, 0, this.text.length(), rect);

        float textWidth = mPaint.measureText("" + text + "%");

        int x = (int) ((getWidth() / (getMax() * 1.0f) * getProgress()) - textWidth);
        int y = (getHeight() / 2) - rect.centerY();

        canvas.drawText(this.text, x, y, this.mPaint);

    }

    //初始化，画笔
    private void initText() {
        this.mPaint = new Paint();
        this.mPaint.setColor(Color.WHITE);
    }

    public void setText() {
        setText(this.getProgress());
    }

    //设置文字内容
    //progress 0-1
    private void setText(int progress) {
        int i = (progress * 100) / this.getMax();
        this.text = i + "%";
    }


}
