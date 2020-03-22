package com.ifdroids.navigationdrawersavedstatelib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class TestLayout extends LinearLayout {

    public TestLayout(Activity act){
        super(act,null);

        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(getContext()).inflate(R.layout.demo_layout,null);

        // dynamically draw it
        LinearLayout container = view.findViewById(R.id.command_container);

        LinearLayout.LayoutParams params = (LayoutParams) container.getLayoutParams();
        params=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        params.setMargins(0,0,0,20);
        container.setLayoutParams(params);

        this.addView(view);
    }


    // default constructor
    public TestLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}