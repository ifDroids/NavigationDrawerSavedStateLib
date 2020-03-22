package com.ifdroids.navigationdrawersavedstatelib.libs.BaseFragmentSaveView.wrappers;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ifdroids.navigationdrawersavedstatelib.libs.BaseFragmentSaveView.interfaces.OnFragmentViewLoadListener;
import com.ifdroids.navigationdrawersavedstatelib.libs.BaseFragmentSaveView.interfaces.OnFragmentViewSaveListener;

public class BaseFragmentSaveView extends Fragment {

    private OnFragmentViewLoadListener viewLoaderListener;
    private OnFragmentViewSaveListener viewSaveListener;
    private int currentLayoutID;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewSaveListener = (OnFragmentViewSaveListener) context;
        viewLoaderListener = (OnFragmentViewLoadListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = viewLoaderListener.onFragmentViewLoadNow();

        return v == null ? inflater.inflate(currentLayoutID, container, false) : v ;
    }

    protected void setLayoutID(@LayoutRes int id){
        currentLayoutID = id;
    }

    protected void saveCurrentViewState(View v){

        //here, we can make custom edits like :
        // * Clean up a textbox or something
        viewSaveListener.onFragmentViewSaveNow(v);
    }

}
