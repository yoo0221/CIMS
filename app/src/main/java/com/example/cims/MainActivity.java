package com.example.cims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cims.HCI_layer.ConfirmedCase_UI.ConfirmedCaseActivity;
import com.example.cims.HCI_layer.InformationManagement_UI.ManageInfoActivity;
import com.example.cims.HCI_layer.Vaccine_UI.VaccineActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.btn_vaccine);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VaccineActivity.class);
                startActivity(intent);
            }
        });

        Button btn2 = (Button) findViewById(R.id.btn_confirmedcase);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ConfirmedCaseActivity.class);
                startActivity(intent);
            }
        });

        Button btn3 = (Button) findViewById(R.id.btn_manager);
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManageInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}