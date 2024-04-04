package com.mantix.pwm;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mantix.pwm.Adapter.FragmentHelper;
import com.mantix.pwm.pandian.PanDian;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String Tag = "info";

    public InfoFragment(String mParam1, String mParam2) {
        this.mParam1 = mParam1;
        this.mParam2 = mParam2;
    }

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InfoFragment newInstance(String param1, String param2) {
        InfoFragment fragment = new InfoFragment();
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


        View view = inflater.inflate(R.layout.fragment_info, container, false);
        setData(view);


        pageReturn(view);

        return view;
    }

    private void setData(View view) {
        TextView tv1 = view.findViewById(R.id.tv1);
        TextView tv2 = view.findViewById(R.id.tv2);
        tv1.setText(mParam1);
        tv2.setText(mParam2);
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
        FragmentHelper fh = new FragmentHelper(getContext(), getParentFragmentManager(), new PanDian());
        fh.showOldCloseCurrent("info", "pandian");
    }
}