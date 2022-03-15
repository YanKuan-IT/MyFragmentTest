package com.example.mytest6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment1 extends Fragment {
    // 方法2 - 回调的方式
    interface MyFragmentInterface {
        void setText(String text);
    }
    MyFragmentInterface myFragmentInterface;
    void setMyFragmentInterface(MyFragmentInterface mInterface) {
        this.myFragmentInterface = mInterface;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Fragment 传值给 Activity, 方法1
        MainActivity activity = (MainActivity) getActivity();
        activity.setDesc("hello world!");

        // Fragment 传值给 Activity, 方法2
        myFragmentInterface.setText("hello Android!");

        View view = inflater.inflate(R.layout.fragment_layout_1, container, false);
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
