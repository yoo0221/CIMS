package com.example.cims.HCI_layer.InformationManagement_UI;

import com.example.cims.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class AddVisitedRecordActivity extends AppCompatActivity {

    private EditText placeNameInput, visitedTimeInput, addressInput, latitudeInput, longitudeInput;
    private Button cancel_btn, add_btn;
    private AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_visited_record);

        placeNameInput = (EditText) findViewById(R.id.placeNameInput);
        visitedTimeInput = (EditText) findViewById(R.id.visitedTimeInput);
        addressInput = (EditText) findViewById(R.id.addressInput);
        latitudeInput = (EditText) findViewById(R.id.latitudeInput);
        longitudeInput = (EditText) findViewById(R.id.longitudeInput);

        //입력 버튼 클릭 시 수행
        add_btn = findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                final String placeName = placeNameInput.getText().toString();
                final String visitedTime = visitedTimeInput.getText().toString();
                final String address = addressInput.getText().toString();
                final String latitude = latitudeInput.getText().toString();
                final String longitude = longitudeInput.getText().toString();

                //입력되지 않은 칸이 있을 경우
                if (placeName.equals("") || visitedTime.equals("") || address.equals("") || latitude.equals("") || longitude.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddVisitedRecordActivity.this);
                    builder.setMessage("모든 칸을 입력하세요.");
                    builder.setNegativeButton("확인", null);
                    dialog = builder.create();
                    dialog.show();
                }
                else {
                    //추가 여부 재확인
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddVisitedRecordActivity.this);
                    builder.setMessage("확진자 방문장소 정보를 추가하시겠습니까?");
                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id){    //확인 선택 시 DB에 각 String 저장
                            // DB 입력!
                            /* DB 입력 성공/실패시 동작
                             if (success) {
                             Toast.makeText(getApplicationContext(), "부작용 정보가 추가되었습니다.", Toast.LENGTH_LONG).show();
                             Intent.intent = new Intent(getApplicationContext(), ManagementInfoActivity.class);
                             startActivity(intent);    //정보 관리 화면으로 돌아감
                             }
                             else {
                             Toast.makeText(getApplicationConotext(), "부작용 정보 추가에 실패하였습니다.", Toast.LENGTH_LONG).show();
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