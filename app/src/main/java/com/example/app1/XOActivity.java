package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class XOActivity extends AppCompatActivity {
    static int dummy = 0;
    static int[][] btn = new int[3][3];
    Intent i_xo = new Intent(this, winActivity.class);

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

//        Toast.makeText(this,"id="+view.getResources().getResourceEntryName(view.getId()),Toast.LENGTH_SHORT).show();
        String a = view.getResources().getResourceEntryName(view.getId()); // b01 row=0 column=1
        char aa = a.charAt(1); // "0"
        char bb = a.charAt(2); // "1"
        btn[Character.getNumericValue(aa)][Character.getNumericValue(bb)] = ((Button) view).getText(); // btn[0][1]="X"

        // start checking condition to win
        if(dummy>=5) // minimal turn to win is 5 (XXXOO)
        {
            if(btn[aa][0]==btn[aa][1]==btn[aa][2])  startActivity(i_xo);
        }
    }
}