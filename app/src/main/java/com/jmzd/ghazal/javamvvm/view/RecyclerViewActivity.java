package com.jmzd.ghazal.javamvvm.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.jmzd.ghazal.javamvvm.R;

public class RecyclerViewActivity extends AppCompatActivity {
    NavController navController;
    Fragment fragment; // back -> ما را از back stack thread خارج می کند.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        fragment = getSupportFragmentManager().findFragmentById(R.id.mainFragment);//back

        navController = Navigation.findNavController(this, R.id.mainFragment);
        NavigationUI.setupActionBarWithNavController(this, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
      //  return super.onSupportNavigateUp();
        return NavigationUI.navigateUp(navController, (DrawerLayout) null);//back // ما اینجا DrawerLayout نداریم ولی گر داشتیم همینجا ازش استفاده میکردیم.
    }
}
