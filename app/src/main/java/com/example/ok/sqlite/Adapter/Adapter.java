package com.example.ok.sqlite.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ok.sqlite.Edit;
import com.example.ok.sqlite.Model.Note;
import com.example.ok.sqlite.R;
import com.example.ok.sqlite.Recycle;

import java.util.List;

/**
 * Created by ok on 12/11/2017.
 */


public class Adapter extends RecyclerView.Adapter<Adapter.Holder> implements View.OnClickListener {

    private Context mcontext;
    public List<Note> data;
    Recycle recycle;
    public  static  int position;

    public Adapter(List<Note> datamodel ,Recycle recycle) {
        this.data=datamodel;

        this.recycle=recycle;
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

        holder.con.setTag(position);



    }


     class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //    @BindView(R.id.txt_tit)TextView texttitle;
//    @BindView(R.id.txt_detail)TextView textdetale;
        TextView textdetale;
        TextView texttitle;
        LinearLayout con;


        public Holder(View itemView) {
            super(itemView);
            texttitle= (TextView) itemView.findViewById(R.id.txt_tit);
            textdetale= (TextView) itemView.findViewById(R.id.txt_detail);
            con=(LinearLayout) itemView.findViewById(R.id.con);
//        ButterKnife.bind(Context);

            con.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            position = (int) view.getTag();
            Note dataModel = data.get(position);

            Intent d = new Intent(recycle, Edit.class);
            d.putExtra("title",dataModel.title);
            d.putExtra("detail",dataModel.Detail);
            recycle.startActivity(d);


        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View view) {

    }
}
