package com.example.nikunjsingh.Tripongo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.nikunjsingh.Tripongo.R;

public class Options extends AppCompatActivity {

    int currentMonth;
    String email;
    int city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Bundle broadcastData = getIntent().getExtras();
        currentMonth = broadcastData.getInt("currentMonth");
        email = broadcastData.getString("email");
        city = broadcastData.getInt("city");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_options, menu);
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

    public void sendMessage(View view)
    {
        Intent intent = new Intent(Options.this, MainActivity.class);
        intent.putExtra("email",email);
        intent.putExtra("city", city);
        startActivity(intent);
    }

    public void sendMessage1(View view)
    {
        Intent intent = new Intent(Options.this, Checklist.class);
        intent.putExtra("email",email);
        intent.putExtra("currentMonth",currentMonth);
        startActivity(intent);
    }

    public void sendMessage2(View view)
    {
        Intent intent = new Intent(Options.this, Webview.class);
        intent.putExtra("email",email);
        intent.putExtra("city",city);
        startActivity(intent);
    }





}
