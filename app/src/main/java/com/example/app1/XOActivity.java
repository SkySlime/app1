package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static java.lang.Character.*;


public class XOActivity extends AppCompatActivity {
    int dummy = 0;
    int[][] btn = new int[3][3];
    int holdy = 0; // -1=O

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xo);
    }

    public void disable(View view) {
        // disable the clicked button and label it X when dummy is odd, O when dummy is even
        view.setEnabled(false);
        ++dummy;
        if (dummy%2==1) {
            ((Button)view).setText("X");
            holdy = 1;
        }
        else {
            ((Button)view).setText("O");
            holdy = -1;
        }

        // assign "X" or "O" to array named btn
//        Toast.makeText(this,""+((Button) view).getText().toString(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this,"id="+view.getResources().getResourceEntryName(view.getId()),Toast.LENGTH_SHORT).show();
        String a = view.getResources().getResourceEntryName(view.getId()); // b01 row=0 column=1
        int aa = getNumericValue(a.charAt(1)); // 0
        int bb = getNumericValue(a.charAt(2)); // 1
        btn[aa][bb] = holdy; // btn[0][1]=1 (1 means "X")

//        Toast.makeText(this, " "+Integer.toString(btn[aa][bb]), Toast.LENGTH_SHORT).show();
        // start checking condition to win
        if(dummy>=5) // minimal turn to win is 5 (XXXOO)
        {
            if(btn[aa][0]==btn[aa][1] && btn[aa][1]==btn[aa][2])  launch(); // row check
            else if(btn[0][bb]==btn[1][bb] && btn[1][bb]==btn[2][bb])     launch(); // column check

            // diagonal check
            if((btn[0][0]==btn[1][1] && btn[1][1]==btn[2][2]) || (btn[2][0]==btn[1][1] && btn[1][1]==btn[0][2]))   launch();
        }
    }

    public void launch() {
        Intent i_xo = new Intent(this, winActivity.class);
        startActivity(i_xo);
    }

    public void restart(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}