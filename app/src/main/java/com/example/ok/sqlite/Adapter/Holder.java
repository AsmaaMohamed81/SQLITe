package com.example.ok.sqlite.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ok.sqlite.R;

/**
 * Created by ok on 12/11/2017.
 */

public class Holder extends RecyclerView.ViewHolder {

    //    @BindView(R.id.txt_tit)TextView texttitle;
//    @BindView(R.id.txt_detail)TextView textdetale;
    TextView textdetale;
    TextView texttitle;

    public Holder(View itemView) {
        super(itemView);
        texttitle= (TextView) itemView.findViewById(R.id.txt_tit);
        textdetale= (TextView) itemView.findViewById(R.id.txt_detail);

//        ButterKnife.bind(Context);

    }
}
