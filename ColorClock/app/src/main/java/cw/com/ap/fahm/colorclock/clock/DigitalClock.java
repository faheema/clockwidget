package cw.com.ap.fahm.colorclock.clock;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Faheem on 17/10/17.
 */

public class DigitalClock extends android.support.v7.widget.AppCompatTextView {
    private int hours;
    private int minutes;
    private int seconds;

    private Timer clockTimer;
    private final TimerTask clockTask = new TimerTask() {
        @Override
        public void run() {
            mHandler.post(mUpdateResults);
        }
    };

    final Handler mHandler = new Handler();
    final Runnable mUpdateResults = new Runnable() {
        public void run() {
            update();
        }
    };

    public DigitalClock(Context context) {
        super(context);
        init();
    }

    private void update() {
        seconds++;

        if (seconds >= 60) {
            seconds = 0;
            if (minutes < 59) {
                minutes++;
            } else if (hours < 23) {
                minutes = 0;
                hours++;
            } else {
                minutes = 0;
                hours = 0;
            }
        }
        if (seconds % 2 == 0) {
            setText(String.format("%02d:%02d:%2d", hours, minutes, seconds));
        } else {
            setText(String.format("%02d %02d %02d", hours, minutes, seconds));
        }
    }

    private void init() {
        clockTimer = new Timer();

        Calendar mCalendar = Calendar.getInstance();
        hours = mCalendar.get(Calendar.HOUR_OF_DAY);
        minutes = mCalendar.get(Calendar.MINUTE);
        seconds = mCalendar.get(Calendar.SECOND);

        clockTimer.scheduleAtFixedRate(clockTask, 0, 1000);
    }

    public DigitalClock(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DigitalClock(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}