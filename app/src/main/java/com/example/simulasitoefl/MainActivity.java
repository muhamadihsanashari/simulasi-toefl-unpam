package com.example.simulasitoefl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.simulasitoefl.menu.CardViewMenuUtamaAdapter;
import com.example.simulasitoefl.menu.MenuUtama;
import com.example.simulasitoefl.menu.MenuUtamaData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMenus;
    private ArrayList<MenuUtama> list = new ArrayList<>();

    private ImageView btnImageProfileView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImageProfileView = findViewById(R.id.iv_avatar);
        btnImageProfileView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MainActivity.this, ProfileActivity.class));
            }
        });

        rvMenus = findViewById(R.id.rv_menus);
        rvMenus.setHasFixedSize(true);

        list.addAll(MenuUtamaData.getListData());
        showRecyclerCardView();
    }

    private void showSelectedMenuUtama(MenuUtama menuUtama) {
        Toast.makeText(this, "Kamu memilih " + menuUtama.getMenu(), Toast.LENGTH_SHORT).show();
    }

    private void showRecyclerCardView(){
        rvMenus.setLayoutManager(new LinearLayoutManager(this));
        CardViewMenuUtamaAdapter cardViewMenuUtamaAdapter = new CardViewMenuUtamaAdapter(list);
        rvMenus.setAdapter(cardViewMenuUtamaAdapter);
    }
}