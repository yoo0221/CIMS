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

import com.example.cims.PD_layer.Vaccine.SideEffect.SideEffect;
import com.example.cims.R;

public class AddSideEffectActivity extends AppCompatActivity {

    private Spinner vaccineNameInput;
    private EditText symptomInput, getSymptomInput, treatmentInput;
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
                String vaccineName = vaccineNameInput.getSelectedItem().toString();
                String symptom = symptomInput.getText().toString();
                String treatment = treatmentInput.getText().toString();
                int getSymptom = Integer.parseInt(getSymptomInput.getText().toString());
                double occurProbability = getSymptom;


                //입력되지 않은 칸이 있을 경우
                if (vaccineName.equals("") || symptom.equals("") || Integer.toString(getSymptom).equals("") || treatment.equals("")){
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
                        public void onClick(DialogInterface dialog, int id) {    //확인 선택 시 SideEffect객체 생성 및 DB에 저장
                            //SideEffect 객체 생성 및 Vaccine 객체에 연결

                            SideEffect sideEffect = new SideEffect(symptom, treatment, getSymptom);


                            // DB 입력!
                            /* DB 입력 성공/실패시 동작
                             if (success) {
                             Toast.makeText(getApplicationContext(), "부작용 정보가 추가되었습니다.", Toast.LENGTH_LONG).show();
                             Intent.intent = new Intent(getApplicationContext(), ManagementInfoActivity.class);
                             startActivity(intent);    //정보 관리 화면으로 돌아감
                             }
                             else {
                             Toast.makeText(getApplicationContext(), "부작용 정보 추가에 실패하였습니다.", Toast.LENGTH_LONG).show();
                             }
                             DB 입력 실패시에도 똑같이 정보관리화면 돌아갈거면 if문에는 toast만 넣어도 될 듯
                             */


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

                Toast.makeText(getApplicationContext(), "취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}