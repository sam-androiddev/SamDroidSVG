package com.samdroiddev.svgapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.samdroiddev.samandroidsvg.SamSvgLoader;

public class MainActivity extends AppCompatActivity {

    //
    //https://tech.fleka.me/how-to-load-svg-file-from-web-in-android-6cd2f4dc59b

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.samdroiddev.svgapp.R.layout.activity_main);
        final ImageView imageView = findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.img_an08004_fish1);
            }
        });
//        SvgLoader.pluck()
//                .with(this)
//                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
//                .load("http://192.169.233.160:78/SkillImages/img_AN08004_fish1.svg", imageView);

        SamSvgLoader.invoke()
                .with(this)
                .load(R.drawable.img_an08004_fish1)
                .into(imageView);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        SamSvgLoader.invoke().close();
    }
}
