package com.example.ok.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    DB data;
    @BindView(R.id.EDTitle)
    EditText title;
    @BindView(R.id.EDdetail)
    EditText details;
    @BindView(R.id.Txtdata)
    TextView date;
    @BindView(R.id.btn_save)
    Button save;

    @BindView(R.id.imgckeck)
    Button check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new DB(this);
        ButterKnife.bind(this);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tit = title.getText().toString();
                String det = details.getText().toString();
                boolean result = data.insert(tit, det);
                if (result == true) {
                    Toast.makeText(MainActivity.this, "Insert success", Toast.LENGTH_SHORT).show();
                    title.setText(" ");
                    details.setText(" ");
;
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

                }

            }
        });
        //  SQLiteDatabase sqLiteDatabase=data.getWritableDatabase();



        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Recycle.class);
                startActivity(i);
            }
        });
    }

}
