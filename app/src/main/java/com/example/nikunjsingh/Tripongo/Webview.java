package com.example.nikunjsingh.Tripongo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.nikunjsingh.Tripongo.R;

public class Webview extends AppCompatActivity {

    int currentMonth;
    String email;
    int city;
    public static String add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Bundle extras = getIntent().getExtras();
        city = extras.getInt("city");

        if(city==0)
        {
            add="maps.php";
        }
        else if(city==2)
        {
            add="maps2.php";
        }
        else
        {add="maps1.php";}


        WebView view=(WebView) this.findViewById(R.id.webView);
        String url = "http://www.tripongo.byethost31.com/"+add;
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_webview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
