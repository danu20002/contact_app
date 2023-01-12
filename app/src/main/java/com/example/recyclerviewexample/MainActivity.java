package com.example.recyclerviewexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    recyclerAdapter Adapter;
ArrayList<contact_model> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerview= findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton adding=(FloatingActionButton) findViewById(R.id.floating);
        adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    Dialog dialog=new Dialog(MainActivity.this);
    dialog.setContentView(R.layout.add_update);
                EditText editname=dialog. findViewById(R.id.edittext1);
                EditText editnumber=dialog. findViewById(R.id.edittext2);
               Button btnaction=dialog. findViewById(R.id.btnaction);
btnaction.setOnClickListener(new View.OnClickListener() {
    @Override

    public void onClick(View view) {
        String name = "",number="";
        if(!editname.getText().toString().equals("")) {
             name=editname.getText().toString();

        }else
        {
            Toast.makeText(MainActivity.this,"please enter name",Toast.LENGTH_SHORT).show();
        }
        if(!editnumber.getText().toString().equals("")){
             number = editnumber.getText().toString();
        }else{
            Toast.makeText(MainActivity.this,"Please enter number",Toast.LENGTH_SHORT).show();
        }
        arrayList.add(new contact_model(R.drawable.myimage,name,number));
        Adapter.notifyItemInserted(arrayList.size()-1);
       recyclerview.scrollToPosition(arrayList.size()-1);
       dialog.dismiss();
    }
});
                dialog.show();
            }
        });
        arrayList.add(new contact_model(R.drawable.a,"danu","7022329220"));
        arrayList.add(new contact_model(R.drawable.b,"manu","7022329220"));
        arrayList.add(new contact_model(R.drawable.a,"pappa","7022329220"));
        arrayList.add(new contact_model(R.drawable.a,"danu","7022329220"));
        arrayList.add(new contact_model(R.drawable.a,"danu","7022329220"));
        arrayList.add(new contact_model(R.drawable.a,"danu","7022329220"));
        arrayList.add(new contact_model(R.drawable.a,"danu","7022329220"));
        arrayList.add(new contact_model(R.drawable.a,"danu","7022329220"));
        arrayList.add(new contact_model(R.drawable.a,"danu","7022329220"));
        arrayList.add(new contact_model(R.drawable.a,"danu","7022329220"));
        arrayList.add(new contact_model(R.drawable.a,"danu","7022329220"));
        arrayList.add(new contact_model(R.drawable.a,"danu","7022329220"));
        arrayList.add(new contact_model(R.drawable.a,"danu","7022329220"));
        arrayList.add(new contact_model(R.drawable.a,"danu","7022329220"));
        arrayList.add(new contact_model(R.drawable.a,"danu","7022329220"));

        Adapter=new recyclerAdapter(this,arrayList);
        recyclerview.setAdapter(Adapter);
    }
}