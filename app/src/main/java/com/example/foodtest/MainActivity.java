package com.example.foodtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;

import com.example.foodtest.model.HorizontalFlipTransformation;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity  {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.viewPager);
        tabLayout=findViewById(R.id.tabLayout);

        FragmentManager manager=getSupportFragmentManager();
        FragmentAdapter adapter=new FragmentAdapter(manager,3);
        viewPager.setPageTransformer(true, new HorizontalFlipTransformation());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setTablayoutTitleColor();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0: tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(com.google.android.material.R.color.material_dynamic_tertiary30));
                        break;
                    case 1: tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(com.google.android.material.R.color.design_default_color_primary));
                        break;
                    case 2: tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(R.color.purple_200));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setTablayoutTitleColor() {
        switch (viewPager.getCurrentItem()){
            case 0:
                tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(com.google.android.material.R.color.material_dynamic_tertiary30));
                break;
            case 1:
                tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(com.google.android.material.R.color.design_default_color_primary));
                break;
            case 2:
                tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(R.color.purple_200));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if(viewPager.getCurrentItem()==0)
            super.onBackPressed();
        else
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
    }
}