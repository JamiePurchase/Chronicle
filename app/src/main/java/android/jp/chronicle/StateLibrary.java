package android.jp.chronicle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import java.io.File;
import java.io.IOException;

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
        //System.exit(0);

        // Temp
        File file = new File(AppPanel.getDataFolder(), "test.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update()
    {

    }
}