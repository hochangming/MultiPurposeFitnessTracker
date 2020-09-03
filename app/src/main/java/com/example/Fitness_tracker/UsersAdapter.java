package com.example.Fitness_tracker;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
/*

1: The LayoutInflater takes your layout XML-files and creates different View-objects from its contents.

2: The adapters are built to reuse Views, when a View is scrolled so that is no longer visible,
it can be used for one of the new Views appearing. This reused View is the convertView.
 If this is null it means that there is no recycled View and we have to create a new one,
  otherwise we should use it to avoid creating a new.

3: The parent is provided so you can inflate your view into that for proper layout parameters.

All these together can be used to effectively create the view that will appear in your list (or other view that takes an adapter):*/

//That adapter has a constructor and a getView() method to describe the translation between the data item and the View to display.
public class UsersAdapter extends ArrayAdapter<User> {
    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceId;

    public UsersAdapter(Context context, int textViewResourceId, ArrayList<User> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    //getView() is the method that returns the actual view used as a row within the ListView at a particular position
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = users.get(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = mInflater.inflate(mViewResourceId, null); //new view
        }
        // Lookup view
        if (user != null) {
            TextView name = (TextView) convertView.findViewById(R.id.textName);
            TextView age = (TextView) convertView.findViewById(R.id.textAge);
            TextView weight = (TextView) convertView.findViewById(R.id.textWeight);
            TextView CalorieDailyIntake = (TextView) convertView.findViewById(R.id.textCalorieDailyIntake);
            // Populate the data into the template view using the data object

            if (name != null) {
                name.setTextColor(Color.WHITE);
                name.setText(user.getName()); //bindView
            }
            if (age != null) {
                age.setTextColor(Color.WHITE);
                age.setText(Integer.toString(user.getAge()));
            }
            if (weight != null) {
                weight.setTextColor(Color.WHITE);
                weight.setText(Integer.toString(user.getWeight()));
            }

            if (CalorieDailyIntake != null) {
                CalorieDailyIntake.setTextColor(Color.WHITE);
                CalorieDailyIntake.setText(Integer.toString(user.getDailyCaloricIntake()));
            }

        }
        // Return the completed view to render on screen

        return convertView;
    }

}
