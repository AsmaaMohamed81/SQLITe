package com.example.ok.sqlite.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ok.sqlite.Edit;
import com.example.ok.sqlite.R;
import com.example.ok.sqlite.Recycle;

/**
 * Created by ok on 12/11/2017.
 */

public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //    @BindView(R.id.txt_tit)TextView texttitle;
//    @BindView(R.id.txt_detail)TextView textdetale;
    TextView textdetale;
    TextView texttitle;
    LinearLayout con;
    Recycle recycle;


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

        Intent d = new Intent(recycle, Edit.class);
        recycle.startActivity(d);


    }
}
