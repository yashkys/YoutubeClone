package com.example.youtube_clone;

import android.os.Bundle;

import com.example.youtube_clone.databinding.ActivityHomeBinding;
import com.example.youtube_clone.ui.library.LibraryFragment;
import com.example.youtube_clone.ui.shorts.ShortsFragment;
import com.example.youtube_clone.ui.subscriptions.SubscriptionsFragment;
import com.example.youtube_clone.ui.home.HomeFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replacementFragment(new HomeFragment());

        //setSupportActionBar(binding.toolbar);

//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);

        binding.navView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.navigation_home:
                    replacementFragment(new HomeFragment());
                    break;

                case R.id.navigation_shorts:
                    replacementFragment(new ShortsFragment());
                    break;

                case R.id.navigation_create:
                    //upload code
//                    replacementFragment(new CartFragment());
                    break;

                case R.id.navigation_subscriptions:
                    replacementFragment(new SubscriptionsFragment());
                    break;

                case R.id.navigation_library:
                    replacementFragment(new LibraryFragment());
                    break;
            }
            return true;
        });
    }

    private void replacementFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, fragment);
        fragmentTransaction.commit();
    }

}