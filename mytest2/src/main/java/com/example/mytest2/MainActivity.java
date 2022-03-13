package com.example.mytest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyFragment1 fragment1;
    private MyFragment2 fragment2;
    private MyFragment3 fragment3;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Button add_fragment_bt = findViewById(R.id.add_fragment_bt);
        Button replace_fragment2_bt = findViewById(R.id.replace_fragment2_bt);
        Button remove_fragment1_bt = findViewById(R.id.remove_fragment1_bt);

        add_fragment_bt.setOnClickListener(this);
        replace_fragment2_bt.setOnClickListener(this);
        remove_fragment1_bt.setOnClickListener(this);

        fragment1 = new MyFragment1();
        fragment2 = new MyFragment2();
        fragment3 = new MyFragment3();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_fragment_bt:
                if (!fragment1.isAdded()) {
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container1, fragment1).commit();
                }
                if (!fragment2.isAdded()) {
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, fragment2).commit();
                }
                break;
            case R.id.replace_fragment2_bt:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container2, fragment3).commit();
                break;
            case R.id.remove_fragment1_bt:
                getSupportFragmentManager().beginTransaction().remove(fragment1).commit();
                break;
            default:
                break;
        }
    }
}