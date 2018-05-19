package com.smart.DemoClassIncharge;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.smart.DemoClassIncharge.teaching.AboutUs;

import java.lang.reflect.Method;

import static android.content.Context.MODE_PRIVATE;
import static com.smart.DemoClassIncharge.R.id.myWebView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainActivity1 {








    //initializing WebView
    private WebView mwebView;
    private final String LOGIN_PAGE_URL = "http://ssteckservices.com:8080/democlassincharge/login.xhtml";
    private final String DASHBOARD_PAGE_URL = "http://ssteckservices.com:8080/democlassincharge/dashboardadmin.xhtml";
    private boolean isAlreadyLoggedIn;
    private boolean networkAvailable;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        findViewById(R.id.drawer_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We normally won't show the welcome slider again in real app
                // but this is for testing
                PrefManager prefManager = new PrefManager(getApplicationContext());

                // make first time launch TRUE
                prefManager.setFirstTimeLaunch(true);

                startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                finish();
            }
        });









        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);





        //WebView
        mwebView = (WebView) findViewById(myWebView);
        WebSettings webSettings = mwebView.getSettings();
        webSettings.setJavaScriptEnabled(true);



        String webUrl = mwebView.getUrl();
        mwebView.loadUrl(webUrl);
        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("key", "value");
        editor.commit();
        mwebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                try {
                    if (url.contains(LOGIN_PAGE_URL) && isAlreadyLoggedIn) {
                        // User is already logged in so show exit dialog and exit if user press yes
                        // <Your Dialog Code>
                        // call finish(); when user press yes
                    } else if (url.contains(DASHBOARD_PAGE_URL)) {
                        /* if this is true then user is logged in because user will be redirected to
                        DashBoard link only if he entered valid credentials.

                        Now change our flag to true so next time when user is redirected to login screen
                        then the first condition will get true and the exit dialog will be shown.
                         */
                        isAlreadyLoggedIn = true;
                    }
                    view.loadUrl(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        //improve webView performance
        mwebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        mwebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mwebView.getSettings().setAppCacheEnabled(true);
        mwebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);

        mwebView.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webSettings.setEnableSmoothTransition(true);


        mwebView.loadUrl("javascript:window.location.reload( true )");
        mwebView.loadUrl("http://ssteckservices.com:8080/democlassincharge/login.xhtml");






        //force links open in webview only
        mwebView.setWebViewClient(new MyWebviewClient());


// specify the url of the web page in loadUrl function


        mwebView.requestFocus();

    }
    private void reflectHiddenMethod( final WebView webview, final String name ) {

        if ( webview != null ) {
            try {
                Method method = WebView.class.getMethod( name );
                Object invoke = method.invoke( webview );
            }
            catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Logout) {

            mwebView.loadUrl("http://ssteckservices.com:8080/democlassincharge/logout.xhtml");
            Toast.makeText(getApplicationContext(), "Logout Successful!", Toast.LENGTH_LONG).show();

            mwebView.requestFocus();
        } else if (id == R.id.Home) {

            mwebView.loadUrl("http://ssteckservices.com:8080/democlassincharge/dashboardadmin.xhtml");

            Toast.makeText(getApplicationContext(), "Welcome To Home Page", Toast.LENGTH_LONG).show();
        }


        return super.onOptionsItemSelected(item);
    }









    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.AboutUs) {


            Intent intent=new Intent(this, AboutUs.class);
            startActivity(intent);

        }
        else if (id == R.id.ContactUs) {

            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            final String[] phone={"04448516326"};
            alert.setTitle("Helpline Number:");
            alert.setItems(phone, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone[i].toString()));
                    startActivity(intent);
                }
            });
            alert.create().show();

        }
        else if (id == R.id.FeedBack) {

            try{
                Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "smartstudenterp@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Your Subject:");
                intent.putExtra(Intent.EXTRA_TEXT, "Your Feedback:");
                startActivity(intent);
            }catch(ActivityNotFoundException e){

            }

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


        return true;
    }

    public boolean isNetworkAvailable() {
        return networkAvailable;
    }

    private class MyWebviewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().equals("http://ssteckservices.com:8080/democlassincharge/dashboardadmin.xhtml"))

            {
                //open url contents in webview
                return false;
            } else {
                //here open external links in external browser or app
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }




        }
        //ProgressDialogue
        ProgressDialog pd = null;

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            pd=new ProgressDialog(MainActivity.this);
            pd.setTitle("Please Wait..");
            pd.setMessage("Connect To Network...");
            pd.show();
            super.onPageStarted(view, url, favicon);
        }





        @Override
        public void onPageFinished(WebView view, String url) {
            pd.dismiss();
            super.onPageFinished(view, url);




        }



        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            Intent intent = new Intent(
                    MainActivity.this,
                    CheckInternetConnection.class);
            finish();
            startActivity(intent);

         }


        private class Error_message {
        }
    }
    //goto previous page when pressing back button

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
        {
            return (keyCode == KeyEvent.KEYCODE_BACK ? true : super.onKeyDown(keyCode, event));
        }



    @Override
    public void onPageFinished(WebView view, String url) {

        //Is the url the login-page?
        if (url.equals("file:///android_asset/error.php")) {

            //load javascript to set the values to input fields
            SharedPreferences prefs = getPreferences(MODE_PRIVATE);
            String usr= prefs.getString("usr", null);
            String pwd= prefs.getString("pwd", null);
            if (usr== null || pwd == null) {
                //we  have no values - leave input fields blank
                return;
            }
            view.loadUrl("javascript:fillValues(" + usr + "," + pwd + ");");
            mwebView.loadUrl("file:///android_asset/error.PHP");
            mwebView.loadUrl("file:///android_asset/resume.html");
        }
    }


    public  void logout(View view){
        SharedPreferences sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();
    }

    public void close(View view){
        finish();
    }



}






class JavaScriptInterface {

    /**
     * this should be triggered when user and pwd is correct, maybe after
     * successful login
     */
    public void saveValues (String usr, String pwd) {

        if (usr == null || pwd == null) {
            return;
        }

        //save the values in SharedPrefs
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString("usr", usr);
        editor.putString("pwd", pwd);
        editor.apply();
    }

    private SharedPreferences getPreferences(int modePrivate) {
        return null;
    }

}

