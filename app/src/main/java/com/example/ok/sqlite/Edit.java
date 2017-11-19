package com.example.ok.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    @BindView(R.id.btn_update)
    Button upDate;



    @BindView(R.id.imgckeck)
    Button check;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        data = new DB(this);
        ButterKnife.bind(this);

        Intent i= getIntent();
         String tit =i.getStringExtra("title").trim();
       String det= i.getStringExtra("detail").trim();
       // String id=i.getStringExtra("id").trim();
        title.setText(tit);
        details.setText(det);



        upDate.setOnClickListener(new View.OnClickListener() {
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


    }
public void delet(){
     String  Id = title.getText().toString();

    Integer result = data.delete(Id);
                if (result > 0) {
        Toast.makeText(Edit.this, "Delete", Toast.LENGTH_SHORT).show();

    } else {
        Toast.makeText(Edit.this, "error ", Toast.LENGTH_SHORT).show();
    }}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edite, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.delete:
                 delet();
                return true;
            case R.id.share:
                // showHelp();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
