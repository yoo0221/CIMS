package com.example.cims.HCI_layer.Vaccine_UI;

import android.content.Intent;
import android.os.Bundle;
import com.example.cims.R;
import android.app.TabActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;


public class VaccineActivity extends AppCompatActivity {
    int vac_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);

        // 화이자 Activity로 넘어갈 버튼
        Button pfizerButton = (Button) findViewById(R.id.buttonPfizer);
        pfizerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                vac_id = 1;
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
                vac_id = 2;
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
                vac_id = 3;
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
                vac_id = 4;
                Intent intent = new Intent(getApplicationContext(), AstraZenecaActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }


}