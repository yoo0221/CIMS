package com.example.cims.HCI_layer.Vaccine_UI;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import com.example.cims.HCI_layer.MenuActivity;
import com.example.cims.MainActivity;
import com.example.cims.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.app.TabActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class PfizerActivity extends AppCompatActivity {
    LinearLayout listView;
    Button createTextView;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pfizer);

        Toolbar toolbar = (Toolbar)findViewById(R.id.topbar_pfizer);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 (왼쪽)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);


        FloatingActionButton btn_home = findViewById(R.id.fab_home_pfizer);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        // 동적 생성 관련 코드(DB에서의 데이터 불러오기를 일단은 버튼으로 표현)
        listView = findViewById(R.id.listView);
        createTextView = findViewById(R.id.createTextView);
        createTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTextView();
            }
        });


        // 화이자 Activity로 넘어갈 버튼
        Button pfizerButton = (Button) findViewById(R.id.buttonPfizer);
        pfizerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PfizerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 모더나 Activity로 넘어갈 버튼
        Button modernaButton = (Button) findViewById(R.id.buttonModerna);
        modernaButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ModernaActivity.class);
                startActivity(intent);
                finish();
            }
        });


        // 얀센 Activity로 넘어갈 버튼
        Button janssenButton = (Button) findViewById(R.id.buttonJanssen);
        janssenButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JanssenActivity.class);
                startActivity(intent);
                finish();
            }
        });




        // 아스트라제네카 Activity로 넘어갈 버튼
        Button astraZenecaButton = (Button) findViewById(R.id.buttonAstraZeneca);
        astraZenecaButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AstraZenecaActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void createTextView() {
        TextView textViewNm = new TextView(this);
        textViewNm.getText();
        if (++i < 10) textViewNm.setText(i + "                     두통 및 현기증을 느낀다.");
        else textViewNm.setText(i + "                   두통 및 현기증을 느낀다.");
        textViewNm.setTextSize(12);
        textViewNm.setTextColor(Color.BLACK);

        textViewNm.setId(0);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        param.gravity = Gravity.TOP;
        textViewNm.setLayoutParams(param);
        listView.addView(textViewNm);
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