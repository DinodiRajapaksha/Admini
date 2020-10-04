package app.mad.admini.tournaments.tournament.howzaat;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.AdminStadium;
import app.mad.admini.tournaments.tournament.MerchList;
import app.mad.admini.tournaments.tournament.NationalTeams;
import app.mad.admini.tournaments.tournament.TicketList;
import app.mad.admini.tournaments.tournament.TournamentList;
import app.mad.admini.tournaments.tournament.UserHome;
import app.mad.admini.tournaments.tournament.UserShop;
import app.mad.admini.tournaments.tournament.UserStadium;
import app.mad.admini.tournaments.tournament.adapter.CustomAdapter;
import app.mad.admini.tournaments.tournament.helper.databaseHelper;

public class matchUI extends AppCompatActivity {

    private RecyclerView matUserRecyclerView;
    databaseHelper dbh;
    uitouRecyclerAdapter uitourecyclerAdapter;
    ArrayList<String> touName, touCountry, fromDate, toDate, tid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchsui);

        matUserRecyclerView = findViewById(R.id.matUserRecyclerView);

        dbh = new databaseHelper(matchUI.this);
        tid        = new ArrayList<>();
        touName    = new ArrayList<>();
        touCountry = new ArrayList<>();
        fromDate   = new ArrayList<>();
        toDate     = new ArrayList<>();

        storeDataInArray();

        uitourecyclerAdapter = new uitouRecyclerAdapter(matchUI.this, this,tid, touName, touCountry, fromDate, toDate);
        matUserRecyclerView.setAdapter(uitourecyclerAdapter);
        matUserRecyclerView.setLayoutManager(new LinearLayoutManager(matchUI.this));

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
                        startActivity(new Intent(getApplicationContext(), tournamentsUI.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArray(){
        Cursor c = dbh.getAllMatchesforUI();
        if(c.getCount() == 0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else{
            while (c.moveToNext()){
                tid.add(c.getString(0));
                touName.add(c.getString(2));
                touCountry.add(c.getString(4));
                fromDate.add(c.getString(5));
                toDate.add(c.getString(6));
            }
        }
        Log.d("dino1", ""+touName);


    }
}
