package prorassameepbru.sukanya.bookmeetingpbru;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by android on 24/5/2559.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    public static final String database_name="Pbru.db";
    private static final int database_version=1;
    private static final String create_user_table="create table userTABLE(" +
            "_id integer primary key," +
            "Name text," +
            "Surname," +
            "IDcard," +
            "Office," +
            "User," +
            "Password text);";

    public MyOpenHelper(Context context) {
        super(context,database_name,null,database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_user_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}  //Main Class
