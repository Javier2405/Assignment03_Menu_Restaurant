package com.example.assignment03_menu_restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper db = new DBHelper(getApplicationContext());

        ImageButton button1 = findViewById(R.id.imageButton1);
        ImageButton button2 = findViewById(R.id.imageButton2);
        ImageButton button3 = findViewById(R.id.imageButton3);
        ImageButton button4 = findViewById(R.id.imageButton4);
        ImageButton button5 = findViewById(R.id.imageButton5);
        ImageButton button6 = findViewById(R.id.imageButton6);

        db.setData();

        button1.setOnClickListener((v)->{
            Intent changeActivity = new Intent(this, Description_activity.class);
            changeActivity.putExtra("dish", 1);
            startActivity(changeActivity);
        });

        button2.setOnClickListener((v)->{
            Intent changeActivity = new Intent(this, Description_activity.class);
            changeActivity.putExtra("dish", 2);
            startActivity(changeActivity);
        });

        button3.setOnClickListener((v)->{
            Intent changeActivity = new Intent(this, Description_activity.class);
            changeActivity.putExtra("dish", 3);
            startActivity(changeActivity);
        });

        button4.setOnClickListener((v)->{
            Intent changeActivity = new Intent(this, Description_activity.class);
            changeActivity.putExtra("dish", 4);
            startActivity(changeActivity);
        });

        button5.setOnClickListener((v)->{
            Intent changeActivity = new Intent(this, Description_activity.class);
            changeActivity.putExtra("dish", 5);
            startActivity(changeActivity);
        });

        button6.setOnClickListener((v)->{
            Intent changeActivity = new Intent(this, Description_activity.class);
            changeActivity.putExtra("dish", 6);
            startActivity(changeActivity);
        });


    }
}


