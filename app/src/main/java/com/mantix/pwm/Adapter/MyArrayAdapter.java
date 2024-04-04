package com.mantix.pwm.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.mantix.pwm.Bean.ListBean;
import com.mantix.pwm.R;

import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<String> {
    private Context context;

    public MyArrayAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 创建视图或者重用convertView
        TextView textView = (TextView) convertView;
        if (textView == null) {
            textView = (TextView) LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);

        }

        textView.setText(getItem(position));
        return textView;
    }
}
