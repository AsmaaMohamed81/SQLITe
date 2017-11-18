package com.example.ok.sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ok.sqlite.Adapter.Adapter;
import com.example.ok.sqlite.Model.Note;

import java.util.ArrayList;
import java.util.List;

public class Recycle extends AppCompatActivity {

    List<Note> datamodel;


    DB database;
    RecyclerView recyclerView;
    Adapter recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        datamodel =new ArrayList<Note>();

        recyclerView = (RecyclerView) findViewById(R.id.recy);

        database =new DB(Recycle.this);


        datamodel=database.getDat();

        recycler =new Adapter(datamodel,this);


        Log.i("HIteshdata",""+datamodel);
        RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(reLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recycler);





    }
}
