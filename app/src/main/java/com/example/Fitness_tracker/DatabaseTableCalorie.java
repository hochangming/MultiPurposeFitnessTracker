package com.example.Fitness_tracker;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DatabaseTableCalorie extends AppCompatActivity {
    DataBaseHelper db;
    User user;
    ArrayList<User> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_table);

        db = new DataBaseHelper(this);
        Button deleteEntryButton = findViewById(R.id.deleteEntryButton);
        final EditText enterNameEditText = findViewById(R.id.enterNameEditText);

        deleteEntryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteProduct(enterNameEditText.getText().toString());
                Intent intent = new Intent(DatabaseTableCalorie.this, Calorie_Activity.class);
                startActivity(intent);
            }
        });

        usersList = new ArrayList<>();
        Cursor data = db.getListContents();
        int rowsNum = data.getCount();
        if (rowsNum == 0) {
            Toast.makeText(DatabaseTableCalorie.this, "Database is empty", Toast.LENGTH_LONG).show();
        } else {
            int i = 0;
            while (data.moveToNext()) {
                user = new User(data.getString(0), data.getInt(1), data.getInt(2), data.getInt(3));
                usersList.add(i, user);
                i++;
            }
            UsersAdapter adapter = new UsersAdapter(this, R.layout.item_user, usersList);
            ListView listView = findViewById(R.id.listView);

            listView.setAdapter(adapter);
        }
    }
}