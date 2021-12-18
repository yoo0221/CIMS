package com.example.cims.HCI_layer.InformationManagement_UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cims.R;

public class ManageInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_info);

        Button btn1 = (Button) findViewById(R.id.add_sideeffect);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddSideEffectActivity.class);
                startActivity(intent);
            }
        });

        Button btn2 = (Button) findViewById(R.id.add_visitedrecord);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddVisitedRecordActivity.class);
                startActivity(intent);
            }
        });
    }
}
