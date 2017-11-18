package com.example.ok.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ok.sqlite.Adapter.Adapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Edit extends AppCompatActivity {
    DB data;
    @BindView(R.id.EDTitle)
    EditText title;
    @BindView(R.id.EDdetail)
    EditText details;
    @BindView(R.id.Txtdata)
    TextView datetext;
    @BindView(R.id.btn_save)
    Button save;

    @BindView(R.id.imgdelete)
    Button delete;

    @BindView(R.id.imgckeck)
    Button check;

    public String  Id = title.getText().toString();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        data = new DB(this);
        ButterKnife.bind(this);

        Intent i= getIntent();
         String tit =i.getStringExtra("title").trim();
       String det= i.getStringExtra("detail").trim();
        title.setText(tit);
        details.setText(det);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titjj = title.getText().toString().trim();
                String detjj = details.getText().toString().trim();

                boolean result = data.update(Adapter.position+1+"",titjj, detjj);
                if (result == true) {
                    Toast.makeText(Edit.this, "Update success", Toast.LENGTH_SHORT).show();
                    title.setText(" ");
                    details.setText(" ");
                 //   data.getDat();

                } else {
                    Toast.makeText(Edit.this, "Error", Toast.LENGTH_SHORT).show();

                }            }
        });


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Edit.this,Recycle.class);
                startActivity(i);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
delet();

            }
        });

    }
public void delet(){
    Integer result = data.delete(Id);
                if (result > 0) {
        Toast.makeText(Edit.this, "Delete", Toast.LENGTH_SHORT).show();

    } else {
        Toast.makeText(Edit.this, "error ", Toast.LENGTH_SHORT).show();
    }}

}
