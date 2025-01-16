package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    EditText etNome = null, etCognome = null;
    CheckBox patente = null;
    RadioButton rbUomo = null, rbDonna = null;
    ListView lvElenco = null;
    final ArrayList<String> listPersone = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets((WindowInsetsCompat.Type.systemBars()));
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recuperaWidget();
    }

    private void recuperaWidget()
    {
        etNome = (EditText) findViewById(R.id.Name);
        etCognome = (EditText) findViewById(R.id.Surname);
        patente = (CheckBox) findViewById(R.id.Patente);
        rbUomo = (RadioButton) findViewById(R.id.Male);
        rbDonna = (RadioButton) findViewById(R.id.Female);
        lvElenco = (ListView) findViewById(R.id.utenti);
    }

    public void btMostra_click(View v)
    {
        String _nome = etNome.getText().toString();
        String _cognome = etCognome.getText().toString();
        String _patente = "";
        if(patente.isChecked())
            _patente = "patentato";
        else
            _patente = "non patentato";
        String _sesso = " ";
        if(rbUomo.isChecked())
            _sesso = "Uomo";
        else if (rbDonna.isChecked())
            _sesso = "Donna";

        listPersone.add(_nome + '\n' + _cognome + '\n' + _patente + '\n' + _sesso);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listPersone);
        lvElenco.setAdapter(adapter);

        System.out.println(_nome + '\n' + _cognome + '\n' + _patente + '\n' + _sesso);
    }

    public void etName_click(View v)
    {
        etNome.setText("");
    }

    public void etSurname_click(View v)
    {
        etCognome.setText("");
    }
}