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


public class StructureFragment extends Fragment {

    Button btnStructure, btnWrittenExpression;

    public StructureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_structure, container, false);

        btnStructure = (Button) view.findViewById(R.id.btn_structure);
        btnWrittenExpression = (Button) view.findViewById(R.id.btn_written_exp);

        btnStructure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), StructureSectionActivity.class);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        btnWrittenExpression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), StructureSectionActivity.class);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        return view;
    }
}