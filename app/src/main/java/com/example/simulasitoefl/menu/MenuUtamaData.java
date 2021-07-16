package com.example.simulasitoefl.menu;

import com.example.simulasitoefl.R;

import java.util.ArrayList;

public class MenuUtamaData {

    private static String[] menuName = {
            "Practice",
            "Testing",
            "Scores",
            "Pre Test",
            "Post Test",
            "Download Materi",
            "Tentang"
    };

    private static String[] menuDescription = {
            "Berisi soal latihan berdasarkan kategori soal; Listening, Reading, dan Structure",
            "Uji kemampuan bahasa Inggris kamu dengan mengerjakan latihan TOEFL",
            "Lihat pencapaian hasil belajar kamu selama ini. Semangat terus!",
            "Ketahui sejauh mana kemampuan kamu dalam mengerjakan soal TOEFL",
            "Ketahui sejauh mana kemampuan kamu dalam mengerjakan soal TOEFL",
            "Download dan pelajari materi untuk memperdalam pengetahuan kamu tentang ujian TOEFL",
            "Cari tahu lebih banyak sama pembuat aplikasi yuk"
    };

    private static int[] menuIcon = {
            R.drawable.ic_practice,
            R.drawable.ic_testing,
            R.drawable.ic_score,
            R.drawable.ic_pretest,
            R.drawable.ic_posttest,
            R.drawable.ic_download,
            R.drawable.ic_tentang
    };

    public  static ArrayList<MenuUtama> getListData() {
        ArrayList<MenuUtama> list = new ArrayList<>();
        for (int position = 0; position < menuName.length; position++) {
            MenuUtama menuUtama = new MenuUtama();
            menuUtama.setMenu(menuName[position]);
            menuUtama.setDescription(menuDescription[position]);
            menuUtama.setIcon(menuIcon[position]);
            list.add(menuUtama);
        }
        return list;
    }
}
