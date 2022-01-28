package com.ozturkomerfaruk.a31aralik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button btnRequest;
    EditText editTxtRequest;
    RequestQueue mRequestQueue;

    TextView txtName;
    TextView txtCountry;
    TextView txtTemp;
    TextView txtFeelsLike;
    TextView txtTempMin;
    TextView txtTempMax;
    TextView txtPressure;
    TextView txtHumidity;

    TextView txtCoords;
    TextView txtDescripton;

    ImageView imgViewIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRequest = findViewById(R.id.btnRequest);

        txtName = findViewById(R.id.txtName);
        txtCountry = findViewById(R.id.txtCountry);
        txtTemp = findViewById(R.id.txtTemp);
        txtFeelsLike = findViewById(R.id.txtFeelsLike);
        txtTempMin = findViewById(R.id.txtTempMin);
        txtTempMax = findViewById(R.id.txtTempMax);
        txtPressure = findViewById(R.id.txtPressure);
        txtHumidity = findViewById(R.id.txtHumidity);

        txtCoords = findViewById(R.id.txtCoords);
        txtDescripton = findViewById(R.id.txtDescription);

        imgViewIcon = findViewById(R.id.imgViewIcon);

        editTxtRequest = findViewById(R.id.editTxtRequest);


        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTxtRequest.getText() == null) {
                    Toast.makeText(MainActivity.this, "Sehir Bulunamadı!", Toast.LENGTH_LONG).show();
                    return;
                }
                mRequestQueue = Volley.newRequestQueue(getApplicationContext());
                String Sehir = editTxtRequest.getText().toString();
                String Url = "https://api.openweathermap.org/data/2.5/weather?q=" + Sehir + "&appid=352d1bd1838b7aa765b22e9d8ec50b41";


                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String coord = response.getJSONObject("coord").toString();
                            txtCoords.setText(coord);

                            JSONObject weather = (JSONObject) response.getJSONArray("weather").get(0);
                            String description = weather.getString("description");
                            String icon = weather.getString("icon");
                            txtDescripton.setText(description);

                            JSONObject main = (JSONObject) response.getJSONObject("main");
                            String temp = main.getString("temp");
                            txtTemp.setText(temp);
                            String feels_like = main.getString("feels_like");
                            txtFeelsLike.setText(feels_like);
                            String temp_min = String.valueOf(main.getDouble("temp_min"));
                            txtTempMin.setText(temp_min);
                            String temp_max = main.getString("temp_max");
                            txtTempMax.setText(temp_max);
                            String pressure = main.getString("pressure");
                            txtPressure.setText(pressure);
                            String humidity = main.getString("humidity");
                            txtHumidity.setText(humidity);

                            String iconUrl = "http://openweathermap.org/img/wn/"+icon+"d@2x.png";
                            Picasso.get().load(iconUrl).into(imgViewIcon, new Callback() {
                                @Override
                                public void onSuccess() {

                                }

                                @Override
                                public void onError(Exception e) {

                                }
                            });

                            //String name = response.getJSONObject("name").toString();
                            txtName.setText(editTxtRequest.getText());

                            JSONObject sys = response.getJSONObject("sys");
                            String country = sys.getString("country");
                            txtCountry.setText(country);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                mRequestQueue.add(jsonObjectRequest);
            }
        });


    }
}
