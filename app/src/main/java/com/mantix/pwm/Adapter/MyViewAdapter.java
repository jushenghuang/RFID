package com.mantix.pwm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mantix.pwm.Bean.ListBean;
import com.mantix.pwm.R;

import java.util.List;

public class MyViewAdapter extends BaseAdapter {
    private Context context;
    private List<ListBean> data;

    public MyViewAdapter(Context context, List<ListBean> data) {
        this.context = context;
        this.data = data;
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
       View view= LayoutInflater.from(context).inflate(R.layout.listview_item,parent,false);
        TextView tv1 = view.findViewById(R.id.item_tv1);
        tv1.setText(data.get(position).getTagid());
        TextView tv2 = view.findViewById(R.id.item_tv2);
        tv1.setText(data.get(position).getPartsid());

        return view;
    }
}
