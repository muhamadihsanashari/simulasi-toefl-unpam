package com.ihsanashari.simulasitoefl.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ihsanashari.simulasitoefl.R;
import com.ihsanashari.simulasitoefl.practice.PracticeListeningSectionActivity;
import com.ihsanashari.simulasitoefl.practice.PracticeReadingSectionActivity;
import com.ihsanashari.simulasitoefl.practice.PracticeStructureSectionActivity;


public class IndividualTestFragment extends Fragment {

    Button btnListeningTest, btnReadingTest, btnStructureTest;

    public IndividualTestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_individual_test, container, false);

        btnListeningTest = (Button) view.findViewById(R.id.btn_listening_test);
        btnReadingTest = (Button) view.findViewById(R.id.btn_reading_test);
        btnStructureTest = (Button) view.findViewById(R.id.btn_structure_test);

        btnListeningTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PracticeListeningSectionActivity.class);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        btnReadingTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PracticeReadingSectionActivity.class);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        btnStructureTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TestingStructureSectionActivity.class);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        return view;
    }
}