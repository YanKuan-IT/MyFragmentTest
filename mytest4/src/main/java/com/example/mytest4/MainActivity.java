package com.example.mytest4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "BBBBBBBBBB";
    private MyFragment1 fragment1;
    private MyFragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "MainActivity onCreate: ");
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Button add_fragment_bt = findViewById(R.id.add_fragment_bt);
        Button replace_fragment2_bt = findViewById(R.id.replace_fragment2_bt);

        add_fragment_bt.setOnClickListener(this);
        replace_fragment2_bt.setOnClickListener(this);

        fragment1 = new MyFragment1();
        fragment2 = new MyFragment2();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_fragment_bt:
                if (!fragment1.isAdded()) {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragment_container1, fragment1)
                            .commit();
                }
                break;
            case R.id.replace_fragment2_bt:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container1, fragment2)
//                        .addToBackStack(null)
                        .commit();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity onDestroy: ");
    }
}