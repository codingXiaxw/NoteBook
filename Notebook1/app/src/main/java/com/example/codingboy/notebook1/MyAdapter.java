package com.example.codingboy.notebook1;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by codingBoy on 16/4/3.
 */
public class MyAdapter extends BaseAdapter
{
    Context context;
    Cursor cursor;
    private LinearLayout layout;

    public MyAdapter(Context context,Cursor cursor)
    {
        this.context=context;
        this.cursor=cursor;
    }

    @Override
    public int getCount()
    {
        return cursor.getCount();
    }
    @Override
    public Object getItem(int position)
    {
        return cursor.getPosition();
    }
    @Override
    public long getItemId(int position)
    {
        return position;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent)
    {
        LayoutInflater inflater=LayoutInflater.from(context);
        layout=(LinearLayout)inflater.inflate(R.layout.cell,null);
        TextView contenttv=(TextView)layout.findViewById(R.id.list_content);
        TextView timetv=(TextView)layout.findViewById(R.id.list_time);

        cursor.moveToPosition(position);
        String content=cursor.getString(cursor.getColumnIndex("content"));
        String time=cursor.getString(cursor.getColumnIndex("times"));
        contenttv.setText(content);
        timetv.setText(time);
        return layout;

    }
}
