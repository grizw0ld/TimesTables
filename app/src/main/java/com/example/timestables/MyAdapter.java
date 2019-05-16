package com.example.timestables;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;

import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {
    private SparseBooleanArray enabledItems = new SparseBooleanArray();

    public MyAdapter(Context context, int textViewResourceId, List<String> objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        //return false;
        return enabledItems.get(position, true);
    }

    public void toggleItem(int position) {
        boolean state = enabledItems.get(position, true);
        enabledItems.put(position, !state);
    }
}