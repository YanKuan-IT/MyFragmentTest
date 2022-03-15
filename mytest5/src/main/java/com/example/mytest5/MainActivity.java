package com.example.mytest5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyFragment1 fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Button add_fragment_bt = findViewById(R.id.add_fragment_bt);
        add_fragment_bt.setOnClickListener(this);

        fragment1 = new MyFragment1();

        // Activity 传值给 Fragment, 方法1
        fragment1.setText("new world!");

        // Activity 传值给 Fragment, 方法2
        Bundle bundle = new Bundle();
        bundle.putString("hiBoy", "this is new world!");
        fragment1.setArguments(bundle);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_fragment_bt:
                if (!fragment1.isAdded()) {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragment_container1, fragment1)
                            .addToBackStack(null)
                            .commit();
                }
                break;
            default:
                break;
        }
    }
}