package app.mad.admini.tournaments.tournament.howzaat;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.AdminStadium;
import app.mad.admini.tournaments.tournament.MerchList;
import app.mad.admini.tournaments.tournament.NationalTeams;
import app.mad.admini.tournaments.tournament.TicketList;
import app.mad.admini.tournaments.tournament.TournamentList;
import app.mad.admini.tournaments.tournament.UserHome;
import app.mad.admini.tournaments.tournament.UserShop;
import app.mad.admini.tournaments.tournament.UserStadium;

public class tournamentsUI extends AppCompatActivity
{

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    TabItem tabChats;
    TabItem tabStatus;
    TabItem tabCalls;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournamentsui);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        //setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.TabLayout);
        tabChats = findViewById(R.id.tabCompleted);
        tabStatus = findViewById(R.id.tabOngoing);
        tabCalls = findViewById(R.id.tabUpcoming);
        viewPager = findViewById(R.id.ViewPagerTou);

        Log.d("baby", "huh");

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomBarNav);
        bottomNavigationView.setSelectedItemId(R.id.ic_tournaments);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_shop:
                        startActivity(new Intent(getApplicationContext(), UserShop.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_stadiums:
                        startActivity(new Intent(getApplicationContext(), UserStadium.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_home:
                        startActivity(new Intent(getApplicationContext(), UserHome.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_teams:
                        startActivity(new Intent(getApplicationContext(), NationalTeams.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_tournaments:
                        return true;
                }
                return false;
            }
        });

    }

}


