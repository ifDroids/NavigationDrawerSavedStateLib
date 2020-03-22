package com.ifdroids.navigationdrawersavedstatelib.libs.BaseFragmentSaveView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ifdroids.navigationdrawersavedstatelib.libs.BaseFragmentSaveView.interfaces.OnFragmentViewLoadNow;
import com.ifdroids.navigationdrawersavedstatelib.libs.BaseFragmentSaveView.interfaces.OnFragmentViewSaveNow;

public class BaseFragmentSaveView extends Fragment {

    protected OnFragmentViewSaveNow dataPasser;
    protected Activity baseActivity;

    private OnFragmentViewLoadNow loader;
    private View savedView;
    private int currentLayoutID;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        dataPasser = (OnFragmentViewSaveNow) context;
        loader = (OnFragmentViewLoadNow) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        baseActivity = getActivity();

        View v = loader.onFragmentViewLoadNow();

        return v == null ? inflater.inflate(currentLayoutID, container, false) : v ;
    }

    protected void setLayoutID(@LayoutRes int id){
        currentLayoutID = id;
    }

    protected void saveCurrentViewState(View v){
        dataPasser.onFragmentViewSaveNow(v);
    }

}
