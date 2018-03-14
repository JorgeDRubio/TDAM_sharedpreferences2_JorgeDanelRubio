package com.example.jorge.tdam_sharedpreferences2_jorgedanelrubio;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtNombre, txtCelular, txtDirecion, txtFecha,txtHora,txtPlatillos,txtPostres;
    CheckBox chBasica, chLujo;
    SeekBar seeMeseros;
    Button btnSaved, btnGet;
    TextView textMeseros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.editText);
        txtCelular = findViewById(R.id.editText2);
        txtDirecion = findViewById(R.id.editText3);
        txtFecha = findViewById(R.id.editText4);
        txtHora = findViewById(R.id.editText5);
        txtPlatillos = findViewById(R.id.editText6);
        txtPostres = findViewById(R.id.editText7);
        chBasica = findViewById(R.id.checkBox);
        chLujo = findViewById(R.id.checkBox2);
        seeMeseros = findViewById(R.id.seekBar);
        btnSaved = findViewById(R.id.button);
        btnGet = findViewById(R.id.button2);
        textMeseros = findViewById(R.id.textView2);

        seeMeseros.setProgress(0);
        seeMeseros.setMax(10);

        seeMeseros.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textMeseros.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar();

            }
        });



    }


        private void guardar(){

            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor  = sharedPreferences.edit();

           editor.putString("nombre",txtNombre.getText().toString());
           editor.putString("celular",txtCelular.getText().toString());
           editor.putString("direccion",txtDirecion.getText().toString());
           editor.putString("fecha",txtFecha.getText().toString());
           editor.putString("platillos",txtPlatillos.getText().toString());
           editor.putString("postres",txtPostres.getText().toString());
           editor.putBoolean("basica",chBasica.isChecked());
           editor.putBoolean("lujo",chLujo.isChecked());
           editor.putString("numero",textMeseros.getText().toString());
            editor.putInt("meseros",Integer.parseInt(textMeseros.getText().toString()));

           editor.commit();

            Toast.makeText(this,"SAVED",Toast.LENGTH_SHORT).show();
        }

        private void mostrar(){
            String Nombre="";
            String Celular ="";
            String Direccion="";
            String Fecha = "";
            String Platillos = "";
            String Postres ="";
            Boolean bascia;
            Boolean lujo;
            String numero="";
            int meseros;


            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);


            Nombre = sharedPreferences.getString("nombre",null);
            Celular = sharedPreferences.getString("celular",null);
            Direccion = sharedPreferences.getString("direccion",null);
            Fecha= sharedPreferences.getString("fecha",null);
            Platillos = sharedPreferences.getString("platillos",null);
            Postres = sharedPreferences.getString("postres",null);
            bascia = sharedPreferences.getBoolean("basica",false);
            lujo = sharedPreferences.getBoolean("lujo",false);
            meseros = sharedPreferences.getInt("Meseros",0);
            numero = sharedPreferences.getString("numero",null);

            txtNombre.setText(Nombre);
            txtCelular.setText(Celular);
            txtDirecion.setText(Direccion);
            txtFecha.setText(Fecha);
            txtPlatillos.setText(Platillos);
            txtPostres.setText(Postres);
            this.chBasica.setChecked(bascia);
            this.chLujo.setChecked(lujo);
            seeMeseros.setProgress(meseros);
            textMeseros.setText(numero);

            Toast.makeText(this,"Get Me",Toast.LENGTH_SHORT).show();
        }

    }