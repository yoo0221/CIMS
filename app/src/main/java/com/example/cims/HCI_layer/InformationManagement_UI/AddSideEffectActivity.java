package com.example.cims.HCI_layer.InformationManagement_UI;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.cims.DM_layer.AddSideEffectRequest;
import com.example.cims.PD_layer.Vaccine.SideEffect.SideEffect;
import com.example.cims.R;

import org.json.JSONException;
import org.json.JSONObject;

public class AddSideEffectActivity extends AppCompatActivity {

    private Spinner vaccineNameInput;
    private EditText symptomInput, getSymptomInput, treatmentInput, occurProbabilityInput;
    private Button cancel_btn, add_btn;
    private AlertDialog dialog;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_side_effect);

        //아이디 값 찾아주기
        vaccineNameInput = (Spinner) findViewById(R.id.vaccineNameInput);
        symptomInput = (EditText) findViewById(R.id.symptomInput);
        getSymptomInput = (EditText) findViewById(R.id.getSymptomInput);
        treatmentInput = (EditText) findViewById(R.id.treatmentInput);
        occurProbabilityInput = (EditText) findViewById(R.id.occurProbabilityInput);

        //Spinner 설정
        String[] vaccines = {"화이자", "모더나", "얀센", "아스트라제네카"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                vaccines);
        vaccineNameInput.setAdapter(adapter);
        vaccineNameInput.setSelection(0);

        //입력 버튼 클릭 시 수행
        add_btn = findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //각 EditText에 현재 입력되어 있는 값 가져오기
                /*final*/ int vaccineId = vaccineNameInput.getSelectedItemPosition()+1;
                /*final*/ String symptom = symptomInput.getText().toString();
                /*final*/ String treatment = treatmentInput.getText().toString();
                /*final*/ int getSymptom = Integer.parseInt(getSymptomInput.getText().toString());
                          double occurProbability = Double.parseDouble(occurProbabilityInput.getText().toString());

                //입력되지 않은 칸이 있을 경우
                if (Integer.toString(vaccineId).equals("") || symptom.equals("") || Integer.toString(getSymptom).equals("") || treatment.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddSideEffectActivity.this);
                    builder.setMessage("모든 칸을 입력하세요.");
                    builder.setPositiveButton("확인", null);
                    dialog = builder.create();
                    dialog.show();
                }
                else {
                    //추가 여부 재확인
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddSideEffectActivity.this);
                    builder.setMessage("부작용 정보를 추가하시겠습니까?");
                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id) {
                            SideEffect sideEffect = new SideEffect(symptom, treatment, getSymptom, occurProbability);
                            Toast.makeText(getApplicationContext(), "부작용 정보 전송 시작", Toast.LENGTH_SHORT).show();
                            //Response listener 활성화
                            Response.Listener<String> responseListener = new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonObject = new JSONObject(response);
                                        boolean success = jsonObject.getBoolean("success");
                                        if (success) {
                                            Toast.makeText(getApplicationContext(), "부작용 정보가 추가되었습니다.", Toast.LENGTH_LONG).show();
                                            Intent intent = new Intent(getApplicationContext(), ManageInfoActivity.class);
                                            startActivity(intent);    //정보 관리 화면으로 돌아감
                                        }
                                        else {
                                            Toast.makeText(getApplicationContext(), "부작용 정보 추가에 실패하였습니다.", Toast.LENGTH_LONG).show();
                                            return;
                                        }
                                    } catch (JSONException e) {
                                        Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                                        e.printStackTrace();
                                    }
                                }
                            };

                            //Toast.makeText(getApplicationContext(), "request 요청", Toast.LENGTH_LONG).show();
                            AddSideEffectRequest addSideEffectRequest = new AddSideEffectRequest(vaccineId, sideEffect, responseListener);
                            RequestQueue queue = Volley.newRequestQueue(AddSideEffectActivity.this);
                            queue.add(addSideEffectRequest);

                        }
                    });
                    builder.setNegativeButton("취소", null);  //취소 선택 시 부작용 입력 화면으로 복귀
                    dialog = builder.create();
                    dialog.show();
                }
            }
        });

        //취소 버튼 클릭 시 수행
        cancel_btn = findViewById(R.id.cancel_btn);
        cancel_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), ManageInfoActivity.class);
                startActivity(intent);  //정보 관리 화면으로 돌아감
                finish();
                Toast.makeText(getApplicationContext(), "취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}