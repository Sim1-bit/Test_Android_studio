package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
//import androidx.activity.;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;


import android.os.Bundle;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity
{
    String endl = "\n";
    EditText nome = null, cognome = null;
    RadioGroup sesso = null;
    DatePicker data = null;
    CheckBox tecnologia = null, arte = null, musica = null, sport = null, auto = null;
    Button genera = null;
    TextView riassunto = null;

    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recuperaWidget();

    }

    private void recuperaWidget()
    {
        nome = (EditText) findViewById(R.id.Name);
        cognome = (EditText) findViewById(R.id.Surname);
        sesso = (RadioGroup) findViewById(R.id.radioGroup);
        tecnologia = (CheckBox) findViewById(R.id.hobby);
        arte = (CheckBox) findViewById(R.id.hobby1);
        musica = (CheckBox) findViewById(R.id.hobby2);
        sport = (CheckBox) findViewById(R.id.hobby3);
        auto = (CheckBox) findViewById(R.id.hobby4);

        data = (DatePicker) findViewById(R.id.calendarView);

        riassunto = (TextView) findViewById(R.id.textView);

        genera = (Button) findViewById(R.id.button);

        mYear = data.getYear();
        mMonth = data.getMonth();
        mDay = data.getDayOfMonth();
    }

    public void btMostra_click(View v)
    {
        String aux = nome.getText().toString() + "\n";
        aux += cognome.getText().toString() + "\n";


        if(sesso.getCheckedRadioButtonId() == R.id.Male)
            aux += "Uomo" + "\n";
        else if (sesso.getCheckedRadioButtonId() == R.id.Male)
            aux += "Donna" + "\n";

        if(tecnologia.isChecked())
           aux += "tecnologia" + " \n";
        if(arte.isChecked())
            aux += "arte" + " \n";
        if(musica.isChecked())
            aux += "musica" + " \n";
        if(sport.isChecked())
            aux += "sport" + " \n";
        if(auto.isChecked())
            aux += "auto" + " \n";

        aux += mDay + "/" + mMonth + "/" + mYear + "\n";

        riassunto.setText(aux);
    }
}