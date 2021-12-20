package com.example.cims.HCI_layer.Vaccine_UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.cims.DM_layer.LoadSideEffectRequest;
import com.example.cims.HCI_layer.MenuActivity;
import com.example.cims.MainActivity;
import com.example.cims.PD_layer.Vaccine.SideEffect.SideEffect;
import com.example.cims.PD_layer.Vaccine.Vaccine;
import com.example.cims.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;


public class ModernaActivity extends AppCompatActivity {
    private TextView listView;
    private Button btn_loadse_m;
    private int vac_id = 2;
    private Vaccine moderna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moderna);

        Toolbar toolbar = (Toolbar)findViewById(R.id.topbar_morderna);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 (왼쪽)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);


        FloatingActionButton btn_home = findViewById(R.id.fab_home_morderna);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject;
                    for(int i = 0;i < jsonArray.length();i++){
                        jsonObject = (JSONObject) jsonArray.opt(i);
                        if(i == 0)
                            moderna = new Vaccine(jsonObject.getString("name"),
                                    jsonObject.getInt("vaccinated"),
                                    jsonObject.getInt("dead"));
                        SideEffect sideEffect = new SideEffect(jsonObject.getString("symtom"),
                                jsonObject.getString("treatment"),
                                jsonObject.getInt("getsym"),
                                jsonObject.getDouble("occurprob"));
                        moderna.appendSideEffect(sideEffect);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        LoadSideEffectRequest loadSideEffectRequest = new LoadSideEffectRequest(vac_id, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(loadSideEffectRequest);

        // 동적 생성 관련 코드(DB에서의 데이터 불러오기를 일단은 버튼으로 표현)
        listView = findViewById(R.id.listView_astrazeneca);
        btn_loadse_m = findViewById(R.id.btn_loadse_m);
        btn_loadse_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = 0;
                listView.setText("No.    부작용 설명\n");
                Iterator<SideEffect> itr = moderna.requestSideInfo().iterator();
                while(itr.hasNext()) {
                    i++;
                    SideEffect sideEffect = itr.next();
                    listView.setText(listView.getText()
                            + Integer.toString(i)
                            + "    " + sideEffect.getSymptom()
                            + "  " + sideEffect.getTreatment()
                            + "  " + Integer.toString(sideEffect.getGetSymptom())
                            + "  " + Double.toString(sideEffect.getOccurProbability()) + "\n");
                }
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
