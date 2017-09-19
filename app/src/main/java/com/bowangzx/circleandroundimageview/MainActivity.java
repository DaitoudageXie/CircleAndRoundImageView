package com.bowangzx.circleandroundimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bowangzx.imageviewlibrary.CircleImageView;
import com.bowangzx.imageviewlibrary.RoundImageView;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    CircleImageView civ;
    RoundImageView riv;
    String imgUrl="https://www.zhuangbi.info/uploads/i/2016-11-24-20d0b203af9661c2b02c8c9669764122.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        civ= (CircleImageView) findViewById(R.id.civ);
        riv= (RoundImageView) findViewById(R.id.riv);

        Glide.with(this).load(imgUrl).into(civ);
        Glide.with(this).load(imgUrl).into(riv);
    }
}
