package android.jp.chronicle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

public abstract class State
{
    private Bitmap background;
    public abstract void draw(Canvas canvas);
    public abstract void touch(MotionEvent event);
    public abstract void update();

    public State()
    {

    }

    public void drawBackground(Canvas canvas)
    {
        canvas.drawBitmap(background, 0, 0, null);
    }

    public void setBackground(Bitmap image)
    {
        background = image;
    }
}