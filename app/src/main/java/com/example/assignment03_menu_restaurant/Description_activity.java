package com.example.assignment03_menu_restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Description_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_activity);

        DBHelper db = new DBHelper(getApplicationContext());

        TextView dish_name = findViewById(R.id.dish_name);
        TextView dish_description = findViewById(R.id.dish_description);
        TextView dish_ingredients = findViewById(R.id.dish_ingredients);
        Button back_button = findViewById(R.id.back_button);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int dish = bundle.getInt("dish");

        Cursor data = db.getData(dish);

        data.moveToFirst();

        dish_name.setText(data.getString(data.getColumnIndex("name")));
        dish_description.setText(data.getString(data.getColumnIndex("description")));
        dish_ingredients.setText(data.getString(data.getColumnIndex("ingredients")));

        back_button.setOnClickListener((v)->{
            Intent changeActivity = new Intent(this, MainActivity.class);
            startActivity(changeActivity);
        });

    }
}
