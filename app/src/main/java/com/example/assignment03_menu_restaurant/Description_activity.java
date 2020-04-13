package com.example.assignment03_menu_restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
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
        ImageView imagen = findViewById(R.id.imageDes);
        MediaPlayer player = MediaPlayer.create(getApplicationContext(), R.raw.bcm);
        player.setLooping(true);
        player.setVolume(80,80);
        player.start();

        switch(dish){
            case 1:
                imagen.setImageResource(R.drawable.quesadillas);
                break;
            case 2:
                imagen.setImageResource(R.drawable.tamal);
                break;
            case 3:
                imagen.setImageResource(R.drawable.birria);
                break;
            case 4:
                imagen.setImageResource(R.drawable.hamburguesa);
                break;
            case 5:
                imagen.setImageResource(R.drawable.sandwich);
                break;
            case 6:
                imagen.setImageResource(R.drawable.tacos);
                break;
        }

        Cursor data = db.getData(dish);

        data.moveToFirst();

        dish_name.setText(data.getString(data.getColumnIndex("name")));
        dish_description.setText(data.getString(data.getColumnIndex("description")));
        dish_ingredients.setText(data.getString(data.getColumnIndex("ingredients")));

        back_button.setOnClickListener((v)->{
            Intent changeActivity = new Intent(this, MainActivity.class);
            player.stop();
            startActivity(changeActivity);
        });

    }
}
