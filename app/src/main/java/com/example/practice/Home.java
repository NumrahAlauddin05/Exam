package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView;
    BookAdapter adapter;
    ArrayList<Book> book;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView=findViewById(R.id.rec);
        book=new ArrayList<>();
        book.add(new Book("kulyat Iqbal",R.mipmap.ic_launcher));
        book.add(new Book("kulyat Iqbal",R.mipmap.ic_launcher));
        book.add(new Book("kulyat Iqbal",R.mipmap.ic_launcher));
        book.add(new Book("kulyat Iqbal",R.mipmap.ic_launcher));
        adapter=new BookAdapter(Home.this,book);
        GridLayoutManager gridLayoutManager =new GridLayoutManager(Home.this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);







    }


}
