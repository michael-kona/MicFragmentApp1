package com.example.micfragmentapp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    FragmentManager fmgr;
    FragmentTransaction ft;
    SportsFragment csef;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            csef = new SportsFragment();
            fmgr = getSupportFragmentManager();
            fmgr.setFragmentResultListener("requestKey", this, new FragmentResultListener() {
                @Override
                public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result)
                {
                ft=fmgr.beginTransaction();
                int option=result.getInt("SelectedItemIndex");
                switch(option)
                    {
                        case 0:ft.replace(R.id.ll_bottom,new BadmintonFragment());
                                     break;
                        case 1:ft.replace(R.id.ll_bottom,new CricketFragment());
                                break;
                        case 2:ft.replace(R.id.ll_bottom,new TennisFragment());
                                break;
                        case 3:ft.replace(R.id.ll_bottom,new HockeyFragment());
                                break;
                        default:ft.replace(R.id.ll_bottom,new HockeyFragment());
                    }
                ft.commit();
                }
            });
            ft = fmgr.beginTransaction();
            ft.add(R.id.ll_top,csef);ft.commit();
        }
        catch (Exception ex)
        {
            Log.d("INITIAL ERROR:->", "onCreate: "+ex.getMessage());
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}