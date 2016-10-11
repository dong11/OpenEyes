package com.rex.hwong.openeyes.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/10/11
 * @time 上午9:06
 */

public class ImageLoader {
    private ImageLoader() {
    }

    public static void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }
}
