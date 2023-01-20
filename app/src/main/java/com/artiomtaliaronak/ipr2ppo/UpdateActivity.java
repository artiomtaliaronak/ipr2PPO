package com.artiomtaliaronak.ipr2ppo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText titleInput, authorInput, tracksInput;
    Button updateButton;
    String id, title, author, tracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        titleInput = findViewById(R.id.titleInput2);
        authorInput = findViewById(R.id.authorInput2);
        tracksInput = findViewById(R.id.tracksInput2);
        updateButton = findViewById(R.id.updateButton);
        getAndSetIntentData();
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlbumDatabaseHelper myDB = new AlbumDatabaseHelper(UpdateActivity.this);
                title = titleInput.getText().toString().trim();
                author = authorInput.getText().toString().trim();
                tracks = tracksInput.getText().toString().trim();
                myDB.updateData(id, title, author, tracks);
            }
        });



    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") && getIntent().hasExtra("author") && getIntent().hasExtra("tracks")){
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            author = getIntent().getStringExtra("author");
            tracks = getIntent().getStringExtra("tracks");

            titleInput.setText(title);
            authorInput.setText(author);
            tracksInput.setText(tracks);

        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}