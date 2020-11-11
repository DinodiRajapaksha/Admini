package app.mad.admini.tournaments.tournament;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.databaseHelper;
import app.mad.admini.tournaments.tournament.models.Matches;
import app.mad.admini.tournaments.tournament.models.Tournament;

public class viewForTwo extends AppCompatActivity {
    static viewForTwo INSTANCE;
    String tid;
    addTournamentDetails addTournamentDetailsO;
    CardView cardb, cardc;
    Integer numI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        INSTANCE=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_for_two);


        final databaseHelper dbh = new databaseHelper(viewForTwo.this);
        final Tournament tournament;
        final Matches matches;

        tournament = new Tournament();
        matches = new Matches();


        cardb    = findViewById(R.id.cardViewvf2b);
        cardc    = findViewById(R.id.cardViewvf2c);

     //   addTournamentDetailsO = new addTournamentDetails();
       // final String matchid = addTournamentDetailsO.matchID;

        cardb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewForTwo.this, aMatchDetails.class);
                String num =getIntent().getStringExtra("num");
                tid =getIntent().getStringExtra("tid");

                numI = Integer.parseInt(num);
                for(int x=1; x<=numI ; x++ ){
                    intent.putExtra("tid", tid);
                    intent.putExtra("num", String.valueOf(num));
                    matches.setMid(x);
                    tournament.setTid(tid);
                    dbh.addMat(matches);
                }


                Log.d("ViewForTwosfuckckk", String.valueOf(num));
                Log.d("ViewForTwosfuckckk", tid);
                startActivity(intent);
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

    public static viewForTwo getActivityInstance()
    {
        return INSTANCE;
    }

    public String getData()
    {
        return this.tid;
    }
}