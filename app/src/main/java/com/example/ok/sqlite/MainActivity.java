package com.example.ok.sqlite;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    DB data;
    @BindView(R.id.EDTitle)
    EditText title;
    @BindView(R.id.EDdetail)
    EditText details;
    @BindView(R.id.Txtdata)
    TextView datetext;
    @BindView(R.id.btn_save)
    Button save;

    @BindView(R.id.imgckeck)
    Button check;

    private Dialog D_DatePicker;
    private SimpleDateFormat date;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new DB(this);
        ButterKnife.bind(this);

        calendar = Calendar.getInstance();
        date = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        DatePicker();

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

    public void DatePicker() {


        D_DatePicker = new Dialog(this);
        D_DatePicker.setContentView(R.layout.dialog_date_picker);
        final DatePicker datepicker = (DatePicker) D_DatePicker.findViewById(R.id.date_picker);
        Button BTN_GetDate = (Button) D_DatePicker.findViewById(R.id.BTN_GetDate);
        Button BTN_Close = (Button) D_DatePicker.findViewById(R.id.BTN_Close);

        datepicker.setMinDate(calendar.getTimeInMillis());

        Calendar calendar_1 = Calendar.getInstance();
        calendar_1.add(Calendar.MONTH, 24);
        datepicker.setMaxDate(calendar_1.getTimeInMillis());

        BTN_GetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar2 = Calendar.getInstance();
                String FinalDate;
                calendar2.set(datepicker.getYear(), datepicker.getMonth(), datepicker.getDayOfMonth());
                FinalDate = date.format(calendar2.getTime());
                datetext.setText(FinalDate);
                D_DatePicker.dismiss();
            }
        });
        BTN_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                D_DatePicker.dismiss();
            }
        });

        D_DatePicker.show();
    }


}
