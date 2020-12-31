package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class XOActivity extends AppCompatActivity {
    static int dummy = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xo);
    }

    public void disable(View view) {
        // disable the clicked button and label it X when dummy is odd, O when dummy is even
        view.setEnabled(false);
        ++dummy;
        if (dummy%2==1) ((Button)view).setText("X");
        else ((Button)view).setText("O");
    }
}