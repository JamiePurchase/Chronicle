package android.jp.chronicle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

public class StateLibrary extends State
{

    public StateLibrary(Bitmap image)
    {
        setBackground(image);
    }

    public void draw(Canvas canvas)
    {
        drawBackground(canvas);
    }

    public void touch(MotionEvent event)
    {
        System.exit(0);
    }

    public void update()
    {

    }
}