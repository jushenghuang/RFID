package com.mantix.pwm.pandian;

import android.os.Bundle;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mantix.pwm.Adapter.FragmentHelper;
import com.mantix.pwm.Adapter.ListViewAdapter;
import com.mantix.pwm.Bean.ListBean;
import com.mantix.pwm.InfoFragment;
import com.mantix.pwm.MainFragment;
import com.mantix.pwm.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PanDian#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PanDian extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PanDian() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PanDian.
     */
    // TODO: Rename and change types and number of parameters
    public static PanDian newInstance(String param1, String param2) {
        PanDian fragment = new PanDian();
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
        View v = inflater.inflate(R.layout.fragment_pan_dian, container, false);
        pageReturn(v);
        setData(v);
        return v;
    }
    String[] tagIds=new String[]{"111111","22222","33333","44444","555555"};
    String[] partsIds=new String[]{"a11111","a22222","a33333","a44444","a555555"};
    String[] partsNames=new String[]{"欧姆龙","基恩士","SMC","三菱","西门子"};
    String[] parts=new String[]{"对照光电","漫反射光电","电磁阀","远程IO模组","通讯模组"};
    private void setData(View v) {
        List<ListBean> data =new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            String s1 = tagIds[i];
            String s2 = partsNames[i];
            ListBean listBean = new ListBean();
            listBean.setTagid(s1);
            listBean.setPartsid(s2);
            data.add(listBean);
        }
        ListView lv = v.findViewById(R.id.layout_lv1);
        ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(),data );
        lv.setAdapter(listViewAdapter);
        Log.e("PanDian", "setData: ");
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 获取被点击的项的数据
                ListBean item = data.get(position);
                goToInfoFgm(item);
                // 执行点击后的操作，比如跳转到新的Activity或者更新UI等
                Toast.makeText(getActivity(), "Clicked on " + item.getPartsid(), Toast.LENGTH_SHORT).show();
            }
        });

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

    private void goToInfoFgm(ListBean item) {
        Fragment newFgm=new InfoFragment(item.getTagid(),item.getPartsid());

        FragmentHelper fh=new FragmentHelper(getContext(),getParentFragmentManager(),newFgm);
        fh.showNewHideOld("pandian","info");
    }

    private void doPageReturn() {
        FragmentHelper fh=new FragmentHelper(getContext(),getParentFragmentManager(),new MainFragment());
        fh.doPageReturn("pandian");
    }
}