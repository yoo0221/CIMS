package com.example.cims.HCI_layer.InformationManagement_UI;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.cims.DM_layer.AddVisitedRecordRequest;
import com.example.cims.PD_layer.ConfirmedCase.Place;
import com.example.cims.PD_layer.ConfirmedCase.VisitedRecord.VisitRecord;
import com.example.cims.R;

import org.json.JSONException;
import org.json.JSONObject;

public class AddVisitedRecordActivity extends AppCompatActivity {

    private EditText placeNameInput, visitedDateInput, addressInput, latitudeInput, longitudeInput;
    private Button cancel_btn, add_btn;
    private AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_visited_record);

        placeNameInput = (EditText) findViewById(R.id.placeNameInput);
        visitedDateInput = (EditText) findViewById(R.id.visitedDateInput);
        addressInput = (EditText) findViewById(R.id.addressInput);
        latitudeInput = (EditText) findViewById(R.id.latitudeInput);
        longitudeInput = (EditText) findViewById(R.id.occurProbabilityInput);

        //입력 버튼 클릭 시 수행
        add_btn = findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //입력 값 저장
                /*final*/ String placeName = placeNameInput.getText().toString();
                /*final*/ String visitedDate = visitedDateInput.getText().toString();
                /*final*/ String address = addressInput.getText().toString();
                /*final*/ double lat = Float.parseFloat(latitudeInput.getText().toString());
                /*final*/ double lng = Float.parseFloat(longitudeInput.getText().toString());

                //입력되지 않은 칸이 있을 경우
                if (placeName.equals("") || visitedDate.equals("") || address.equals("") || Double.toString(lat).equals("") || Double.toString(lng).equals("")){
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
                        public void onClick(DialogInterface dialog, int id){    //확인 선택 시 VisitRecord 객체 생성 및 DB에 저장
                            //Place 객체 생성 및 visitedRecord 추가
                            Place place = new Place(lat, lng);
                            VisitRecord visited = new VisitRecord(visitedDate, placeName, address);
                            place.appenRecord(visited);

                            Toast.makeText(getApplicationContext(), "방문 정보 전송 시작", Toast.LENGTH_SHORT).show();
                            //Response listener 활성화
                            Response.Listener<String> responseListener = new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonObject = new JSONObject(response);
                                        boolean success = jsonObject.getBoolean("success");
                                        if (success) {
                                            Toast.makeText(getApplicationContext(), "방문 정보가 추가되었습니다.", Toast.LENGTH_LONG).show();
                                            Intent intent = new Intent(getApplicationContext(), ManageInfoActivity.class);
                                            startActivity(intent);    //정보 관리 화면으로 돌아감
                                        }
                                        else {
                                            Toast.makeText(getApplicationContext(), "방문 정보 추가에 실패하였습니다.", Toast.LENGTH_LONG).show();
                                            return;
                                        }
                                    } catch (JSONException e) {
                                        Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                                        e.printStackTrace();
                                    }
                                }
                            };

                            //Toast.makeText(getApplicationContext(), "request 요청", Toast.LENGTH_LONG).show();
                            AddVisitedRecordRequest addVisitedRecordRequest = new AddVisitedRecordRequest(place, responseListener);
                            RequestQueue queue = Volley.newRequestQueue(AddVisitedRecordActivity.this);
                            queue.add(addVisitedRecordRequest);
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