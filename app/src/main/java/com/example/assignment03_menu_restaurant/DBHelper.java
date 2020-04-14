package com.example.assignment03_menu_restaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASENAME = "menu.db";

    public static final int VERSION = 10;

    public DBHelper(Context context) {
        super(context, DATABASENAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table questions
        db.execSQL(" CREATE TABLE dish ( " +
                "dishId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "description TEXT," +
                "ingredients TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public void setData(){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("dishId", 1);
        values.put("name", "Quesadillas");
        values.put("description", "Plato tipico mexicano. Orden de 3" +
                " quesadillas servidas con ensalada y frijoles. Se puede " +
                "agregar guisado al gusto...");
        values.put("ingredients", "Tortilla, queso, guisado al gusto, lechuga y jitomate"+
                " Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."+
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        database.insert("dish", null, values);
        values.clear();

        values.put("dishId", 2);
        values.put("name", "Tamales");
        values.put("description", "Plato tipico mexicano. Servido con " +
                "salsa y frijoles. Se recomienda con atole");
        values.put("ingredients", "Masa, manteca, hoja de maiz y guisado al gusto");

        database.insert("dish", null, values);
        values.clear();

        values.put("dishId", 3);
        values.put("name", "Birria");
        values.put("description", "Plato tipico mexicano. Servido en caldo" +
                "con cebolla, cilantro y limon. Tambien incluye tortillas. Puede" +
                "ser birria de chivo o de res.");
        values.put("ingredients", "Carne de preferencia (chivo o res), cebolla, cilantro, limon," +
                " agua y condimentos");

        database.insert("dish", null, values);
        values.clear();

        values.put("dishId", 4);
        values.put("name", "Hamburguesa");
        values.put("description", "Hamburguesa tradicional. Servida con ensalada o papas. Se puede" +
                "agregar guacamole o tocino como extra. Se pueden quitar ingredientes (incluye jitomate, " +
                "cebolla, lechuga, pepinillos y queso)");
        values.put("ingredients", "Carne molida, pan, lechuga, cebolla, jitomate, pepinillos y aderezos");

        database.insert("dish", null, values);
        values.clear();

        values.put("dishId", 5);
        values.put("name", "Sandwich");
        values.put("description", "Sandwich con ingredientes a la eleccion. Servida con ensalada o papas." +
                " Se puede pedir de pollo, jamon, salchicha o res. Se pueden quitar ingredientes (incluye tocino," +
                "jitomate, cebolla, lechuga, chile jalapeño y queso)");
        values.put("ingredients", "Pan, carne a eleccion, lechuga, cebolla, jitomate, chile, queso y aderezos");

        database.insert("dish", null, values);
        values.clear();

        values.put("dishId", 6);
        values.put("name", "Tacos");
        values.put("description", "Tacos tradicionales de puesto. Orden de 3 tacos. Disponibles de res, " +
                "pastor, lengua, arrachera, rajas, frijoles, chicharron, alambres y tripa. Servidos con " +
                "cilantro y cebolla");
        values.put("ingredients", "Tortilla, guisado a eleccion, cebolla y cilantro");

        database.insert("dish", null, values);
    }

    public Cursor getData(int dish){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM dish WHERE dishId="+dish,null);

        cursor.moveToFirst();

        return cursor;
    }
}
