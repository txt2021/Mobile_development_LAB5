package ua.kpi.comsys.iv8228;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import ua.kpi.comsys.iv8228.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
       // tabs.getTabAt(0).setIcon(R.drawable.poster_01);
        //tabs.getTabAt(1).setIcon(R.drawable.poster_02);
        //tabs.getTabAt(2).setIcon(R.drawable.poster_03);
        //tabs.getTabAt(3).setIcon(R.drawable.poster_04);
        tabs.setupWithViewPager(viewPager);



    }
}