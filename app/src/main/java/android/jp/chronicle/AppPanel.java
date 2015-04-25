package android.jp.chronicle;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class AppPanel extends SurfaceView implements SurfaceHolder.Callback
{
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 800;
    private MainThread thread;
    private Page page;

    public AppPanel(Context context)
    {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void draw(Canvas canvas)
    {
        final float scaleFactorX = getWidth()/(WIDTH*1.f);
        final float scaleFactorY = getHeight()/(HEIGHT*1.f);
        if(canvas!=null)
        {
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX, scaleFactorY);
            page.draw(canvas);
            canvas.restoreToCount(savedState);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            System.exit(0);
            return true;
        }

        if(event.getAction()==MotionEvent.ACTION_UP)
        {
            return true;
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        while(retry)
        {
            try
            {
                thread.setRunning(false);
                thread.join();
            }
            catch(InterruptedException e) {e.printStackTrace();}
            retry = false;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        page = new Page(BitmapFactory.decodeResource(getResources(), R.drawable.bkg2));
        thread.setRunning(true);
        thread.start();
    }

    public void update()
    {
        page.update();
    }

}