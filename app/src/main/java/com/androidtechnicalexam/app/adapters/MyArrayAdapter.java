package com.androidtechnicalexam.app.adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.view.LayoutInflater;
import android.widget.TextView;

import com.androidtechnicalexam.app.models.MyModel;

import java.util.ArrayList;
import java.util.List;

import coloryourcalendar.indie.com.androidtechnicalexam.R;

/**
 * Created by ihortelano on 7/30/15.
 */
public class MyArrayAdapter extends ArrayAdapter {

    public MyArrayAdapter(Context context, List<MyModel> objects) {
        super(context, R.layout.list_items, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         //super.getView(position, convertView, parent);
        View v = convertView;
        if(v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_items, parent, false);
        }
        if(getCount() != 0) {
            Log.i("Test", ((MyModel)getItem(position)).name);
            ((TextView) v.findViewById(R.id.name)).setText(((MyModel)getItem(position)).name);
            ((TextView) v.findViewById(R.id.userName)).setText(((MyModel)getItem(position)).username);
            ((TextView) v.findViewById(R.id.email)).setText(((MyModel)getItem(position)).email);

        } else {
            Log.i("Test", "modelList is empty");
        }

        return v;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }


}
