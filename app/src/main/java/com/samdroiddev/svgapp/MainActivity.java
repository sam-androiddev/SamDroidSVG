package com.samdroiddev.svgapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.samdroiddev.samandroidsvg.SamSvgLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //
    //https://tech.fleka.me/how-to-load-svg-file-from-web-in-android-6cd2f4dc59b
    ItemAdapter mAdapter;
    FastAdapter mFastAdapter;
    List<SVGItem> svgItems=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.samdroiddev.svgapp.R.layout.activity_main);
        final ImageView imageView = findViewById(R.id.imageView);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        SamSvgLoader.invoke()
                .with(this)
                .load("https://upload.wikimedia.org/wikipedia/commons/0/02/SVG_logo.svg")
                .into(imageView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ItemAdapter();
        mFastAdapter = FastAdapter.with(mAdapter);
        recyclerView.setAdapter(mFastAdapter);

//        svgItems.add(new SVGItem("Android", "https://dev.w3.org/SVG/tools/svgweb/samples/svg-files/android.svg"));
//        svgItems.add(new SVGItem("SVG Logo", "https://upload.wikimedia.org/wikipedia/commons/0/02/SVG_logo.svg"));
//        svgItems.add(new SVGItem("Car", "https://dev.w3.org/SVG/tools/svgweb/samples/svg-files/car.svg"));
//        svgItems.add(new SVGItem("Wikimedia", "https://dev.w3.org/SVG/tools/svgweb/samples/svg-files/wikimedia.svg"));
//        svgItems.add(new SVGItem("Opera", "https://dev.w3.org/SVG/tools/svgweb/samples/svg-files/opera.svg"));
//        svgItems.add(new SVGItem("Duke", "https://dev.w3.org/SVG/tools/svgweb/samples/svg-files/duke.svg"));
//        svgItems.add(new SVGItem("Json", "https://dev.w3.org/SVG/tools/svgweb/samples/svg-files/json.svg"));
//        svgItems.add(new SVGItem("Mac", "https://dev.w3.org/SVG/tools/svgweb/samples/svg-files/mac.svg"));

        svgItems.add(new SVGItem("Android", "https://cdn.pixabay.com/photo/2015/07/09/20/03/it-838384_640.jpg"));
        svgItems.add(new SVGItem("SVG Logo", "https://cdn.pixabay.com/photo/2017/10/24/07/12/hacker-2883632_640.jpg"));
        svgItems.add(new SVGItem("Car", "https://cdn.pixabay.com/photo/2018/05/25/09/33/laptop-3428644_640.jpg"));
        svgItems.add(new SVGItem("Wikimedia", "https://cdn.pixabay.com/photo/2017/07/25/11/24/cloud-2537777_640.jpg"));
        svgItems.add(new SVGItem("Opera", "https://cdn.pixabay.com/photo/2012/03/01/01/06/micro-chip-19980_640.jpg"));
        svgItems.add(new SVGItem("Duke", "https://cdn.pixabay.com/photo/2015/10/25/16/41/chip-1006008_640.jpg"));
        svgItems.add(new SVGItem("Json", "https://cdn.pixabay.com/photo/2015/07/09/22/44/hard-disk-drive-838665_640.jpg"));



        mAdapter.add(svgItems);
        mFastAdapter.notifyDataSetChanged();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        SamSvgLoader.invoke().close();
    }
}
