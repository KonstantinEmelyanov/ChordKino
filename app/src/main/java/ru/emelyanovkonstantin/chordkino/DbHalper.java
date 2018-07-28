package ru.emelyanovkonstantin.chordkino;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by EmelyanovKonstantin on 25.07.2018.
 */
public class DbHalper extends SQLiteAssetHelper {
    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "AllChord.db";
    static final String TABLE_ALBUM = "album";
    private static final String KEY_ID = "_id";
    private static final String KEY_YEAR = "year";
    private static final String KEY_NAME = "name";
    private static final String TABLE_SONG = "song";

    public DbHalper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void setForcedUpgrade() {
        super.setForcedUpgrade();
    }
}
