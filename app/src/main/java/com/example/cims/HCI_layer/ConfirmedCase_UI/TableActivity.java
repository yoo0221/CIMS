package com.example.cims.HCI_layer.ConfirmedCase_UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cims.R;

public class TableActivity extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_table, container, false);

        TextView text = (TextView)view.findViewById(R.id.listview);
        Button createViewButton = (Button)view.findViewById(R.id.createTextView);
        createViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "hello\n");
            }
        });

        return view;
    }
}
