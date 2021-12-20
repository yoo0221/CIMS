package com.example.cims.HCI_layer.ConfirmedCase_UI;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.cims.DM_layer.LoadVisitedRecordTableRequest;
import com.example.cims.DM_layer.VolleyCallBack;
import com.example.cims.HCI_layer.MenuActivity;
import com.example.cims.PD_layer.ConfirmedCase.Place;
import com.example.cims.PD_layer.ConfirmedCase.VisitedRecord.VisitRecord;
import com.example.cims.MainActivity;
import com.example.cims.R;
import com.example.cims.databinding.ActivityConfirmedCaseBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import com.example.cims.HCI_layer.ConfirmedCase_UI.TabbedUI.SectionsPagerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class ConfirmedCaseActivity extends AppCompatActivity {
    private ActivityConfirmedCaseBinding binding;
    private ArrayList<Place> placeArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar)findViewById(R.id.topbar_confirmedcase);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
/*
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 (왼쪽)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

        FloatingActionButton btn_home = findViewById(R.id.fab_home_confirmedcase);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });*/

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
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // 왼쪽 상단 버튼 눌렀을 때
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
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
                        VisitRecord visitRecord = new VisitRecord(jsonObject.getString("visitedDate"), jsonObject.getString("place"), jsonObject.getString("address"));
                        place.appenRecord(visitRecord);
                        placeArrayList.add(place);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        LoadVisitedRecordTableRequest loadVisitedRecordTableRequest = new LoadVisitedRecordTableRequest(responseListener);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(loadVisitedRecordTableRequest);
    }
}