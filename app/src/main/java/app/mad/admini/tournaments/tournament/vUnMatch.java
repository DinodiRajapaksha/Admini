package app.mad.admini.tournaments.tournament;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.databaseHelper;
import app.mad.admini.tournaments.tournament.models.Matches;
import app.mad.admini.tournaments.tournament.models.Tournament;

public class vUnMatch extends AppCompatActivity {

    EditText txteditmStadium, txteditmType, txteditmDate, txteditmTeam1, txteditmTeam2;
    TextView mid;
    Integer midI;
    String tid, matchType, matchDate, stadium, team01, team02, status, midS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_un_match);
        databaseHelper dbh = new databaseHelper(vUnMatch.this);
        Matches matches;
        Tournament tournament;
        tournament = new Tournament();
        matches = new Matches(tid, midI, matchType, matchDate, stadium, team01, team02, status);

        mid = findViewById(R.id.mid);
        txteditmStadium = findViewById(R.id.mStadium);
        txteditmType = findViewById(R.id.mType);
        txteditmDate = findViewById(R.id.mDate);
        txteditmTeam1 = findViewById(R.id.mTeam1);
        txteditmTeam2 = findViewById(R.id.mTeam2);

        midS = getIntent().getStringExtra("numpass");
        tid = getIntent().getStringExtra("tid");

        Log.d("nuxxm00t", tid);
        Log.d("nuxxm00m", midS);

        Cursor c = dbh.getAllMatches(tid, midS);

        if(c.getCount() == 0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else{
            while (c.moveToNext()) {
                midS = c.getString(0);
                tid = c.getString(1);
                matchType = c.getString(2);
                matchDate = c.getString(3);
                stadium = c.getString(4);
                team01 = c.getString(5);
                team02 = c.getString(6);
                status = c.getString(7);
                midI = Integer.parseInt(midS);


                matches.setMid(midI);
                tournament.setTid(tid);
                matches.setMatchType(matchType);
                matches.setMatchdate(matchDate);
                matches.setStadium(stadium);
                matches.setTeam01(team01);
                matches.setTeam02(team02);
                matches.setStatus(status);

            }


            //mid.setText(matches.getMid());
            txteditmStadium.setText(matches.getStadium());
            txteditmType.setText(matches.getMatchType());
            txteditmDate.setText(matches.getMatchdate());
            txteditmTeam1.setText(matches.getTeam01());
            txteditmTeam2.setText(matches.getTeam02());
        }
    }
}