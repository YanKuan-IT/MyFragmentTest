package com.example.mytest6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "BBBBBBB";
    private MyFragment1 fragment1;

    // Fragment 传值给 Activity, 方法1
    private String desc;
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Button add_fragment_bt = findViewById(R.id.add_fragment_bt);
        add_fragment_bt.setOnClickListener(this);
        
        Button test_get_value_bt = findViewById(R.id.test_get_value_bt);
        test_get_value_bt.setOnClickListener(this);

        fragment1 = new MyFragment1();

        fragment1.setMyFragmentInterface(new MyFragment1.MyFragmentInterface() {
            @Override
            public void setText(String text) {
                Log.d(TAG, "getText: " + text);
            }
        });
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
            case R.id.test_get_value_bt:
                // 方法1
                Log.d(TAG, "getDesc: " + getDesc());
                break;
            default:
                break;
        }
    }
}