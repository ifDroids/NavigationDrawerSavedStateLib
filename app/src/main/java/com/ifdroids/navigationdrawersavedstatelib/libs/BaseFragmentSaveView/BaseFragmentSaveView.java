package com.ifdroids.navigationdrawersavedstatelib.libs.BaseFragmentSaveView;

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

    private OnFragmentViewLoadNow loader;
    private int currentLayoutID;
    private OnFragmentViewSaveNow viewParser;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewParser = (OnFragmentViewSaveNow) context;
        loader = (OnFragmentViewLoadNow) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = loader.onFragmentViewLoadNow();

        return v == null ? inflater.inflate(currentLayoutID, container, false) : v ;
    }

    protected void setLayoutID(@LayoutRes int id){
        currentLayoutID = id;
    }

    protected void saveCurrentViewState(View v){
        viewParser.onFragmentViewSaveNow(v);
    }

}
