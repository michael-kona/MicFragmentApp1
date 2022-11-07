package com.example.micfragmentapp1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class SportsFragment extends Fragment implements AdapterView.OnItemClickListener
{
    ListView lv;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SportsFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SportsFragment newInstance(String param1, String param2) {
        SportsFragment fragment = new SportsFragment();
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
        return inflater.inflate(R.layout.fragment_sports, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        lv=(ListView)view.findViewById(R.id.lv_fragment);
        lv.setOnItemClickListener(this);
        super.onViewCreated(view, savedInstanceState);
    }

   @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        try {
               Toast.makeText(getContext(),lv.getItemAtPosition(i).toString() , Toast.LENGTH_SHORT).show();
               Bundle bun=new Bundle();
               bun.putInt("SelectedItemIndex",i);
               getParentFragmentManager().setFragmentResult
                       ("requestKey",bun);
            }
        catch(Exception ex)
        {
            Log.d("MIC EXCEPTION", "onItemClick: "+ex.getMessage());
            Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}