package com.samdroiddev.samandroidsvg;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Created by sbhanot on 6/19/2018.
 */

public class GlideSvgRequest {

    private RequestBuilder<PictureDrawable> requestBuilder;
    private RequestOptions reqOptions = new RequestOptions();
    Context mContext;

    public GlideSvgRequest(@NonNull Context context){
        mContext = context;
        requestBuilder = Glide.with(context)
                .as(PictureDrawable.class)

                .transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter());
    }

    public GlideSvgRequest(@NonNull Activity activity){
        mContext = activity;
        requestBuilder = Glide.with(activity)
                .as(PictureDrawable.class)
                .transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter());
    }

    public GlideSvgRequest(@NonNull FragmentActivity activity){
        mContext = activity;
        requestBuilder = Glide.with(activity)
                .as(PictureDrawable.class)
                .transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter());
    }

    public GlideSvgRequest(@NonNull Fragment fragment){
        mContext = fragment.getActivity();
        requestBuilder = Glide.with(fragment)
                .as(PictureDrawable.class)
                .transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter());
    }

    public GlideSvgRequest(@NonNull View view){
        mContext = view.getContext();
        requestBuilder = Glide.with(view)
                .as(PictureDrawable.class)
                .transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter());
    }

    public void load(@Nullable Bitmap bitmap) {
        requestBuilder
                .load(bitmap);
    }

    public void load(@Nullable Drawable drawable) {
        requestBuilder
                .load(drawable);
    }

    public void load(@Nullable String string) {
        requestBuilder
                .load(string);
    }

    public void load(@Nullable Uri uri) {
        requestBuilder
                .load(uri);
    }

    public void into (ImageView imageView){
        requestBuilder.into(imageView);
    }


    public void clearCache() {
        Glide.get(mContext).clearMemory();
        File cacheDir = Glide.getPhotoCacheDir(mContext);
        if (cacheDir.isDirectory()) {
            for (File child : cacheDir.listFiles()) {
                if (!child.delete()) {
                    Log.w("SamSvg", "cannot delete: " + child);
                }
            }
        }
    }

}
