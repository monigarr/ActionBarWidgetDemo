package com.monigarr.actionbarwidgetdemo;

/*
 * Developer: Monica Peters
 * MDF3 June 17th 2013
 * Instructor: Donna Gardinier
 * 
 * PROJECT REQUIREMENTS
 * 
 * ACTION BAR part one
 *     ACTIVITIES 2 OR MORE
 *     		MainFeedActivity, AuthenticateActivity, LoginOrSignUpActivity: 
 *     				login or register to use app.
 *     				parse.com db
 *     		AddLinkActivity: add url / note to parse.com db
 *     		SelectUsersActivity: view registered users of app. tap to check next to users.
 *     
 *     ACTIVITY NAVIGATION HANDLED THROUGH ACTION BAR
 *     1 or more quick launch icons that serve as either navigation or function (ie Search)
 *      	refresh list of links
 *      	add link
 *     		view list of users that use this mobile app
 *     		log out
 *     
 *     OVERFLOW MENU WITH AT LEAST 1 FUNCTIONAL OPTION
 *     		Follow: check to add other users to list.
 *     		Log Out: will only see login / register on main activity.
 *     		^both will show icons while in landscape view
 *     
 * WIDGET part two
 *     VIEWS 1 OR MORE
 *     1 OR MORE SUPPORTED LAUNCH INTENTS
 *     ABLE TO BE ADDED TO HOME SCREEN
 *     
 * ABOVE & BEYOND
 *     RESIZEABLE
 *     	http://developer.android.com/guide/topics/appwidgets/index.html#MetaData
 *     MULTIPLE VIEWS OR ADVANCED VIEW (STACKVIEW)
 *     	landscape layout, portrait layout
 *     RESPONSIVE INTENTS
 *     	progressbar
 *     	If user logged in last time, don't ask them to login this time.
 *      If user did not login last time, only show them the login or signup.
 *      If user logged out, only show them the login or signup view.
 *      If links are available, show them on main view.
 *      
 * Learning Resources / Tutorials
 * Parse.com used for managing database (links, users, authentication)
 * Widget http://www.vogella.com/articles/AndroidWidgets/article.html
 * Widget http://www.sitepoint.com/how-to-code-an-android-widget/
 * Responsive http://developer.android.com/training/articles/perf-anr.html
 * Action Bar http://www.vogella.com/articles/AndroidActionBar/article.html
 * Action Bar http://developer.android.com/reference/android/app/ActionBar.html
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class MainFeedActivity extends ListActivity {

	public static final String TAG = MainFeedActivity.class.getSimpleName();

	protected ProgressBar mProgressBar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
	}

	@Override
	public void onResume() {
		super.onResume();
		getLatestPosts();
	}

	protected void getLatestPosts() {
		mProgressBar.setVisibility(View.VISIBLE);

		/*
		 * Use ParseQuery to get latest posts
		 */
		ParseQuery query = new ParseQuery(AddLinkActivity.POSTS);
		query.setLimit(100);
		query.orderByDescending("createAt");
		query.findInBackground(new FindCallback() {
			public void done(List<ParseObject> results, ParseException e) {
				mProgressBar.setVisibility(View.INVISIBLE);

				if (e == null) {
					ArrayList<HashMap<String, String>> articles = new ArrayList<HashMap<String, String>>();
					for (ParseObject result : results) {
						HashMap<String, String> article = new HashMap<String, String>();
						article.put(AddLinkActivity.KEY_NOTES,
								result.getString(AddLinkActivity.KEY_NOTES));
						article.put(AddLinkActivity.KEY_URL,
								result.getString(AddLinkActivity.KEY_URL));
						articles.add(article);
					}
					SimpleAdapter adapter = new SimpleAdapter(
							MainFeedActivity.this, articles,
							android.R.layout.simple_list_item_2, new String[] {
									AddLinkActivity.KEY_NOTES,
									AddLinkActivity.KEY_URL }, new int[] {
									android.R.id.text1, android.R.id.text2 });
					setListAdapter(adapter);
				} else {
					Log.e(TAG, "Exception caught!", e);
				}
			}
		});
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		TextView urlLabel = (TextView) v.findViewById(android.R.id.text2);
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(urlLabel.getText().toString()));
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_main_list, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.addButton:
			startActivity(new Intent(this, AddLinkActivity.class));
			return true;
		case R.id.followButton:
			startActivity(new Intent(this, SelectUsersActivity.class));
			return true;
		case R.id.logoutButton:
			//clear user out of cache. they will be taken to login/signup activity
			ParseUser.logOut();
			Intent intent = new Intent(this, LoginOrSignupActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}