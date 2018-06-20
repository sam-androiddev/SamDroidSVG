package com.samdroiddev.samandroidsvg;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by sbhanot on 6/19/2018.
 */

public class SamSvgLoader {

    private static  SamSvgLoader instance;
    private GlideSvgRequest glideRequest;

    public static SamSvgLoader invoke(){
        if (instance ==null)
            instance = new SamSvgLoader();
        return instance;
    }

    public SamSvgLoader with(Context context){
        glideRequest = new GlideSvgRequest(context);
        return instance;
    }

    public SamSvgLoader with(Activity activity){
        glideRequest = new GlideSvgRequest(activity);
        return instance;
    }

    public SamSvgLoader with(FragmentActivity activity){
        glideRequest = new GlideSvgRequest(activity);
        return instance;
    }

    public SamSvgLoader with(Fragment fragment){
        glideRequest = new GlideSvgRequest(fragment);
        return instance;
    }

    public SamSvgLoader with(View view){
        glideRequest = new GlideSvgRequest(view);
        return instance;
    }

    public void close(){
        glideRequest.clearCache();
    }

    public SamSvgLoader load(Uri uri){
        glideRequest.load(uri);
        return instance;
    }

    public SamSvgLoader load(String url){
        Uri uri = Uri.parse(url);
        glideRequest.load(uri);
        return instance;
    }

    public SamSvgLoader into(ImageView imageView){
        glideRequest.into(imageView);
        return instance;
    }

}
