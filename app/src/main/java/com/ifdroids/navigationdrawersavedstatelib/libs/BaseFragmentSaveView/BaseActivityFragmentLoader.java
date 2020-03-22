package com.ifdroids.navigationdrawersavedstatelib.libs.BaseFragmentSaveView;

import android.annotation.SuppressLint;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ifdroids.navigationdrawersavedstatelib.libs.BaseFragmentSaveView.interfaces.OnFragmentViewLoadNow;
import com.ifdroids.navigationdrawersavedstatelib.libs.BaseFragmentSaveView.interfaces.OnFragmentViewSaveNow;

@SuppressLint("Registered") // This activity is just a wrapper. No need to be registered to Manifest
public class BaseActivityFragmentLoader extends AppCompatActivity implements OnFragmentViewLoadNow, OnFragmentViewSaveNow {
    private View fragmentLayout;

    @Override
    public void onFragmentViewSaveNow(View data) {
        fragmentLayout = data;
    }

    @Override
    public View onFragmentViewLoadNow() {
        return fragmentLayout;
    }
}
