package com.artiomtaliaronak.ipr2ppo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton addButton;

    AlbumDatabaseHelper myDB;
    ArrayList<String> albumId, albumTitle, albumAuthor, albumTracks;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new AlbumDatabaseHelper(MainActivity.this);
        albumId = new ArrayList<>();
        albumTitle = new ArrayList<>();
        albumAuthor = new ArrayList<>();
        albumTracks = new ArrayList<>();

        displayData();

        customAdapter = new CustomAdapter(MainActivity.this, albumId, albumTitle, albumAuthor, albumTracks);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    void displayData(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                albumId.add(cursor.getString(0));
                albumTitle.add(cursor.getString(1));
                albumAuthor.add(cursor.getString(2));
                albumTracks.add(cursor.getString(3));
            }
        }
    }
}