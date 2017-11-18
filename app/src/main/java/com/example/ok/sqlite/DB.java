package com.example.ok.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.ok.sqlite.Model.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ok on 12/11/2017.
 */

public class DB extends SQLiteOpenHelper {
   public String m1;
  public    String m2;
    private static final String database_name = "Names";
    private static final String tableName = "employee";
    private static final int database_version = 1;
    private static final String Uer_id = "id";
    private static final String Title="Name";
    private static final String Details="detail";
    private static final String Drop_table ="DROP TABLE IF EXISTS"+tableName;
    private static final String Creat_table ="CREATE TABLE "+tableName+
            "("+Uer_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Title+" VARCHAR(255), "+Details+" VARCHAR(255));";

    private Context context;


    public DB(Context context) {
        super(context, tableName, null, database_version);
        this.context=context;
        Toast.makeText(context, "Constractor", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(Creat_table);
            Toast.makeText(context, "create ", Toast.LENGTH_SHORT).show();


        }catch (SQLException e){

            Toast.makeText(context, "due : "+e, Toast.LENGTH_SHORT).show();
        }

    }

    public boolean insert( String title,String details){
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Title,title);
        contentValues.put(Details,details);
        long result = sq.insert(tableName,null,contentValues);
        if(result == -1){
            return false;

        }else {

            return true;
        }



    }

    public  boolean update(String title ,String detail){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Title,title);
        contentValues.put(Details,detail);
        db.update(tableName, contentValues,Title +"= ?",new String[]{title});


        return true;
    }
    public Integer delete(String title){
        SQLiteDatabase db=this.getWritableDatabase();
        return   db.delete(tableName,Title +"= ?",new String[]{title});

    }



    public List<Note> getDat(){

        List<Note> list= new ArrayList<>();
        SQLiteDatabase db=this.getWritableDatabase();


        Cursor cursor =db.rawQuery("select * from "+tableName,null);
        StringBuffer stringBuffer = new StringBuffer();


        Note dataModel = null;

        while(cursor.moveToNext()){

            dataModel= new Note();

            m1=cursor.getString(cursor.getColumnIndexOrThrow("Name"));
             m2=cursor.getString(cursor.getColumnIndexOrThrow("detail"));

            dataModel.setTitle(m1);
            dataModel.setDetail(m2);
            stringBuffer.append(dataModel);

            list.add(dataModel);
        }

        for (Note mo:list ) {

            Log.i("Hellomo",""+mo.getTitle());
        }

        return list;

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        try {
            Toast.makeText(context, "drobe ", Toast.LENGTH_SHORT).show();

            db.execSQL(Drop_table);
            onCreate(db);

        }catch (SQLException e){

            Toast.makeText(context, "due : "+e, Toast.LENGTH_SHORT).show();
        }

    }
}
