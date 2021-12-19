package com.example.cims.HCI_layer.ConfirmedCase_UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.cims.DM_layer.LoadVisitedRecordTableRequest;
import com.example.cims.PD_layer.ConfirmedCase.Place;
import com.example.cims.PD_layer.ConfirmedCase.VisitedRecord.VisitRecord;
import com.example.cims.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class TableActivity extends Fragment {
    private TextView text;
    private ArrayList<VisitRecord> visitRecordArrayList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_table, container, false);

        text = (TextView)view.findViewById(R.id.listview);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject;
                    for(int i = 0;i < jsonArray.length();i++){
                        jsonObject = (JSONObject) jsonArray.opt(i);
                        Toast.makeText((ConfirmedCaseActivity) getActivity(), "data receive", Toast.LENGTH_SHORT).show();
                        VisitRecord visitRecord = new VisitRecord(jsonObject.getString("visitedDate"), jsonObject.getString("place"), jsonObject.getString("address"));
                        visitRecordArrayList.add(visitRecord);
                        Toast.makeText((ConfirmedCaseActivity) getActivity(), "complete", Toast.LENGTH_SHORT).show();
                        Toast.makeText((ConfirmedCaseActivity) getActivity(), Integer.toString(visitRecordArrayList.size()), Toast.LENGTH_SHORT).show();
                    }
                    Iterator<VisitRecord> itr = visitRecordArrayList.iterator();
                    while(itr.hasNext()) {
                        VisitRecord visitRecord = itr.next();
                        Toast.makeText((ConfirmedCaseActivity) getActivity(), visitRecord.getPlaceName(), Toast.LENGTH_SHORT).show();
                        text.setText(text.getText() + visitRecord.getVisitedDate() + "   " + visitRecord.getPlaceName() + "   " + visitRecord.getAddress() + "\n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        LoadVisitedRecordTableRequest loadVisitedRecordTableRequest = new LoadVisitedRecordTableRequest(responseListener);
        RequestQueue queue = Volley.newRequestQueue((ConfirmedCaseActivity) getActivity());
        queue.add(loadVisitedRecordTableRequest);

        return view;
    }
}
