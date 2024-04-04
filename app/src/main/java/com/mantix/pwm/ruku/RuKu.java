package com.mantix.pwm.ruku;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.mantix.pwm.Adapter.FragmentHelper;
import com.mantix.pwm.Adapter.ListViewAdapter;
import com.mantix.pwm.Adapter.MyArrayAdapter;
import com.mantix.pwm.Bean.ListBean;
import com.mantix.pwm.MainFragment;
import com.mantix.pwm.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RuKu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RuKu extends Fragment {
    List<ListBean> data = new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RuKu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RuKu.
     */
    // TODO: Rename and change types and number of parameters
    public static RuKu newInstance(String param1, String param2) {
        RuKu fragment = new RuKu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        // 使用Fragment的上下文
//        Context context = getContext();
//        // 使用Activity的上下文
//        Context activityContext = getActivity();

        View view = inflater.inflate(R.layout.fragment_ru_ku, container, false);
        pageReturn(view);
        setData(view);
//        View view = inflater.inflate(R.layout.fragment_ru_ku, container, false);

//        ListView listView = view.findViewById(R.id.layout_lv);
//        List<String> items = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            items.add("Item " + i);
//        }
//        MyArrayAdapter adapter = new MyArrayAdapter(getContext(), R.layout.listview_item, items);
//        listView.setAdapter(adapter);


        return view;
    }

    private void setData(View v) {

//        for (int i = 1; i < 5; i++) {
//            String s1 = "tagid" + i;
//            String s2 = "partname" + i;
//            ListBean listBean = new ListBean();
//            listBean.setTagid(s1);
//            listBean.setPartsid(s2);
//            data.add(listBean);
//            Log.e("RUKU", "setData: " + s1 + s2);
//        }
//                ListView lv = v.findViewById(R.id.layout_lv);
//        ListViewAdapter listViewAdapter = new ListViewAdapter(data, getContext());
//       lv.setAdapter(listViewAdapter);

        ListView listView = v.findViewById(R.id.layout_lv);
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            items.add("Item " + i);
        }
        MyArrayAdapter adapter = new MyArrayAdapter(getContext(), R.layout.listview_item, items);
        listView.setAdapter(adapter);

    }


    private void pageReturn(View v) {
        Toolbar tb = v.findViewById(R.id.btn_title);
        tb.setOnClickListener(this::onClickEvent);

    }

    public void onClickEvent(View v) {
        int vid = v.getId();
        int vid_title = R.id.btn_title;
        if (vid == vid_title) {
            doPageReturn();
        }
    }

    private void doPageReturn() {
        FragmentHelper fh=new FragmentHelper(getContext(),getParentFragmentManager(),new MainFragment());
        fh.doPageReturn("ruku");
    }
}