package com.example.mytest3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyFragment1 fragment1;
    private MyFragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                            .addToBackStack(null)
                            .commit();
                }
                break;
            case R.id.replace_fragment2_bt:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container1, fragment2)
                        .addToBackStack(null)
                        .commit();
                break;
            default:
                break;
        }
    }
}