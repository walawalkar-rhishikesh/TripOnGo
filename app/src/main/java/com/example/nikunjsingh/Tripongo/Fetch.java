package com.example.nikunjsingh.Tripongo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Fetch extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextId;
    private Button buttonGet;
    private TextView textViewResult;
    private TextView textViewResult1;

    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);

        editTextId = (EditText) findViewById(R.id.editTextId);
        buttonGet = (Button) findViewById(R.id.buttonGet);
        textViewResult = (TextView) findViewById(R.id.textViewResult);


        buttonGet.setOnClickListener(this);
    }

    private void getData() {
        String id = editTextId.getText().toString().trim();
        if (id.equals("")) {
            Toast.makeText(this, "Please enter your Interest", Toast.LENGTH_LONG).show();
            return;
        }
        loading = ProgressDialog.show(this,"Please wait...","Making Plans...",false,false);

        String url = Config.DATA_URL+editTextId.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Fetch.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response){
        String name="";
        String name1="";
        String address="";
        String address1="";

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            name = collegeData.getString(Config.KEY_NAME);
            name1 = collegeData.getString(Config.KEY_NAME1);
            address = collegeData.getString(Config.KEY_ADDRESS);
            address1 = collegeData.getString(Config.KEY_ADDRESS1);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        textViewResult.setText("Name:\t"+name+"\nAddress:\t" +address);
        textViewResult.setText("Name:\t"+name+"\nAddress:\t" +address);
        textViewResult1.setText("Name:\t"+name1+"\nAddress:\t" +address1);
    }

    @Override
    public void onClick(View v) {
        getData();
    }
}