package android.jp.chronicle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import org.apache.http.HttpResponse;

import java.io.IOException;

public class AppPanel extends SurfaceView implements SurfaceHolder.Callback
{
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 800;
    private MainThread thread;
    private static State state;

    // Temp
    public static Bitmap bkgTitle;
    public static Bitmap bkgLibrary;

    public AppPanel(Context context)
    {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);

        // Temp
        bkgTitle = BitmapFactory.decodeResource(getResources(), R.drawable.bkg2);
        bkgLibrary = BitmapFactory.decodeResource(getResources(), R.drawable.bkg1);
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
            state.draw(canvas);
            canvas.restoreToCount(savedState);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            //System.exit(0);
            state.touch(event);

            /* HTTP CALL
            try {HttpResponse response = App.client.execute(App.post);}
            catch (IOException e) {e.printStackTrace();}*/
            return true;
        }

        if(event.getAction()==MotionEvent.ACTION_UP)
        {
            return true;
        }

        return super.onTouchEvent(event);
    }

    public static void setState(State newState)
    {
        state = newState;
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
        setState(new StateTitle(bkgTitle));
        thread.setRunning(true);
        thread.start();
    }

    public void update()
    {
        state.update();
    }

}