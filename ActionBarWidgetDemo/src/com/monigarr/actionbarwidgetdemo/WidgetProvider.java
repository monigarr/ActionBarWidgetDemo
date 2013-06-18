package com.monigarr.actionbarwidgetdemo;

//send a link to post to our app 

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;


public class WidgetProvider extends AppWidgetProvider {
	
	DateFormat df = new SimpleDateFormat("hh:mm:ss");

	public static String CLOCK_WIDGET_UPDATE = "CLOCK_WIDGET_UPDATE";

	// Intent Receive Time
	@Override
	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);

		if (CLOCK_WIDGET_UPDATE.equals(intent.getAction())) {
			Toast.makeText(context, "onReceiver()", Toast.LENGTH_LONG).show();
		}
	}

	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		final int N = appWidgetIds.length;

		Log.i("Widget", "Updating widgets " + Arrays.asList(appWidgetIds));

		// Perform this loop for each Widget that belongs to this provider
		for (int i = 0; i < N; i++) {
			int appWidgetId = appWidgetIds[i];

			// Create Intent to launch MainFeedActivity
			Intent intent = new Intent(context, MainFeedActivity.class);
			PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
					intent, 0);

			// Get layout for Widget and attach an on-click listener to button
			RemoteViews views = new RemoteViews(context.getPackageName(),
					R.layout.widget);
			views.setOnClickPendingIntent(R.id.button, pendingIntent);

			// Update label
			views.setTextViewText(R.id.widgetlabel, df.format(new Date()));

			// Tell AppWidgetManager to perform update on current widget
			appWidgetManager.updateAppWidget(appWidgetId, views);
		}
	}

	// Show Time
	public static void updateAppWidget(Context context,
		AppWidgetManager appWidgetManager, int appWidgetId) {
		//String currentTime = formatter.format(new Date());
		String currentTime = "1:00 pm";
		String strWidgetText = currentTime;

		RemoteViews updateViews = new RemoteViews(context.getPackageName(),
				R.layout.widget);
		updateViews.setTextViewText(R.id.widgetlabel,
				"[" + String.valueOf(appWidgetId) + "]" + strWidgetText);
		appWidgetManager.updateAppWidget(appWidgetId, updateViews);

		Toast.makeText(
				context,
				"updateAppWidget(): " + String.valueOf(appWidgetId) + "\n"
						+ strWidgetText, Toast.LENGTH_LONG).show();
	}
}