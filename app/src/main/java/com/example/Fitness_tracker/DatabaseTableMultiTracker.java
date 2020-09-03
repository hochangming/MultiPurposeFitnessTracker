package com.example.Fitness_tracker;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DatabaseTableMultiTracker extends AppCompatActivity {
    DataBaseHelper db;
    UserIdMulti_tracker user;
    ArrayList<UserIdMulti_tracker> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_table_multi_tracker);

        db = new DataBaseHelper(this);
        Button deleteidEntryButton = findViewById(R.id.deleteidEntryButton);
        final EditText enterNameidEditText = findViewById(R.id.enterNameidEditText);

        deleteidEntryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete_Product(enterNameidEditText.getText().toString());
                Intent intent = new Intent(DatabaseTableMultiTracker.this, Multi_tracker.class);
                startActivity(intent);
            }
        });

        usersList = new ArrayList<>();
        Cursor data = db.get_List_Contents();
        int rowsNum = data.getCount();
        if (rowsNum == 0) {
            Toast.makeText(DatabaseTableMultiTracker.this, "Database is empty", Toast.LENGTH_LONG).show();
        } else {
            int i = 0;
            while (data.moveToNext()) {
                user = new UserIdMulti_tracker(data.getString(0), data.getInt(1), data.getInt(2), data.getInt(3));
                usersList.add(i, user);
                i++;
            }
            UsersidAdapter adapter = new UsersidAdapter(this, R.layout.useriditemlist, usersList);
            ListView listView = findViewById(R.id.listView);

            listView.setAdapter(adapter);
        }
    }
}