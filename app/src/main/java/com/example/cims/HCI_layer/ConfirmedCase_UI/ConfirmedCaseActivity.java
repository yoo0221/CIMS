package com.example.cims.HCI_layer.ConfirmedCase_UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.cims.DM_layer.LoadVisitedRecordRequest;
import com.example.cims.DM_layer.VolleyCallBack;
import com.example.cims.HCI_layer.MenuActivity;
import com.example.cims.PD_layer.ConfirmedCase.Place;
import com.example.cims.PD_layer.ConfirmedCase.VisitedRecord.VisitRecord;
import com.example.cims.MainActivity;
import com.example.cims.R;
import com.example.cims.databinding.ActivityConfirmedCaseBinding;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import com.example.cims.HCI_layer.ConfirmedCase_UI.TabbedUI.SectionsPagerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ConfirmedCaseActivity extends AppCompatActivity {
    private ActivityConfirmedCaseBinding binding;
    private ArrayList<Place> placeArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityConfirmedCaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        getPlaces(new VolleyCallBack() {
            @Override
            public void onSuccess() {

            }
        });

        MaterialToolbar toolbar = (MaterialToolbar)findViewById(R.id.topbar_confirmedcase);
        toolbar.setNavigationOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        FloatingActionButton btn_home = findViewById(R.id.fab_home_confirmedcase);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public ArrayList<Place> getPlaceArrayList() {
        return placeArrayList;
    }


    public void getPlaces(final VolleyCallBack callBack){
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject;
                    for(int i = 0;i < jsonArray.length();i++){
                        jsonObject = (JSONObject) jsonArray.opt(i);
                        Place place = new Place(jsonObject.getDouble("lat"), jsonObject.getDouble("lng"));
                        VisitRecord visitRecord = new VisitRecord(jsonObject.getString("visitedDate"),
                                                                  jsonObject.getString("place"),
                                                                  jsonObject.getString("address"));
                        place.appendRecord(visitRecord);
                        placeArrayList.add(place);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        LoadVisitedRecordRequest loadVisitedRecordRequest = new LoadVisitedRecordRequest(responseListener);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(loadVisitedRecordRequest);
    }
}