package com.example.practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookHolder> {


    Context context;
    ArrayList<Book> bookarray;

    public BookAdapter(Context context, ArrayList<Book> bookarray) {
        this.context = context;
        this.bookarray = bookarray;
    }

    @NonNull
    @Override



    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.booklist,parent,false);
        BookHolder bookHolder=new BookHolder(view);
        return  bookHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {
     holder.textView.setText(bookarray.get(position).getName());
     holder.imageView.setImageResource(bookarray.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return bookarray.size();
    }
}
