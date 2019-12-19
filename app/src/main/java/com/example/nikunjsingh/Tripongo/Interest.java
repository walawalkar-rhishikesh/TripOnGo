package com.example.nikunjsingh.Tripongo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Interest extends AppCompatActivity {
    public String email;
    public int currentMonth;
    int city;


    ArrayList<String> selection = new ArrayList<String>();
    TextView final_text;



    private RequestQueue requestQueue;
    private static String log_shopping = "http://tripongo.hol.es/shopping_liked.php?id=";
    private static String log_historic = "http://tripongo.hol.es/historic_liked.php?id=";
    private static String log_mosque = "http://tripongo.hol.es/mosque_liked.php?id=";
    private static String log_beach = "http://tripongo.hol.es/beach_liked.php?id=";
    private static String log_temple = "http://tripongo.hol.es/temple_liked.php?id=";
    private static String log_garden = "http://tripongo.hol.es/garden_liked.php?id=";
    private static String log_church = "http://tripongo.hol.es/church_liked.php?id=";
    private static String log_waterpark = "http://tripongo.hol.es/waterpark_liked.php?id=";
    private static String log_planetarium = "http://tripongo.hol.es/planetarium_liked.php?id=";
    private static String log_chineese = "http://tripongo.hol.es/chineese_liked.php?id=";
    private static String log_western = "http://tripongo.hol.es/western_liked.php?id=";
    private static String log_punjabi = "http://tripongo.hol.es/punjabi_liked.php?id=";
    private static String log_italian = "http://tripongo.hol.es/italian_liked.php?id=";
    private static String log_desserts = "http://tripongo.hol.es/desserts_liked.php?id=";
    private static String log_mughlai = "http://tripongo.hol.es/mughlai_liked.php?id=";
    private static String log_mexican = "http://tripongo.hol.es/mexican_liked.php?id=";
    private static String log_continental = "http://tripongo.hol.es/continental_liked.php?id=";
    private StringRequest request;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        Bundle broadcastData = getIntent().getExtras();
        email = broadcastData.getString("email");
        currentMonth = broadcastData.getInt("currentMonth");
        city = broadcastData.getInt("city");
        Log.e("email in Interest: ", email);

        log_shopping = log_shopping + email;
        log_historic = log_historic + email;
        log_mosque = log_mosque + email;
        log_beach = log_beach + email;
        log_temple = log_temple + email;
        log_garden = log_garden + email;
        log_church = log_church + email;
        log_waterpark = log_waterpark + email;
        log_planetarium = log_planetarium + email;
        log_chineese = log_chineese + email;
        log_western = log_western + email;
        log_punjabi = log_punjabi + email;
        log_italian = log_italian + email;
        log_desserts = log_desserts + email;
        log_mughlai = log_mughlai + email;
        log_mexican = log_mexican + email;
        log_continental = log_continental + email;

        Log.e("url of shopping",log_shopping);
        Log.e("url of historic",log_historic);
        Log.e("url of mosque",log_mosque);
        Log.e("url of beach",log_beach);
        Log.e("url of temple",log_temple);
        Log.e("url of garden",log_garden);
        Log.e("url of church",log_church);
        Log.e("url of waterpark",log_waterpark);
        Log.e("url of planetarium",log_planetarium);
        Log.e("url of chineese",log_chineese);
        Log.e("url of western",log_western);
        Log.e("url of punjabi",log_punjabi);
        Log.e("url of italian",log_italian);
        Log.e("url of desserts",log_desserts);
        Log.e("url of mughlai",log_mughlai);
        Log.e("url of mexican",log_mexican);
        Log.e("url of continental",log_continental);



        requestQueue = Volley.newRequestQueue(this);

    }



    public void shoppingLike(View view)
    {
        final Button shopping = (Button)findViewById(R.id.shopping);

        StringRequest stringRequest = new StringRequest(log_shopping, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response shopping", response);
                shopping.setClickable(false);
                shopping.setText("Liked");


                Log.e("Response shoppingLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }






    public void historicLike(View view)
    {
        final Button historic = (Button)findViewById(R.id.historic);

        StringRequest stringRequest = new StringRequest(log_historic, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response shopping", response);
                historic.setClickable(false);
                historic.setText("Liked");


                Log.e("Response shoppingLike:",response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }


    public void mosqueLike(View view)
    {
        final Button mosque = (Button)findViewById(R.id.mosque);

        StringRequest stringRequest = new StringRequest(log_mosque, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response mosque", response);
                mosque.setClickable(false);
                mosque.setText("Liked");


                Log.e("Response mosqueLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }

    public void beachLike(View view)
    {
        final Button beach = (Button)findViewById(R.id.beach);

        StringRequest stringRequest = new StringRequest(log_beach, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response beach", response);
                beach.setClickable(false);
                beach.setText("Liked");


                Log.e("Response beachLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }


    public void templeLike(View view)
    {
        final Button temple = (Button)findViewById(R.id.temple);

        StringRequest stringRequest = new StringRequest(log_temple, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response shopping", response);
                temple.setClickable(false);
                temple.setText("Liked");


                Log.e("Response templeLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }


    public void gardenLike(View view)
    {
        final Button garden = (Button)findViewById(R.id.garden);

        StringRequest stringRequest = new StringRequest(log_garden, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response garden", response);
                garden.setClickable(false);
                garden.setText("Liked");


                Log.e("Response gardenLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }

    public void churchLike(View view)
    {
        final Button church = (Button)findViewById(R.id.church);

        StringRequest stringRequest = new StringRequest(log_church, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response church", response);
                church.setClickable(false);
                church.setText("Liked");


                Log.e("Response churchLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }

    public void waterparkLike(View view)
    {
        final Button waterpark = (Button)findViewById(R.id.waterpark);

        StringRequest stringRequest = new StringRequest(log_waterpark, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response waterpark", response);
                waterpark.setClickable(false);
                waterpark.setText("Liked");


                Log.e("Response waterparkLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }

    public void planetariumLike(View view)
    {
        final Button planetarium = (Button)findViewById(R.id.planetarium);

        StringRequest stringRequest = new StringRequest(log_planetarium, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response planetarium", response);
                planetarium.setClickable(false);
                planetarium.setText("Liked");


                Log.e("Response planetLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }

    public void chineeseLike(View view)
    {
        final Button chineese = (Button)findViewById(R.id.chineese);

        StringRequest stringRequest = new StringRequest(log_chineese, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response shopping", response);
                chineese.setClickable(false);
                chineese.setText("Liked");


                Log.e("Response chineeseLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }

    public void westernLike(View view)
    {
        final Button western = (Button)findViewById(R.id.western);

        StringRequest stringRequest = new StringRequest(log_western, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response western", response);
                western.setClickable(false);
                western.setText("Liked");


                Log.e("Response westernLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }

    public void punjabiLike(View view)
    {
        final Button punjabi = (Button)findViewById(R.id.punjabi);

        StringRequest stringRequest = new StringRequest(log_punjabi, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response punjabi", response);
                punjabi.setClickable(false);
                punjabi.setText("Liked");


                Log.e("Response punjabiLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }


    public void italianLike(View view)
    {
        final Button italian = (Button)findViewById(R.id.italian);

        StringRequest stringRequest = new StringRequest(log_italian, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response italian", response);
                italian.setClickable(false);
                italian.setText("Liked");


                Log.e("Response italianLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }

    public void dessertsLike(View view)
    {
        final Button desserts = (Button)findViewById(R.id.desserts);

        StringRequest stringRequest = new StringRequest(log_desserts, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response desserts", response);
                desserts.setClickable(false);
                desserts.setText("Liked");


                Log.e("Response dessertsLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }

    public void mughlaiLike(View view)
    {
        final Button mughlai = (Button)findViewById(R.id.mughlai);

        StringRequest stringRequest = new StringRequest(log_mughlai, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response mughlai", response);
                mughlai.setClickable(false);
                mughlai.setText("Liked");


                Log.e("Response mughlaiLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }

    public void mexicanLike(View view)
    {
        final Button mexican = (Button)findViewById(R.id.mexican);

        StringRequest stringRequest = new StringRequest(log_mexican, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response mexican", response);
                mexican.setClickable(false);
                mexican.setText("Liked");


                Log.e("Response mexicanLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }

    public void continentalLike(View view)
    {
        final Button continental = (Button)findViewById(R.id.continental);

        StringRequest stringRequest = new StringRequest(log_continental, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response continental", response);
                continental.setClickable(false);
                continental.setText("Liked");


                Log.e("Response continentalLike:", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error:", "OnErrorResponse");
                        Toast.makeText(Interest.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Interest.this);
        requestQueue.add(stringRequest);

    }


    private void showJSON(String response) {

        try {
            JSONObject jsonObject = new JSONObject(response);

            Log.e("JSON object", "Created");

            if (jsonObject.names().get(0).equals("success")) {
                Toast.makeText(Interest.this, "SUCCESS " + jsonObject.getString("success"), Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(Interest.this, response, Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(Interest.this, Listview.class);
        intent.putExtra("currentMonth",currentMonth);
        intent.putExtra("email",email);
        intent.putExtra("city",city);
        startActivity(intent);
    }

}
