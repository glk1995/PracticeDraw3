package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice13GetTextBoundsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text1 = "A";
    String text2 = "a";
    String text3 = "J";
    String text4 = "j";
    String text5 = "Â";
    String text6 = "â";
    int top = 200;
    int bottom = 400;
    int[] yOffset = {0, 0, 0, 0, 0, 0};

    public Practice13GetTextBoundsView(Context context) {
        super(context);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);

        Rect bound = new Rect();
        paint2.getTextBounds(text1, 0, text1.length(), bound);
        //这里我top应该是基于baseline的top，所以top为负数，bottom为正数
        //这里相加除以2得到基于baseline的中点
        //举例说一个字绘制rect -50 ~ 50，一个字正常绘制是top为0，bottom 50
        //那么如果绘制在中间，必须往上移动(0 + 50) / 2
        //相当于getTextBounds获取的是这个字原来基准线的top、bottom，现在是矩形的中心对齐，基准线改为矩形的middle
        yOffset[0] = -(bound.top + bound.bottom) / 2;
        paint2.getTextBounds(text2, 0, text2.length(), bound);
        yOffset[1] = -(bound.top + bound.bottom) / 2;
        paint2.getTextBounds(text3, 0, text3.length(), bound);
        yOffset[2] = -(bound.top + bound.bottom) / 2;
        paint2.getTextBounds(text4, 0, text4.length(), bound);
        yOffset[3] = -(bound.top + bound.bottom) / 2;
        paint2.getTextBounds(text5, 0, text5.length(), bound);
        yOffset[4] = -(bound.top + bound.bottom) / 2;
        paint2.getTextBounds(text6, 0, text5.length(), bound);
        yOffset[5] = -(bound.top + bound.bottom) / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差

        int middle = (top + bottom) / 2;
        canvas.drawText(text1, 100, middle + yOffset[0], paint2);
        canvas.drawText(text2, 200, middle + yOffset[1], paint2);
        canvas.drawText(text3, 300, middle + yOffset[2], paint2);
        canvas.drawText(text4, 400, middle + yOffset[3], paint2);
        canvas.drawText(text5, 500, middle + yOffset[4], paint2);
        canvas.drawText(text6, 600, middle + yOffset[5], paint2);
    }
}