package com.example.nikunjsingh.Tripongo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.DatePicker;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

public class budget extends AppCompatActivity {
    public String email;
    int currentMonth;
    DatePicker picker;
    Button savedate;
    TextView textview6;
    int city;

    public String getCurrentDate(){
        StringBuilder builder=new StringBuilder();
        builder.append("Current Date: ");
        builder.append((picker.getMonth() + 1)+"/");//month is 0 based
        builder.append(picker.getDayOfMonth()+"/");
        builder.append(picker.getYear());
        currentMonth=(picker.getMonth() + 1);
        return builder.toString();
    }
    ArrayList<String> selection = new ArrayList<String>();
    TextView final_text;


    private RequestQueue requestQueue;
    private static String log_mumbai = "http://tripongo.hol.es/mumbai_liked.php?id=";
    private static String log_delhi = "http://tripongo.hol.es/delhi_liked.php?id=";
    private static String log_goa = "http://tripongo.hol.es/goa_liked.php?id=";



    private StringRequest request;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        textview6=(TextView)findViewById(R.id.textView6);
        picker = (DatePicker) findViewById(R.id.datePicker);
        savedate = (Button) findViewById(R.id.savedate);

        savedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview6.setText(getCurrentDate());
            }

        });

        Bundle broadcastData = getIntent().getExtras();
        email = broadcastData.getString("email");
        Log.e("email in budget: ", email);

        log_mumbai = log_mumbai + email;
        log_delhi = log_delhi + email;
        log_goa = log_goa + email;


        Log.e("url of mumbai",log_mumbai);
        Log.e("url of delhi",log_delhi);
        Log.e("url of goa",log_goa);


        requestQueue = Volley.newRequestQueue(this);

    }



    public void mumbaiLike(View view)
    {
        final Button mumbai = (Button)findViewById(R.id.mumbai);

        StringRequest stringRequest = new StringRequest(log_mumbai, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response mumbai", response);
                mumbai.setClickable(false);
                mumbai.setText("Selected");


                Log.e("Response mumbaiLike:", response);
                showJSON(response);
                city=2;
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(budget.this, error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(budget.this);
        requestQueue.add(stringRequest);

    }


    public void delhiLike(View view)
    {
        final Button delhi = (Button)findViewById(R.id.delhi);

        StringRequest stringRequest = new StringRequest(log_delhi, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response delhi", response);
                delhi.setClickable(false);
                delhi.setText("Selected");


                Log.e("Response delhiLike:", response);
                showJSON(response);
                city=1;
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(budget.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(budget.this);
        requestQueue.add(stringRequest);

    }


    public void goaLike(View view)
    {
        final Button goa = (Button)findViewById(R.id.goa);

        StringRequest stringRequest = new StringRequest(log_goa, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response goa", response);
                goa.setClickable(false);
                goa.setText("Selected");


                Log.e("Response goaLike:", response);
                showJSON(response);
                city=0;
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(budget.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(budget.this);
        requestQueue.add(stringRequest);

    }



    private void showJSON(String response) {

        try {
            JSONObject jsonObject = new JSONObject(response);

            Log.e("JSON object", "Created");

            if (jsonObject.names().get(0).equals("success")) {
                Toast.makeText(budget.this, "SUCCESS " + jsonObject.getString("success"), Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(budget.this, response, Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(budget.this, Interest.class);
        intent.putExtra("email",email);
        intent.putExtra("currentMonth",currentMonth);
        intent.putExtra("city",city);

        startActivity(intent);
    }

}
