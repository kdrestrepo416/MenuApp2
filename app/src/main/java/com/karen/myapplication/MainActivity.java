package com.karen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_codigo,et_descripcion,et_precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_codigo=(EditText)findViewById(R.id.txt_codigo);
        et_descripcion=(EditText)findViewById(R.id.txt_descripcion);
        et_precio=(EditText)findViewById(R.id.txt_precio);


    }


    public  boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if (id==R.id.item1){
            Toast.makeText(this,"Opcion 1",Toast.LENGTH_LONG).show();
        } else if (id==R.id.item2){
            Toast.makeText(this,"Opcion 2",Toast.LENGTH_LONG).show();
        } else if (id==R.id.item3) {
            Toast.makeText(this,"Opcion 3",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }


    public void Registrar (View view){
        AdminSQliteOpenHelper admin= new AdminSQliteOpenHelper(this, "administracion",null , 1);
        SQLiteDatabase BaseDeDatos= admin.getWritableDatabase();

        String codigo=et_codigo.getText().toString();
        String descripcion=et_descripcion.getText().toString();
        String precio=et_precio.getText().toString();

        if (!codigo.isEmpty() && !descripcion.isEmpty() &&!precio.isEmpty()){
            ContentValues registro= new ContentValues();
             registro.put("codigo",codigo);
            registro.put("descripcion",descripcion);
            registro.put("precio",precio);
            BaseDeDatos.insert("articulos", null,registro);
            BaseDeDatos.close();

            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            Toast.makeText(this,"Registro Exitoso",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Debes llenar Todos Los Campos",Toast.LENGTH_SHORT).show();
        }


    }


}