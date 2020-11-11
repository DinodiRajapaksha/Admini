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
import app.mad.admini.tournaments.tournament.models.TeamLineUp;
import app.mad.admini.tournaments.tournament.models.Tournament;

public class vUnTLU extends AppCompatActivity {

    TextView tvTLU1, tvTLU2, tvTLU3, tvTLU4, tvTLU5;
    TextView tvTLU6, tvTLU7, tvTLU8, tvTLU9, tvTLU10, tvTLU11;
    TextView mid;
    Integer midI;
    String tid,  playerOne,  playerTwo,  playerThree,
            playerFour,  playerFive,  playerSix,  playerSeven,  playerEight,
            playerNine,  playerTen,  playerEleven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_un_tlu);

        databaseHelper dbh = new databaseHelper(vUnTLU.this);
        Matches matches;
        Tournament tournament;
        tournament = new Tournament();
        TeamLineUp teamLineUp;
        teamLineUp = new TeamLineUp(tid,playerOne, playerTwo,  playerThree,  playerFour,  playerFive,  playerSix,  playerSeven, playerEight,  playerNine,  playerTen,  playerEleven);




        tvTLU1 = findViewById(R.id.tvTLU1);
        tvTLU2 = findViewById(R.id.tvTLU2);
        tvTLU3 = findViewById(R.id.tvTLU3);
        tvTLU4 = findViewById(R.id.tvTLU4);
        tvTLU5 = findViewById(R.id.tvTLU5);
        tvTLU6 = findViewById(R.id.tvTLU6);
        tvTLU7 = findViewById(R.id.tvTLU7);
        tvTLU8 = findViewById(R.id.tvTLU8);
        tvTLU9 = findViewById(R.id.tvTLU9);
        tvTLU10 = findViewById(R.id.tvTLU10);
        tvTLU11 = findViewById(R.id.tvTLU11);

        tid = getIntent().getStringExtra("tid");

        Log.d("nuxxm00t", tid);

        Cursor c = dbh.getAllPlayers(tid);

        if(c.getCount() == 0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else{
            while (c.moveToNext()) {
                tid = c.getString(0);
                playerOne = c.getString(1);
                playerTwo = c.getString(2);
                playerThree = c.getString(3);
                playerFour = c.getString(4);
                playerFive = c.getString(5);
                playerSix = c.getString(6);
                playerSeven = c.getString(7);;
                playerEight = c.getString(8);
                playerNine= c.getString(9);
                playerTen = c.getString(10);
                playerEleven = c.getString(11);


                teamLineUp.setTid(tid);
                teamLineUp.setPlayerOne(playerOne);
                teamLineUp.setPlayerTwo(playerTwo);
                teamLineUp.setPlayerThree(playerThree);
                teamLineUp.setPlayerFour(playerFour);
                teamLineUp.setPlayerFive(playerFive);
                teamLineUp.setPlayerSix(playerSix);
                teamLineUp.setPlayerSeven(playerSeven);
                teamLineUp.setPlayerEight(playerEight);
                teamLineUp.setPlayerNine(playerNine);
                teamLineUp.setPlayerTen(playerTen);
                teamLineUp.setPlayerEleven(playerEleven);
            }


            //mid.setText(matches.getMid());
            tvTLU1.setText(teamLineUp.getPlayerOne());
            tvTLU2.setText(teamLineUp.getPlayerTwo());
            tvTLU3.setText(teamLineUp.getPlayerThree());
            tvTLU4.setText(teamLineUp.getPlayerFour());
            tvTLU5.setText(teamLineUp.getPlayerFive());
            tvTLU6.setText(teamLineUp.getPlayerSix());
            tvTLU7.setText(teamLineUp.getPlayerSeven());
            tvTLU8.setText(teamLineUp.getPlayerEight());
            tvTLU9.setText(teamLineUp.getPlayerNine());
            tvTLU10.setText(teamLineUp.getPlayerTen());
            tvTLU11.setText(teamLineUp.getPlayerEleven());

            Log.d("fix2", teamLineUp.getPlayerEight());
        }
    }
}