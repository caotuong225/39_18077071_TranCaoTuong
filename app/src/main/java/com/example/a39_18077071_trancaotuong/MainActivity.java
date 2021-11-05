package com.example.a39_18077071_trancaotuong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    RecyclerView rcv, rcv_2;
    CustomAdapter adt, adt_2;
    List<Song> mSongs, mSongs_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv = findViewById(R.id.rcv);
        mSongs = new ArrayList<>();
        adt  =new CustomAdapter(mSongs,this);

        mSongs.add(new Song("Out of My Mine","Dance",R.drawable.anha,R.raw.gia_nhu_ngay_dau));
        mSongs.add(new Song("Freak in Me","electronic",R.drawable.anhb,R.raw.nhac_a));
        mSongs.add(new Song("Out of My Mine","Remix",R.drawable.anhc,R.raw.nhac_b));
        mSongs.add(new Song("Freak in Met","Dance",R.drawable.anhd,R.raw.nhac_d));
        mSongs.add(new Song("Love yourself","Hoang",R.drawable.anhf,R.raw.gia_nhu_ngay_dau));
        mSongs.add(new Song("Out of My Mine","HaHa",R.drawable.anhg,R.raw.nhac_b));

        rcv.setHasFixedSize(true);
        rcv.setAdapter(adt);
        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));


        rcv_2 = findViewById(R.id.rcv_2);
        mSongs_2 = new ArrayList<>();
        adt_2  =new CustomAdapter(mSongs_2,this);


        mSongs_2.add(new Song("Freak in Met","Dance",R.drawable.anhe,R.raw.nhac_d));
        mSongs_2.add(new Song("Love yourself","Tuong",R.drawable.anhc,R.raw.gia_nhu_ngay_dau));
        mSongs_2.add(new Song("Out of My Mine","HaHa",R.drawable.anhf,R.raw.nhac_b));
        mSongs_2.add(new Song("Out of My Mine","Dance",R.drawable.anhg,R.raw.gia_nhu_ngay_dau));
        mSongs_2.add(new Song("Freak in Me","electronic",R.drawable.anhb,R.raw.nhac_a));
        mSongs_2.add(new Song("Out of My Mine","Remix",R.drawable.anhc,R.raw.nhac_b));

        rcv_2.setHasFixedSize(true);
        rcv_2.setAdapter(adt_2);
        rcv_2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));


    }

    @Override
    public void itemClick(Song song, ImageView img) {
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        Intent intent = new Intent(MainActivity.this, SongActivity.class);
        intent.putExtra("song",song);
        intent.putExtra("listSong", (Serializable) mSongs);
        intent.putExtra("index",mSongs.indexOf(song));

        ActivityOptionsCompat options =  ActivityOptionsCompat.makeSceneTransitionAnimation(
                MainActivity.this, img,
                ViewCompat.getTransitionName(img));

        startActivity(intent,options.toBundle());

    }
}