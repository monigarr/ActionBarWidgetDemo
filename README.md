ActionBarWidgetDemo
===================
- Mobile Development Frameworks 3.
- Full Sail University Online. 
- Java Android weekly projects.
- June 2013. 
- Instructor: Donna Gardinier
- Student: Monica Peters

PROJECT 3. WIDGETS & ACTIONBARS.  ActionBarWidgetDemo.
====
* Due Thursday June 20th 2013
* Completed Monday June 17th 2013

REQUIREMENTS:
* action bar nav. with 2 or more activities.
* action bar shortcuts. min: 1 shortcut icon, 1 option in overflow nav.
* widget to add to home screen with usable view that will launch an intent handled by the app.  The intent displays dynamically changing data.
* 2 or more activities.
* activity nav handled through action bar.
* 1 or more quick launch icons to serve as either navigation or function (search).
* overflow menu with at least 1 functional option.
* 1 or more launch intent.
* able to add to home screen.
* 1 or more views.
* extra points:  resizable, multiple views, stackview, responsive intents.

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

Learning Resources / Tutorials
 * Parse.com used for managing database (links, users, authentication)
 * Widget http://www.vogella.com/articles/AndroidWidgets/article.html
 * Widget http://www.sitepoint.com/how-to-code-an-android-widget/
 * Responsive http://developer.android.com/training/articles/perf-anr.html
 * Action Bar http://www.vogella.com/articles/AndroidActionBar/article.html
 * Action Bar http://developer.android.com/reference/android/app/ActionBar.html

 PROJECT 4. 
 ====
 * Due Thursday June 27th 2013
 * Completed 

REQUIREMENTS:
 WebView Requirements

    Well designed
    At least 1 data collection control
    At least 1 user interaction control (button, etc.)
    At least 1 JavaScript method for enhanced UI
    At least 1 JavaScript method for native integration

Native Requirements

    At least 1 meaninful Activity including a WebView
    Properly defined JavaScript interface
    At least 1 method to accept and meaningfully handle data from WebView
    At least 1 intent initiated from a method called from WebView

General Requirements

    Application should have purpose
    Application should be cohesive
    Application should follow proper UI/UX principles
