package com.ifdroids.navigationdrawersavedstatelib.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.ifdroids.navigationdrawersavedstatelib.R;
import com.ifdroids.navigationdrawersavedstatelib.libs.BaseFragmentSaveView.wrappers.BaseFragmentSaveView;
import com.ifdroids.navigationdrawersavedstatelib.TestLayout;

// connect our library by extending our custom fragment wrapper
public class HomeFragment extends BaseFragmentSaveView {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Since the fragment extends BaseFragmentSaveView, the onCreateView() will send
        // the layout ID to our library.
        setLayoutID(R.layout.fragment_home);

        // Firstly calls the BaseFragmentSaveView onCreateView
        final View root = super.onCreateView(inflater,container,savedInstanceState);

        // we can now do whatever our fragment needs to do
        final LinearLayout containerLayout = root.findViewById(R.id.container);
        final TextView textbox = root.findViewById(R.id.text_home);
        Button b = root.findViewById(R.id.button_home);

        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                // append some test layouts
                TestLayout command = new TestLayout(getActivity());
                TextView tv = command.findViewById(R.id.test_title);
                tv.setText( tv.getText().toString()  + textbox.getText().toString());

                containerLayout.removeView(command);
                containerLayout.addView(command);

                //save the state of the layout
                saveCurrentViewState(root);

            }
        });
        return root;
    }


}
