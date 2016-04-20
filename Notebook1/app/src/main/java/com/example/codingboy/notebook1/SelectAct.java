package com.example.codingboy.notebook1;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by codingBoy on 16/4/11.
 */
public class SelectAct extends Activity implements View.OnClickListener
{
    private Button select_delete,select_back;
    private TextView select_text;
    private NotesDB notesDB;
    private SQLiteDatabase dbWriter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);

        select_delete=(Button)findViewById(R.id.select_delete);
        select_back=(Button)findViewById(R.id.select_back);
        select_text=(TextView)findViewById(R.id.select_text);
        notesDB=new NotesDB(this);
        dbWriter=notesDB.getWritableDatabase();

        select_text.setText(getIntent().getStringExtra(NotesDB.CONTENT));

        select_delete.setOnClickListener(this);
        select_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.select_delete:
                delectDB();
                finish();
                break;
            case R.id.select_back:
                finish();
                break;
        }
    }



    public void delectDB()
    {
        dbWriter.delete(NotesDB.TABLE_NAME,"_id="+getIntent().getIntExtra(NotesDB.ID,0),null);
    }
}
