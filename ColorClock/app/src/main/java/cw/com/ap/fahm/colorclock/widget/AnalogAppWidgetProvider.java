/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cw.com.ap.fahm.colorclock.widget;


import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import cw.com.ap.fahm.colorclock.MainActivity;
import cw.com.ap.fahm.colorclock.R;

/**
 * Simple widget to show analog clock.
 */
public class AnalogAppWidgetProvider extends BroadcastReceiver {
    static final String TAG = "AnalogAppWidgetProvider";


    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(action)) {
            RemoteViews views = new RemoteViews(context.getPackageName(),
                    R.layout.analog_appwidget);

            views.setOnClickPendingIntent(R.id.analog_appwidget,
                    PendingIntent.getActivity(context, 0,
                            new Intent(context, MainActivity.class), 0));

            int[] appWidgetIds = intent.getIntArrayExtra(
                    AppWidgetManager.EXTRA_APPWIDGET_IDS);

            AppWidgetManager gm = AppWidgetManager.getInstance(context);
            gm.updateAppWidget(appWidgetIds, views);
        }
    }
}
 /*class AnalogAppWidget extends AppWidgetProvider {
    static final String TAG = "AnalogAppWidgetProvider";

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
     static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                 int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(),
                R.layout.analog_appwidget);

        views.setOnClickPendingIntent(R.id.analog_appwidget,
                PendingIntent.getActivity(context, 0,
                        new Intent(context, MainActivity.class), 0));


        appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager,
                                          int appWidgetId, Bundle newOptions) {

        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // Perform any action when one or more AppWidget instances have been deleted
    }

    @Override
    public void onEnabled(Context context) {
        // Perform any action when an AppWidget for this provider is instantiated
    }

    @Override
    public void onDisabled(Context context) {
        // Perform any action when the last AppWidget instance for this provider is deleted
    }
}
*/
