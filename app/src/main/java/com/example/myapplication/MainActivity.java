package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    TodoAdapter adapter;
//    String [] entries ;
    List<Todo> entries ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        entries = getResources().getStringArray(android.R.array.phoneTypes);
        entries = new ArrayList<Todo>();
//
        for (int i =0 ; i <100; i++){
            String n = ""+i;
            String g = "desciption "+i;
            entries.add(new Todo(n,g));
        }



        listView = findViewById(R.id.listview);
        adapter = new TodoAdapter(this , R.layout.row  ,entries);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,parent.getAdapter().getItem(position).toString(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("keyName" , parent.getAdapter().getItem(position).toString());

                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int which_item = position;
                new AlertDialog.Builder(MainActivity.this).setIcon(android.R.drawable.ic_delete)
                .setTitle("Are You Sure?").setMessage("Do you  want to delete this item?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        entries.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("No",null).show();
                return true;
            }
        });
    }
}