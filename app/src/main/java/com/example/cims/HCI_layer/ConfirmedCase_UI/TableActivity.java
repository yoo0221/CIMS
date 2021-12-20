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
    private Button btn_load;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_table, container, false);

        text = (TextView)view.findViewById(R.id.listview);
        btn_load = (Button)view.findViewById(R.id.btn_load);
        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("");
                Iterator<Place> itr = ((ConfirmedCaseActivity) getActivity()).getPlaceArrayList().iterator();
                while(itr.hasNext()) {
                    Place place = itr.next();
                    text.setText(text.getText() + place.getVisitRecord().getVisitedDate() + "   " + place.getVisitRecord().getPlaceName() + "   " + place.getVisitRecord().getAddress() + "\n");
                }
            }
        });

        text.setText("");

        return view;
    }
}
