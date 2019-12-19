package com.example.nikunjsingh.Tripongo;

/**
 * Created by NIKUNJ SINGH on 3/22/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {
    int city;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Bundle extras = getIntent().getExtras();
        city = extras.getInt("city");

        if (savedInstanceState == null) {
            addRssFragment();
        }
    }

    private void addRssFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        RssFragment fragment = new RssFragment();
        transaction.add(R.id.fragment_container, fragment);
        if(city==0)
        {
            Intent intent=new Intent(this,RssService.class);
            intent.putExtra("city", city);
        }
        else if(city==2)
        {
            Intent intent=new Intent(this,RssService2.class);
            intent.putExtra("city", city);
        }
        else
        {
            Intent intent=new Intent(this,RssService1.class);
            intent.putExtra("city", city);
        }
        Intent intent=new Intent(this,RssService.class);
        intent.putExtra("city", city);
        transaction.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("fragment_added", true);
    }
}