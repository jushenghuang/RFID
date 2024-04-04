package com.mantix.pwm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mantix.pwm.chuku.ChuKu;
import com.mantix.pwm.pandian.PanDian;
import com.mantix.pwm.ruku.RuKu;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    private final String TAG="主页子页面";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        changePage(v);//切换画面
        return v;
    }

    private void changePage(View view) {
        Button btnChuku = view.findViewById(R.id.chgChuKu);
        btnChuku.setOnClickListener(this::onClick);
        Button btnRuku = view.findViewById(R.id.chgRuku);
        btnRuku.setOnClickListener(this::onClick);
        Button btnPanDian = view.findViewById(R.id.chgPanDian);
        btnPanDian.setOnClickListener(v -> onClick(v));
    }

    @Override
    public void onClick(View v) {
        int vid = v.getId();
       int vid1= R.id.chgRuku;
       int vid2= R.id.chgPanDian;
       int vid3= R.id.chgChuKu;
       if (vid==vid1){
           doReplace(new RuKu(),"ruku");
          Log.e(TAG, "onClick: 入库页" );
       }
       else if (vid==vid2){

           doReplace(new PanDian(),"pandian");
           Log.e(TAG, "onClick: 盘点页" );
       }
       else if (vid==vid3){
          ChuKu ch= new ChuKu();
           doReplace(ch,"chuku");
           Log.e(TAG, "onClick: 出库页" );
       }
    }

    private void doReplace(Fragment fragment,String tag) {
        FragmentManager pfgm = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = pfgm.beginTransaction();
        Fragment fg=pfgm.findFragmentByTag("mainfragment");
        fragmentTransaction.hide(fg);
        fragmentTransaction.add(R.id.fgLayout,fragment,tag);
        fragmentTransaction.commit();

    }
}