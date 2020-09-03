package com.example.Fitness_tracker;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UsersidAdapter extends ArrayAdapter<UserIdMulti_tracker> {

    private LayoutInflater mInflater;
    private ArrayList<UserIdMulti_tracker> users;
    private int mViewResourceId;

    public UsersidAdapter(Context context, int textViewResourceId, ArrayList<UserIdMulti_tracker> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    //getView() is the method that returns the actual view used as a row within the ListView at a particular position
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        UserIdMulti_tracker user = users.get(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = mInflater.inflate(mViewResourceId, null); //new view
        }
        // Lookup view
        if (user != null) {
            TextView name = (TextView) convertView.findViewById(R.id.textName_);
            TextView sleep = (TextView) convertView.findViewById(R.id.textsleep);
            TextView water_intake = (TextView) convertView.findViewById(R.id.textwater_intake);
            TextView CalorieDailyIntake = (TextView) convertView.findViewById(R.id.textCalorieDailyIntake);
            // Populate the data into the template view using the data object

            if (name != null) {
                name.setTextColor(Color.WHITE);
                name.setText(user.getName()); //bindView
            }
            if (sleep != null) {
                sleep.setTextColor(Color.WHITE);
                sleep.setText(Integer.toString(user.getsets()));
            }
            if (water_intake != null) {
                water_intake.setTextColor(Color.WHITE);
                water_intake.setText(Integer.toString(user.getreps()));
            }

            if (CalorieDailyIntake != null) {
                CalorieDailyIntake.setTextColor(Color.WHITE);
                CalorieDailyIntake.setText(Integer.toString(user.gettimeTaken()));
            }

        }
        // Return the completed view to render on screen

        return convertView;
    }
}
