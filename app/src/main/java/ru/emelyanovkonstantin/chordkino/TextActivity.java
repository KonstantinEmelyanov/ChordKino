package ru.emelyanovkonstantin.chordkino;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import me.grantland.widget.AutofitTextView;

public class TextActivity extends AppCompatActivity {
    private static String SELECT_QUERY = "SELECT chord FROM song WHERE _id = ";
    private String SONG_ID;
    private String TEXT_SONG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        Intent intent = getIntent();
        SONG_ID = Integer.toString(intent.getExtras().getInt("songId"));
        AutofitTextView textView = (AutofitTextView) findViewById(R.id.textSong);
        textView.setMaxLines(rowCount(textData()));
        textView.setText(textData());

    }
    private String textData(){
        String QUERY = SELECT_QUERY + SONG_ID;
        DbHalper dbHalper = new DbHalper(this);
        SQLiteDatabase db = dbHalper.getReadableDatabase();
        Cursor cursor = db.rawQuery(QUERY,null);
        if (cursor.moveToFirst()) {
            TEXT_SONG = cursor.getString(0);
        }
        cursor.close();
        return TEXT_SONG;
    }
    private  int rowCount (String string){
        // char CR  = 0x0D;
        char CR  = 10;
        int count = 1;// всего строк = всего переносов + 1
        for (int i=0; i< string.length();i++){
            if (string.charAt(i) == CR ) {
                count++;
            }
        }
        Log.e("myApp","rowCount = "+count);
        return count;

    }
}
