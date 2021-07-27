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
import com.ihsanashari.simulasitoefl.practice.ListeningSectionActivity;

public class FullTestFragment extends Fragment {

    Button btnFullTest1, btnFullTest2;

    public FullTestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_test, container, false);

        btnFullTest1 = (Button) view.findViewById(R.id.btn_complete_1);
        btnFullTest2 = (Button) view.findViewById(R.id.btn_complete_2);

        btnFullTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListeningSectionActivity.class);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        btnFullTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListeningSectionActivity.class);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        return view;
    }
}