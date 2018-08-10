package ru.emelyanovkonstantin.chordkino;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import me.grantland.widget.AutofitTextView;

public class TextActivity extends AppCompatActivity {
    private static String SELECT_QUERY = "SELECT chord FROM song WHERE _id = ";
    private String SONG_ID;
    private String TEXT_SONG;
    private String TEXT_CHORD;
    private CharSequence charSequence = "<br/>";
    private char CR  = 10;
    private CharSequence charSequence10 = Character.toString(CR);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        Intent intent = getIntent();
        SONG_ID = Integer.toString(intent.getExtras().getInt("songId"));
        //AutofitTextView textView = (AutofitTextView) findViewById(R.id.textSong);
        TEXT_CHORD = textData();
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,mTextSize(TEXT_CHORD));
        textView.setMaxLines(rowCount(TEXT_CHORD));
        textView.setText((TEXT_CHORD.replace(charSequence10,System.getProperty("line.separator"))));


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
        int count = 1;// всего строк = всего переносов + 1
        for (int i=0; i< string.length();i++){
            if (string.charAt(i) == CR ) {
                count++;
            }
        }
        Log.d("myApp","rowCount = "+count);
        return count;

    }
    private float mTextSize(String mText){
        TextView mTextView = new TextView(this);
        mTextView.setText(mText);
        mTextView.setTextSize( TypedValue.COMPLEX_UNIT_PX,111);
        mTextView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        int mWidth = mTextView.getMeasuredWidth();
        float textSize = (getDisplayWidth()*111)/mWidth;
        Log.d("myApp","textSize = "+textSize);
        Log.d("myApp","mWidth = "+mWidth);
        Log.d("myApp","getDisplayWidth() = "+getDisplayWidth());
        return  textSize;

    }
    private int getDisplayWidth (){
        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        return width;
    }
}
