package com.example.doanfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityHome extends AppCompatActivity {
    ImageView restaurant_vector_home;
    ListView lsvHome;
    CustomAdapterShop adapter;
    ArrayList<Shop> lvData=new ArrayList<>();
    String url = "http://192.168.0.106/FoodReview/dulieushop.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        restaurant_vector_home = findViewById(R.id.restaurant_vector_home);
        restaurant_vector_home.bringToFront();
        lsvHome =(ListView) findViewById(R.id.lsvHome);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseJsonDataToArrayList(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error Data!", Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue queue = Volley.newRequestQueue(ActivityHome.this);
        queue.add(request);
    }


    public void parseJsonDataToArrayList (String response) {
        try {
            JSONObject object = new JSONObject(response);
            JSONArray jsonArray = object.getJSONArray("shops");
            for(int i=0;i<jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Shop s = new Shop();
                s.id = jsonObject.getInt("Id");
                s.name = jsonObject.getString("Name");
                s.address=jsonObject.getString("Address");
                s.number=jsonObject.getString("Number");
                String imgString = jsonObject.getString("Image");

                byte[] imgbyte = android.util.Base64.decode(imgString, android.util.Base64.DEFAULT);
                s.image= imgbyte;
                double rate;
                if(jsonObject.isNull("Rate")){
                    s.rate = 0;
                }else{
                    s.rate = jsonObject.getDouble("Rate");
                }
                lvData.add(s);
            }
            adapter=new CustomAdapterShop(getApplicationContext(),
                    R.layout.home_shop_item,lvData);
            lsvHome.setAdapter(adapter);
        } catch (JSONException e){
            e.printStackTrace();
        }

    }
}