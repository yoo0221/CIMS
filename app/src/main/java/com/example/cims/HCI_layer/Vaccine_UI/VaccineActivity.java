package com.example.cims.HCI_layer.Vaccine_UI;

import android.content.Intent;
import android.os.Bundle;

import com.example.cims.HCI_layer.MenuActivity;
import com.example.cims.MainActivity;
import com.example.cims.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.app.TabActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class VaccineActivity extends AppCompatActivity {
    int vac_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);

        Toolbar toolbar = (Toolbar)findViewById(R.id.topbar_vaccine);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 (왼쪽)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);


        FloatingActionButton btn_home = findViewById(R.id.fab_home_vaccine);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
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
}