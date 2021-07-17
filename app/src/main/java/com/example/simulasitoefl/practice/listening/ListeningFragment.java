package com.example.simulasitoefl.practice.listening;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.simulasitoefl.R;
import com.example.simulasitoefl.practice.ListeningSectionActivity;


public class ListeningFragment extends Fragment{

    Button btnShortDialogue, btnCasualConversation, btnAcademicDiscussion, btnAcademicLectures;


    public ListeningFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listening, container, false);


        btnShortDialogue = (Button) view.findViewById(R.id.btn_shortdialogues);
        btnCasualConversation = (Button) view.findViewById(R.id.btn_casual_conv);
        btnAcademicDiscussion = (Button) view.findViewById(R.id.btn_academic_disc);
        btnAcademicLectures = (Button) view.findViewById(R.id.btn_academic_lect);

        btnShortDialogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListeningSectionActivity.class);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        btnCasualConversation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListeningSectionActivity.class);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        btnAcademicDiscussion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListeningSectionActivity.class);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        btnAcademicLectures.setOnClickListener(new View.OnClickListener() {
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