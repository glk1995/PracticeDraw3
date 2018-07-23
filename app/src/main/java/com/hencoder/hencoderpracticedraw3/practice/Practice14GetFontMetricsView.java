package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice14GetFontMetricsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String[] texts = {"A", "a", "J", "j", "Â", "â"};
    int top = 200;
    int bottom = 400;
    float yOffset;

    public Practice14GetFontMetricsView(Context context) {
        super(context);
    }

    public Practice14GetFontMetricsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14GetFontMetricsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);

        //获取文字排版的几个数值
        //Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        //ascent、descent 普通文字的绘制的顶部和底部
        //top、bottom 所有文字绘制的顶部和底部
        //leading 上一行文字的底部和下一行文字顶部距离
        //yOffset = -(fontMetrics.descent + fontMetrics.ascent) / 2;
        //简易方法
        yOffset = - (paint2.ascent() + paint2.descent()) / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        // 使用 Paint.getFontMetrics() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让不同的文字的 baseline 对齐

        int middle = (top + bottom) / 2;
        canvas.drawText(texts[0], 100, middle + yOffset, paint2);
        canvas.drawText(texts[1], 200, middle + yOffset, paint2);
        canvas.drawText(texts[2], 300, middle + yOffset, paint2);
        canvas.drawText(texts[3], 400, middle + yOffset, paint2);
        canvas.drawText(texts[4], 500, middle + yOffset, paint2);
        canvas.drawText(texts[5], 600, middle + yOffset, paint2);
    }
}
