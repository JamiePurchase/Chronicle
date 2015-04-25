package android.jp.chronicle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

public class StateTitle extends State
{

    public StateTitle(Bitmap image)
    {
        setBackground(image);
    }

    public void draw(Canvas canvas)
    {
        drawBackground(canvas);
        drawMenu(canvas);
    }

    public void drawMenu(Canvas canvas)
    {
        Paint paint = new Paint();
        Rect rect = new Rect(50, 300, 200, 200);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(170, 50, 75));
        canvas.drawRect(rect, paint);
    }

    public void touch(MotionEvent event)
    {
        if(event.getX() >= 50 && event.getX() <= 250 && event.getY() >= 300 && event.getY() <= 500)
        {
            AppPanel.setState(new StateLibrary(AppPanel.bkgLibrary));
        }
    }

    public void update()
    {

    }
}