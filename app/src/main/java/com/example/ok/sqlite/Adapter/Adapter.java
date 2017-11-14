package com.example.ok.sqlite.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ok.sqlite.Model.Note;
import com.example.ok.sqlite.R;

import java.util.List;

/**
 * Created by ok on 12/11/2017.
 */


public class Adapter extends RecyclerView.Adapter<Holder>{

    private Context mcontext;
    public List<Note> data;

    public Adapter(List<Note> datamodel) {
        this.data=datamodel;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new Holder(view);

    }



    @Override
    public void onBindViewHolder(Holder holder, int position) {

            Note dataModel=data.get(position);


        holder.texttitle.setText(dataModel.getTitle());
        holder.textdetale.setText(dataModel.getDetail());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
