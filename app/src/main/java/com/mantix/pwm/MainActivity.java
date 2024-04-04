package com.mantix.pwm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.mantix.pwm.Adapter.ListViewAdapter;
import com.mantix.pwm.Adapter.MyViewAdapter;
import com.mantix.pwm.Adapter.VpAdapter;
import com.mantix.pwm.Bean.ListBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    List<ListBean> data =new ArrayList<>();
    String[] tagIds=new String[]{"111111","22222","33333","44444","555555"};
    String[] partsIds=new String[]{"a11111","a22222","a33333","a44444","a555555"};
    String[] partsNames=new String[]{"欧姆龙","基恩士","SMC","三菱","西门子"};
    String[] parts=new String[]{"对照光电","漫反射光电","电磁阀","远程IO模组","通讯模组"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        View lay1 = getLayoutInflater().inflate(R.layout.layout1, null);
        View lay11 = getLayoutInflater().inflate(R.layout.layout11, null);
        View lay12 = getLayoutInflater().inflate(R.layout.layout12, null);
        View lay13= getLayoutInflater().inflate(R.layout.layout13, null);

        List<View> lv=new ArrayList<>();
         lv.add(lay1);
//         lv.add(lay11);
//         lv.add(lay12);
//         lv.add(lay13);

//        ViewPager viewPager = findViewById(R.id.vpMain);
//        VpAdapter vp=new VpAdapter(lv);
//        viewPager.setAdapter(vp);
        FragmentManager sfm = getSupportFragmentManager();
        FragmentTransaction ft = sfm.beginTransaction();
        MainFragment mainFragment = new MainFragment();
        ft.replace(R.id.fgLayout, mainFragment,"mainfragment");
        ft.commit();


//        for (int i = 1; i < 5; i++) {
//            String s1 = "tagid" + i;
//            String s2 = "partname" + i;
//            ListBean listBean = new ListBean();
//            listBean.setTagid(s1);
//            listBean.setPartsid(s2);
//            data.add(listBean);
//        }
//        ListView lv2 = this.findViewById(R.id.listview1);
////        ListView lv2 = findViewById(R.id.listview1);
//       lv2.setAdapter(new MyViewAdapter(this,data));

    }

    @Override
    public void onClick(View v) {

    }
}