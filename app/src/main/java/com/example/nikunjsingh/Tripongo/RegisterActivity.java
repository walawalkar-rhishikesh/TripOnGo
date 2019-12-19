package com.example.nikunjsingh.Tripongo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends Activity {
    public EditText email, password;
    private EditText firstname, lastname, dob, mobile, city, country;
    //private RadioButton male, female;
    private Button sign_in_register;
    private RequestQueue requestQueue;
    private static final String log = "http://tripongo.hol.es/user_reg.php";
    private StringRequest request;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_register);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        // male = (RadioButton) findViewById(R.id.maleRadioButton);
        // female = (RadioButton) findViewById(R.id.femaleRadioButton);
        dob = (EditText) findViewById(R.id.dob);
        mobile = (EditText) findViewById(R.id.mobile);
        city = (EditText) findViewById(R.id.city);
        country = (EditText) findViewById(R.id.country);

        sign_in_register = (Button) findViewById(R.id.register_button);


        requestQueue = Volley.newRequestQueue(this);

        sign_in_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                request = new StringRequest(Request.Method.POST, log, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.names().get(0).equals("success")) {
                                Toast.makeText(getApplicationContext(), "SUCCESS " + jsonObject.getString("success"), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Welcome.class);
                                intent.putExtra("email", email.getText().toString());
                                startActivity(intent);
                            } else if (jsonObject.names().get(0).equals("exists")) {
                                Toast.makeText(getApplicationContext(), jsonObject.getString("exists"), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(RegisterActivity.this, "Registration error", Toast.LENGTH_SHORT).show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> hashMap = new HashMap<String, String>();
                        hashMap.put("email", email.getText().toString());
                        hashMap.put("password", password.getText().toString());
                        hashMap.put("firstname", firstname.getText().toString());
                        hashMap.put("lastname", lastname.getText().toString());
                        //hashMap.put("male", male.getText().toString());
                        //hashMap.put("female", female.getText().toString());
                        hashMap.put("mobile", mobile.getText().toString());
                        hashMap.put("dob", dob.getText().toString());
                        hashMap.put("city", city.getText().toString());
                        hashMap.put("country", country.getText().toString());
                        hashMap.put("dob", dob.getText().toString());


                        return hashMap;
                    }
                };
                requestQueue.add(request);
            }
        });
    }
}


