package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TodoAdapter extends ArrayAdapter<Todo> {
    Context cont;
    int res= R.layout.row;
    List<Todo> todoList;
    TextView textView , textView2;
    public TodoAdapter(@NonNull Context context, int resource, @NonNull List<Todo> todos) {
        super(context, resource, todos);
        cont = context;
        todoList = todos;
        res= resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        LayoutInflater inflater = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(res,parent,false);
        textView = view.findViewById(R.id.textView8);
        textView.setText(todoList.get(position).getTitle());
        textView2 = view.findViewById(R.id.textView9);
        textView2.setText(todoList.get(position).getDes());
        return view;
    }
}
