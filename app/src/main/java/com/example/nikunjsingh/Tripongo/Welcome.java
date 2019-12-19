package com.example.nikunjsingh.Tripongo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Welcome extends Activity {



    private Button log_out;
    public String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Bundle broadcastData = getIntent().getExtras();
        email = broadcastData.getString("email");
        Log.e("email in Welcome: ", email);


        log_out = (Button) findViewById(R.id.button);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

            }
        });



    }
    public void sendMessage(View view)
    {
        Intent intent = new Intent(Welcome.this, budget.class);
        intent.putExtra("email",email);
        startActivity(intent);
    }

}
