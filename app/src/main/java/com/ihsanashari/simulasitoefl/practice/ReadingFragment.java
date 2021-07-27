package com.ihsanashari.simulasitoefl.practice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ihsanashari.simulasitoefl.R;

public class ReadingFragment extends Fragment {

    Button btnEasyPassage, btnMediumPassage, btnDifficultPassage;

    public ReadingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reading, container, false);

        btnEasyPassage = (Button) view.findViewById(R.id.btn_easy_passages);
        btnMediumPassage = (Button) view.findViewById(R.id.btn_medium_passages);
        btnDifficultPassage = (Button) view.findViewById(R.id.btn_difficult_passages);

        btnEasyPassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ReadingSectionActivity.class);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        btnMediumPassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ReadingSectionActivity.class);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        btnDifficultPassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ReadingSectionActivity.class);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        return view;
    }
}