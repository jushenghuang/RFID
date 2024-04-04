package com.mantix.pwm.chuku;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mantix.pwm.Adapter.FragmentHelper;
import com.mantix.pwm.MainFragment;
import com.mantix.pwm.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChuKu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChuKu extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChuKu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChuKu.
     */
    // TODO: Rename and change types and number of parameters
    public static ChuKu newInstance(String param1, String param2) {
        ChuKu fragment = new ChuKu();
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
        View v = inflater.inflate(R.layout.fragment_chu_ku, container, false);
        pageReturn(v);
        return v;
    }

    private void pageReturn(View v) {
        Toolbar tb = v.findViewById(R.id.btn_title);
        tb.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {
        int vid = v.getId();
        int vid_title = R.id.btn_title;
        if (vid==vid_title){
            doPageReturn();
        }
    }

    private void doPageReturn() {



        FragmentHelper fh=new FragmentHelper(getContext(),getParentFragmentManager(),new MainFragment());
        fh.doPageReturn("chuku");
    }
}