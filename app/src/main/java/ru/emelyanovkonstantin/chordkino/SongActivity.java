package ru.emelyanovkonstantin.chordkino;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.emelyanovkonstantin.chordkino.dto.RemindDTO;
import ru.emelyanovkonstantin.chordkino.dto.SongDTO;

public class SongActivity extends AppCompatActivity {
private static final String SELECT_QUERY = "SELECT * FROM song WHERE album = ";
private static int albumId  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        albumId = getIntent().getExtras().getInt("albumId");
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SongListAdapter(listData()));
        TextView view = findViewById(R.id.textView3);
        view.setText(Integer.toString(albumId));
    }
    private List<SongDTO> listData(){
        String QUERY = SELECT_QUERY + Integer.toString(albumId);
        DbHalper dbHalper = new DbHalper(this);
        Cursor cursor;
        List<SongDTO> list = new ArrayList<>();
        SQLiteDatabase db =dbHalper.getReadableDatabase();
        cursor = db.rawQuery(QUERY,null);
        if (cursor.moveToFirst()){
            do{
                list.add(new SongDTO(
                        cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getString(2)
                ));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;

    }

}
