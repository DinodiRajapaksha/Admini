package app.mad.admini.tournaments.tournament;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import app.mad.admini.R;
//import teams.UserTeamCategoty;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainadm);


        CardView card_view  = (CardView) findViewById(R.id.tou);
        CardView card_view1 = (CardView) findViewById(R.id.mat);
        CardView card_view2 = (CardView) findViewById(R.id.store);
        CardView card_view3 = (CardView) findViewById(R.id.tickets);
        CardView card_view4 = (CardView) findViewById(R.id.stadium);
        CardView card_view5 = (CardView) findViewById(R.id.teams);

        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TournamentList.class));
            }
        });
        card_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MerchList.class));
            }
        });
        card_view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TicketList.class));
            }
        });

        // To Stadiums

        card_view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,AdminStadium.class);
                startActivity(intent);
            }
        });


    }
}