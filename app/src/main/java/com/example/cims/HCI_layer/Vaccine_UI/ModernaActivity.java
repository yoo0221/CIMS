package com.example.cims.HCI_layer.Vaccine_UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cims.R;


public class ModernaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moderna);

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


}