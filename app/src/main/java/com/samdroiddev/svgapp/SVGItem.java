package com.samdroiddev.svgapp;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sbhanot on 6/20/2018.
 */

public class SVGItem extends AbstractItem<SVGItem, SVGItem.ViewHolder> implements Serializable {

    public String title;
    public String uri;

    public SVGItem(){}

    public SVGItem(String title,String image){
        this.title = title;
        this.uri = image;
    }

    @NonNull
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.svg_item_id;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row;
    }

    public static class ViewHolder extends FastAdapter.ViewHolder<SVGItem> {
        TextView title;
        ImageView img;
        View ctx;

        public ViewHolder(View itemView) {
            super(itemView);
            ctx=itemView;
            title = (TextView)itemView.findViewById(R.id.textView);
            img = (ImageView) itemView.findViewById(R.id.imageView);
        }

        @Override
        public void bindView(SVGItem item, List<Object> payloads) {
            title.setText(item.title);
            Glide.with(ctx.getContext()).load(item.uri).into(img);
            //SamSvgLoader.invoke().with(ctx).load(item.uri).into(img);
        }

        @Override
        public void unbindView(SVGItem item) {

        }
    }

}
