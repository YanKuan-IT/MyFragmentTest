package com.example.mytest5;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment1 extends Fragment {
    private static final String TAG = "AAAAA";

    // 方法1
    private String text;
    private String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // 方法1
        Log.d(TAG, "Activity 传值给 Fragment, method1 - " + getText());

        // 方法2
        if (getArguments() != null) {
            Log.d(TAG, "Activity 传值给 Fragment, method2 - " + getArguments().getString("hiBoy"));
        }

        View view = inflater.inflate(R.layout.fragment_layout_1, container, false);
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
