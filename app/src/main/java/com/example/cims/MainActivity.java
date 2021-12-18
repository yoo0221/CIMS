package com.example.cims;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.cims.HCI_layer.ConfirmedCase_UI.ConfirmedCaseActivity;
import com.example.cims.HCI_layer.InformationManagement_UI.ManageInfoActivity;
import com.example.cims.HCI_layer.Vaccine_UI.VaccineActivity;
import com.google.android.material.bottomappbar.BottomAppBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.topbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        //BottomAppBar bottombar = (BottomAppBar) findViewById(R.id.bottombar);
        //setSupportActionBar(bottombar);
/*
        Button btn_home = findViewById(R.id.menu_home);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });*/

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
        String code = "abcd123#";
        btn3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setTitle("관리자 권한접근");
                ad.setMessage("관리자코드를 입력하시오.");

                final EditText et = new EditText(MainActivity.this);
                ad.setView(et);

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = et.getText().toString();
                        dialog.dismiss();
                        if (code.equals(result)) {
                            Intent intent = new Intent(getApplicationContext(), ManageInfoActivity.class);
                            startActivity(intent);
                        }
                    }
                });

                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.show();
                return true;
            }

        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.topbar_menu, menu);
        return true;
    }

    //ToolBar에 추가된 항목의 select 이벤트를 처리하는 함수
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.menu_notice:
                Toast.makeText(getApplicationContext(), "알람 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }

}