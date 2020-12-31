package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("failure", "It's not working");
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        ++mCount;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    public void disable(View view) {
        view.setEnabled(false);
        Log.d("success", "It's working well");
        Button button = (Button) view;
        button.setText(R.string.disable);
    }

    public void disable_another(View view) {
//        // first way: set variables
//        View myView = findViewById(R.id.button2);
//        myView.setEnabled(false);
//        Button but = (Button) myView;
//        but.setText(R.string.newly_disabled);

        // second way: no need variables
        findViewById(R.id.button2).setEnabled(false);
        ((Button)findViewById(R.id.button2)).setText("Newly disabled");
    }

    public void enterName(View view) {
        // When this button is hit, the name from the plaintext box will be received via getText, the show it at textView
        CharSequence a = ((TextView)findViewById(R.id.editTextTextPersonName)).getText();
        ((TextView)findViewById(R.id.textView)).setText("Your name is " +a);
        Toast.makeText(this, "Thanks!", Toast.LENGTH_SHORT).show();
    }

    public void launchXO(View view) {
        Intent = new Intent(this, XOActivity.class);
    }
}