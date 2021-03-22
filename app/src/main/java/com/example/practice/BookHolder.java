package com.example.practice;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookHolder extends RecyclerView.ViewHolder {
ImageView imageView;
TextView textView;


    public BookHolder(@NonNull View itemView) {
        super(itemView);

        imageView= itemView.findViewById(R.id.imageview);
        textView =itemView.findViewById(R.id.textview);


    }
}
