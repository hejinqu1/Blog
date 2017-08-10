package com.banggood.client.module.common.decoration;

import android.graphics.Rect;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.LayoutDirection;

import java.util.Locale;

/**
 * Created by Jun on 2017/6/22.
 * 辅助网格布局画分割线类，阿拉伯语时需左右调换
 */

public class GravityCompatHelper {

    private static GravityCompatHelper mHelper;
    private static int layoutDirection;

    public static GravityCompatHelper getInstance() {
        if (mHelper == null) {
            mHelper = new GravityCompatHelper();
        }

        layoutDirection = TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault());

        return mHelper;
    }

    private GravityCompatHelper() {

    }

    public void apply(RecyclerView.LayoutManager layoutManager, Rect outRect) {
        if (layoutManager instanceof GridLayoutManager &&
                layoutDirection == LayoutDirection.RTL) {
            int oldLeft = outRect.left;
            outRect.left = outRect.right;
            outRect.right = oldLeft;
        }
    }
}
