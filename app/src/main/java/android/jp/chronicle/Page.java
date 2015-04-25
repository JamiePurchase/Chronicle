package android.jp.chronicle;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Page
{
    private Bitmap image;
    private String[] contents = new String[100];

    public Page(Bitmap image)
    {
        this.image = image;
    }

    public void draw(Canvas canvas)
    {
        drawBackground(canvas);
        drawPage(canvas);
    }

    public void drawBackground(Canvas canvas)
    {
        canvas.drawBitmap(image, 0, 0, null);
    }

    public void drawPage(Canvas canvas)
    {

    }

    public void update()
    {

    }

}