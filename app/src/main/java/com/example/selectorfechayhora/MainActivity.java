package com.example.selectorfechayhora;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnFecha,btnHora;
    EditText txtFecha, txtHora;
    private int dia,mes,ano,hora,minuto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFecha=(Button)findViewById(R.id.btnFecha);
        btnHora=(Button)findViewById(R.id.btnHora);
        txtFecha=(EditText)findViewById(R.id.txtFecha);
        txtHora=(EditText)findViewById(R.id.txtHora);
        btnFecha.setOnClickListener(this);
        btnHora.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnFecha){
            final Calendar cal= Calendar.getInstance();
            dia=cal.get(Calendar.DAY_OF_MONTH);
            mes=cal.get(Calendar.MONTH);
            ano=cal.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog;
            datePickerDialog= new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    txtFecha.setText(dayOfMonth+"/"+ (monthOfYear+1)+"/"+ year);
                }
            },dia,mes,ano);
            datePickerDialog.show();
        }

        if(v==btnHora){
            final Calendar cal= Calendar.getInstance();
            hora=cal.get(Calendar.HOUR_OF_DAY);
            minuto=cal.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog;
            timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            txtHora.setText(hourOfDay+":"+minute);
                        }
                    },hora,minuto,false);
            timePickerDialog.show();
        }
    }
}