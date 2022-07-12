package com.example.foodcurves;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.foodcurves.navdrawer.AboutUsFragment;
import com.example.foodcurves.dashboard.DashBoardFragment;
import com.example.foodcurves.navdrawer.NearByResFragment;
import com.example.foodcurves.navdrawer.SettingsFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation_view);

        menu = navigationView.getMenu();
        menu.findItem(R.id.nav_profile).setVisible(false);
        menu.findItem(R.id.nav_logout).setVisible(false);
        navigationView.bringToFront();

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.openDrawerDesc, R.string.closeDrawerDesc);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        moveToFragment(R.id.nav_container, new DashBoardFragment());
        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            finish();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_home:
            case R.id.nav_profile:
                moveToFragment(R.id.nav_container, new DashBoardFragment());
                break;
            case R.id.nav_restaurant:
                moveToFragment(R.id.nav_container, new NearByResFragment());
                break;
            case R.id.nav_setting:
                moveToFragment(R.id.nav_container, new SettingsFragment());
                break;
            case R.id.nav_about:
                moveToFragment(R.id.nav_container, new AboutUsFragment());
                break;
            case  R.id.nav_login:
                menu.findItem(R.id.nav_login).setVisible(false);
                menu.findItem(R.id.nav_profile).setVisible(true);
                menu.findItem(R.id.nav_logout).setVisible(true);
                break;
            case R.id.nav_logout:
                menu.findItem(R.id.nav_profile).setVisible(false);
                menu.findItem(R.id.nav_logout).setVisible(false);
                menu.findItem(R.id.nav_login).setVisible(true);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void moveToFragment(int containerID, Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(containerID, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(null).commit();
    }

    public void onNotificationClick(View v ){
        moveToFragment(R.id.nav_container, new NearByResFragment());
    }
}