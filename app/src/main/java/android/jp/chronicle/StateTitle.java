package android.jp.chronicle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.Arrays;

public class StateTitle extends State
{
    private String subState;
    private String[] subStateList;

    public StateTitle(Bitmap image)
    {
        subStateList = new String[]{"TITLE", "ABOUT", "ACCOUNT"};
        setSubState("TITLE");
        setBackground(image);
    }

    public void draw(Canvas canvas)
    {
        drawBackground(canvas);
        if(subState == "ABOUT") {drawAbout(canvas);}
        if(subState == "ACCOUNT") {drawAccount(canvas);}
        if(subState == "TITLE") {drawTitle(canvas);}
    }

    public void drawAbout(Canvas canvas)
    {
        Drawing.rectDraw(canvas, Drawing.getPaint("Background1"), 100, 50, AppPanel.WIDTH-200, AppPanel.HEIGHT-100);
        Drawing.rectDraw(canvas, Drawing.getPaint("Border1", 2), 100, 50, AppPanel.WIDTH-200, AppPanel.HEIGHT-100);
    }

    public void drawAccount(Canvas canvas)
    {

    }

    public void drawTitle(Canvas canvas)
    {
        // Logo / Header

        // App Details (author, version)
        Drawing.textWrite(canvas, "Jamie Purchase", "Black", 25, 750);

        // Menu Options

        // Temp
        Paint paint = new Paint();
        Rect rect = new Rect(50, 300, 200, 200);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(170, 50, 75));
        canvas.drawRect(rect, paint);
    }

    public void setSubState(String newSubState)
    {
        if(Arrays.asList(subStateList).contains(newSubState))
        {
            subState = newSubState;
        }
    }

    public void touch(MotionEvent event)
    {
        if(subState == "ABOUT") {touchAbout(event);}
        if(subState == "ACCOUNT") {touchAccount(event);}
        if(subState == "TITLE") {touchTitle(event);}
    }

    public void touchAbout(MotionEvent event)
    {

    }

    public void touchAccount(MotionEvent event)
    {

    }

    public void touchTitle(MotionEvent event)
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