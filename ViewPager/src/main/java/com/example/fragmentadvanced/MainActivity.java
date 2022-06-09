package com.example.fragmentadvanced;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.fragmentadvanced.Fragment.Adapter.ViewPagerAdapter;
import com.example.fragmentadvanced.Fragment.FavoriteFragment;
import com.example.fragmentadvanced.Fragment.HomeFragment;
import com.example.fragmentadvanced.Fragment.SettingsFragment;
import com.google.android.material.tabs.TabLayout;

public class  MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    ViewPager viewPager;
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        viewPager = findViewById(R.id.viewPager);
        tabs = findViewById(R.id.tabs);
        setTabs();
    }

    private void setTabs() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(fragmentManager);
        viewPagerAdapter.addFragment(new HomeFragment(), "Home");
        viewPagerAdapter.addFragment(new FavoriteFragment(), "Favorite");
        viewPagerAdapter.addFragment(new SettingsFragment(), "Settings");

        viewPager.setAdapter(viewPagerAdapter);
        tabs.setupWithViewPager(viewPager);

        tabs.getTabAt(0).setIcon(R.drawable.ic_home);
        tabs.getTabAt(1).setIcon(R.drawable.ic_fav);
        tabs.getTabAt(2).setIcon(R.drawable.ic_settings);
    }
}