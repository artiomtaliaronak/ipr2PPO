package com.artiomtaliaronak.ipr2ppo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText titleInput, authorInput, trackInput;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        titleInput = findViewById(R.id.titleInput);
        authorInput = findViewById(R.id.authorInput);
        trackInput = findViewById(R.id.trackInput);
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlbumDatabaseHelper myDB = new AlbumDatabaseHelper(AddActivity.this);
                myDB.addAlbum(titleInput.getText().toString().trim(), authorInput.getText().toString().trim(),
                        Integer.valueOf(trackInput.getText().toString().trim()));
            }
        });
    }
}