package ru.emelyanovkonstantin.chordkino;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.emelyanovkonstantin.chordkino.dto.RemindDTO;

public class MainActivity extends AppCompatActivity {
    private static final String SELECT_QUERY = "SELECT * FROM album";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.recyclerView);
        RecyclerView rv = (RecyclerView)view;
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RemindListAdapter(listData()));

    }
    private List<RemindDTO> listData() {
        Cursor mCursor;
        List<RemindDTO> list = new ArrayList<>();
        DbHalper dbHalper = new DbHalper(this);
        dbHalper.setForcedUpgrade();
        SQLiteDatabase db = dbHalper.getReadableDatabase();

        try {
            mCursor = db.rawQuery(SELECT_QUERY, null);
            if (mCursor.moveToFirst()) {
                do {
                    list.add(new RemindDTO(
                             mCursor.getString(1)//name
                    //           mCursor.getString(1) //year
                             ));

                    } while (mCursor.moveToNext());
            }
            mCursor.close();
        }catch(Exception e){
               e.printStackTrace();
               Toast.makeText(this, "База Данных не подключена", Toast.LENGTH_SHORT).show();
               Log.e("E","База Данных не подключена");
        }
        return  list;
    }
}
