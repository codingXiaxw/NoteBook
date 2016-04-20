package com.example.codingboy.notebook1;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by codingBoy on 16/4/3.
 */
public class AddContent extends Activity implements View.OnClickListener{

    private NotesDB notesDB;
    private SQLiteDatabase dbWriter;
    private EditText ettext;
    private Button savebtn,backbtn;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontent);
        savebtn=(Button)findViewById(R.id.save);
        backbtn=(Button)findViewById(R.id.back);
        ettext = (EditText) findViewById(R.id.ettext);
        notesDB=new NotesDB(this);
        dbWriter=notesDB.getWritableDatabase();

        savebtn.setOnClickListener(this);
        backbtn.setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.save:
                addDB();
                finish();
                break;
            case R.id.back:
                finish();
                break;
        }
    }

    public void addDB()
    {
        ContentValues cv=new ContentValues();
        cv.put(NotesDB.CONTENT,ettext.getText().toString());
        cv.put(NotesDB.TIME,getTime());
        dbWriter.insert(NotesDB.TABLE_NAME,null,cv);
    }
    public String getTime()
    {
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        return format.format(new Date());

    }
}
