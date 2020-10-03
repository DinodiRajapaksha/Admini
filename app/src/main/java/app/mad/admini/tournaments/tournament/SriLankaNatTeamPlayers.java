package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.adapter.PlayerAdapter;
import app.mad.admini.tournaments.tournament.helper.DataBaseHandlerT;
import app.mad.admini.tournaments.tournament.models.Player;

public class SriLankaNatTeamPlayers extends AppCompatActivity {

    private ListView listView;
    private List<Player> players;
    Context context;
    DataBaseHandlerT dataBaseHandlerT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sri_lanka_nat_team_players);

        context = this;
         listView = findViewById(R.id.listNationalTeam);

         players = new ArrayList<>();

         dataBaseHandlerT = new DataBaseHandlerT(context);

         players = dataBaseHandlerT.getAllPlayers();


         PlayerAdapter adapter = new PlayerAdapter(context,R.layout.single_sl_team,players);

         listView.setAdapter(adapter);




    }
}