package cw.com.ap.fahm.colorclock;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import cw.com.ap.fahm.colorclock.clock.AnalogClockFah;
import cw.com.ap.fahm.colorclock.clock.DigitalClock;

public class MainActivity extends AppCompatActivity {

    private Timer clockTimer = new Timer();
    private final TimerTask clockTask = new TimerTask() {
        @Override
        public void run() {
            mHandler.post(mUpdateResults);
        }
    };

    final Handler mHandler = new Handler();
    final Runnable mUpdateResults = new Runnable() {
        public void run() {
            updateFaceColor();;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateFaceColor();
        schudleTimer();

    }

    public void schudleTimer()
    {
        clockTimer.scheduleAtFixedRate(clockTask, 0, 3000);
    }
    public void stopTimer()
    { clockTimer.cancel();

    }
    private void updateFaceColor()
    {
        AnalogClockFah customAnalogClock = (AnalogClockFah) findViewById(R.id.analog_clock);
        DigitalClock digital = (DigitalClock) findViewById(R.id.digital_clock);

        String strColor = "FF"+digital.getHours()*5+ digital.getMinutes()*4+digital.getSeconds()*5;
        int color=  (int) Long.parseLong(strColor, 16);
        customAnalogClock.setFaceColor(color);
        //customAnalogClock.setAutoUpdate(true);
    }

   /* @Override
    protected void onPause() {
        super.onPause();
       stopTimer();
    }

    @Override
    protected void onR {
        super.onResume();
        schudleTimer();
    }*/
}
