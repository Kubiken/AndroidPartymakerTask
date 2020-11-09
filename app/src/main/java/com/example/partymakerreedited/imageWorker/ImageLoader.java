package com.example.partymakerreedited.imageWorker;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class ImageLoader
{
    static public void loadImg(ImageView iv, String uri, Context c) {
        Glide.with(c)
                .load(uri)
                .centerCrop()
                .into(iv);
    }

    static public void loadRoundedImg(ImageView iv, String uri, Context c) {
        Glide.with(c)
                .load(uri)
                .centerCrop()
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(90)))
                .into(iv);
    }
}
