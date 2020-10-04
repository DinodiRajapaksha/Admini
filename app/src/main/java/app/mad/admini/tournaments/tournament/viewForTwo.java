package app.mad.admini.tournaments.tournament;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import app.mad.admini.R;

public class viewForTwo extends AppCompatActivity {

    addTournamentDetails addTournamentDetailsO;
    CardView cardb, cardc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_for_two);

        cardb    = findViewById(R.id.cardViewvf2b);
        cardc    = findViewById(R.id.cardViewvf2c);

     //   addTournamentDetailsO = new addTournamentDetails();
       // final String matchid = addTournamentDetailsO.matchID;

        cardb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewForTwo.this, aMatchDetails.class);
                String num =getIntent().getStringExtra("num");
                String matchid =getIntent().getStringExtra("matchID");
                intent.putExtra("matchID", matchid);
                intent.putExtra("num", String.valueOf(num));


                startActivity(intent);

                Log.d("meowww", "matchid"+ matchid);
            }
        });

        cardc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewForTwo.this, aTLUDetails.class);
                String counter =getIntent().getStringExtra("counter");
                intent.putExtra("counter", String.valueOf(counter));

                String matchid =getIntent().getStringExtra("matchID");
                intent.putExtra("matchid", matchid);
                startActivity(intent);
            }
        });

    }
}