package com.example.cims.HCI_layer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cims.HCI_layer.ConfirmedCase_UI.ConfirmedCaseActivity;
import com.example.cims.HCI_layer.Vaccine_UI.VaccineActivity;
import com.example.cims.MainActivity;
import com.example.cims.R;

public class MenuActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btn = (Button) findViewById(R.id.go_home);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button btn1 = (Button) findViewById(R.id.go_sideeffect);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VaccineActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button btn2 = (Button) findViewById(R.id.go_visitedrecord);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ConfirmedCaseActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
