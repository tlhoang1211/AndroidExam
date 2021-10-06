package com.example.androidexam.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import com.example.androidexam.SubActivity;
import com.example.androidexam.R;
import com.example.androidexam.adapter.ProductAdapter;
import com.example.androidexam.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ListAllProducts extends AppCompatActivity  {
    private List<Product> products = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_products);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ProductAdapter(products, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        getAllData();
    }

    private void getAllData() {
        products.clear();
        Cursor cursor = SubActivity.getInstance().getDatabase().getData("SELECT * FROM Product");
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int quantity = cursor.getInt(2);
            products.add(new Product(id, name, quantity));
        }

        adapter.notifyDataSetChanged();

        Log.d("TAG", "getAllData: " + products.size());
    }
}
