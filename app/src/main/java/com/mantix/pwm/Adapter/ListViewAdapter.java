package com.mantix.pwm.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.ListAdapter;

import com.mantix.pwm.Bean.ListBean;
import com.mantix.pwm.R;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private final String TAG = "ListViewAdapter";
    List<ListBean> data;
    Context context;

    public ListViewAdapter(Context context, List<ListBean> listBean) {
        this.data = listBean;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listview_item, parent, false);
        }
        TextView tv1 = view.findViewById(R.id.item_tv1);
        TextView tv2 = view.findViewById(R.id.item_tv2);
        tv1.setText("Tag:" + data.get(position).getTagid());
        tv2.setText("PartsId:" + data.get(position).getPartsid());

        return view;
    }
}
