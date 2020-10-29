    package com.bdl.mypets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {


    private TabLayout toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        Toolbar ActionBar = findViewById(R.id.actionbar);
        setSupportActionBar(ActionBar);



        setUpViewPager();



    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new RecyclerViewFragmentPerfil());

        return fragments;
    }
    private void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_casa);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_ic);



    }



        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_over, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            switch (item.getItemId()){
                case R.id.Configuracion:
                    Intent intent=new Intent(this, Contacto.class);
                    startActivity(intent);
                    break;

            }
            switch (item.getItemId()){
                case R.id.Config:
                    Intent intent=new Intent(this, Acerca_de.class);
                    startActivity(intent);
                    break;

            }
            switch (item.getItemId()){
                case R.id.btFav:
                    Intent i = new Intent(this, Favorito.class);
                    startActivity(i);
                    break;
            }
            return super.onOptionsItemSelected(item);
        }
    }